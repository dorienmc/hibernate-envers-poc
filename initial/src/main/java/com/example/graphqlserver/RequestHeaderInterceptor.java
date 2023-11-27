package com.example.graphqlserver;

import java.util.Arrays;
import java.util.List;

import graphql.language.Field;
import graphql.language.OperationDefinition;
import graphql.parser.Parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.graphql.server.WebGraphQlInterceptor;
import org.springframework.graphql.server.WebGraphQlRequest;
import org.springframework.graphql.server.WebGraphQlResponse;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import static com.example.graphqlserver.ContextKey.Headers.ACTION_NAME_HEADER;
import reactor.core.publisher.Mono;
/**
 * Based on RequestHeaderInterceptor in nefeli commons (maar dan uitgekleed)
 * @author Dorien Lorijn
 */
public class RequestHeaderInterceptor implements WebGraphQlInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(RequestHeaderInterceptor.class);

    @Override
    public Mono<WebGraphQlResponse> intercept(WebGraphQlRequest request, Chain chain) {
        Arrays.stream(ContextKey.values())
                .filter( it -> it != ContextKey.ACTION_NAME)
                .map(it -> it.getHeader())
                .forEach( name ->
                    addDataToContext(name, request.getHeaders().getFirst(name))
                );

        List<OperationDefinition> definitions = Parser.parse(request.getDocument()).getDefinitionsOfType(OperationDefinition.class).stream()
                .filter( it -> it.getOperation().equals(OperationDefinition.Operation.MUTATION))
                .toList();

        if (definitions.size() == 1) {
            var fields = definitions.get(0).getSelectionSet().getSelections().stream()
                    .filter(Field.class::isInstance)
                    .filter( it -> !((Field)it).getName().startsWith("_"))
                    .toList();

            if (fields.size() == 1) {
                Field operationField = (Field)fields.get(0);
                addDataToContext(ACTION_NAME_HEADER, operationField.getName());
            }
        }

        try {
            return chain.next(request);
        } finally {
            ContextKey.keys().forEach(MDC::remove);
        }

    }

    private void addDataToContext(String headerName, String value) {
        var requestAttributes = RequestContextHolder.currentRequestAttributes();
        logger.info(String.format("Adding %s: %s to the context", headerName, value));

        MDC.put(headerName, value);
        requestAttributes.setAttribute(headerName, value, RequestAttributes.SCOPE_SESSION);
        RequestContextHolder.setRequestAttributes(requestAttributes, true);
    }
}

