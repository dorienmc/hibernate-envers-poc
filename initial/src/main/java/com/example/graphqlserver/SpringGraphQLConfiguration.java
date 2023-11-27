package com.example.graphqlserver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Dorien Lorijn
 */
@Configuration
public class SpringGraphQLConfiguration {

    @Bean
    public RequestHeaderInterceptor requestHeaderInterceptor() {
        return new RequestHeaderInterceptor();
    }
}
