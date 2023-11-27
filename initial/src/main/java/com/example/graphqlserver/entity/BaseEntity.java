package com.example.graphqlserver.entity;

import java.util.UUID;

/**
 * @author Dorien Lorijn
 */
public interface BaseEntity {

    UUID getId();

    long getVersion();
}
