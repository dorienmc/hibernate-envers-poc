package com.example.graphqlserver.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author Dorien Lorijn
 */

@Table(name = "audits")
public class AuditEntry {

    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private String userId;

    @Column
    private String actionName;

    @Column
    private String requestId;

    @Column
    private String entityType;

    @Column
    private String entityId;

    @Column
    private String entityVersion;

    public AuditEntry(String userId, String actionName, String requestId, String entityType, String entityId, String entityVersion) {
        this.userId = userId;
        this.actionName = actionName;
        this.requestId = requestId;
        this.entityType = entityType;
        this.entityId = entityId;
        this.entityVersion = entityVersion;
    }
}
