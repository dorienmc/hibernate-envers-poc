package com.example.graphqlserver;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Enum containing keys for the context provided by different environments
 */
public enum ContextKey {

    REQUEST_ID(Headers.REQUEST_ID_HEADER),
    USER_ID(Headers.USER_ID_HEADER),
    ACTION_NAME(Headers.ACTION_NAME_HEADER);


    private final String header;

    ContextKey(String header) {
        this.header = header;
    }

    public String getHeader() {
        return header;
    }

    public static ContextKey byHeader(String header) {
        return Arrays.stream(ContextKey.values())
                .filter(k -> k.getHeader().equals(header))
                .findFirst()
                .orElse(null);
    }

    public static Set<String> keys() {
        return Arrays.stream(ContextKey.values()).map(ContextKey::getHeader).collect(Collectors.toSet());
    }

    /**
     * Header names used in the different API's.
     */
    static final class Headers {
        private static final String REQUEST_ID_HEADER = "X-Request-ID";
        private static final String USER_ID_HEADER = "user-id";
        protected static final String ACTION_NAME_HEADER = "action-name";
    }
}
