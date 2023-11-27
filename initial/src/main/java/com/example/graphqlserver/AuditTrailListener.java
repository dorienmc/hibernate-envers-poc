package com.example.graphqlserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.graphqlserver.entity.BaseEntity;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;

/**
 * @author Dorien Lorijn
 */
public class AuditTrailListener {
    private static final Logger logger = LoggerFactory.getLogger(AuditTrailListener.class);

    @PrePersist
    @PreUpdate
    @PreRemove
    private void beforeAnyUpdate(Object object) {
        if (object instanceof BaseEntity) {
            var entity = (BaseEntity)object;
            var entityType = entity.getClass().getSimpleName();
            if (entity.getId() == null) {
                logger.info(String.format("[%s AUDIT] About to add a %s", entityType.toUpperCase(), entityType));
            }
            else {
                logger.info(String.format("[%s AUDIT] About to update/delete %s: %s (version: %d)", entityType.toUpperCase(), entityType, entity.getId(),
                        entity.getVersion()));
            }

            sendAudit(entity);
        }
    }

    @PostPersist
    @PostUpdate
    @PostRemove
    private void afterAnyUpdate(Object object) {
        if (object instanceof BaseEntity) {
            var entity = (BaseEntity)object;
            var entityType = entity.getClass().getSimpleName();
            logger.info(String.format("[%s AUDIT] add/update/delete complete for %s: %s (version: %d)", entityType.toUpperCase(), entityType, entity.getId(),
                    entity.getVersion()));

            sendAudit(entity);
        }
    }

    @PostLoad
    private void afterLoad(Object object) {
        if (object instanceof BaseEntity) {
            var entity = (BaseEntity)object;
            var entityType = entity.getClass().getSimpleName();
            logger.info(String.format("[%s AUDIT] %s loaded from database: %s", entityType.toUpperCase(), entityType, entity.getId()));

            sendAudit(entity);
        }
    }

    private void sendAudit(BaseEntity entity) {
        // TODO: Store auditEntity with context info (request id, user id, action name) + current entity (id, version, class)
        // Or send a kafka event directly?
    }
}
