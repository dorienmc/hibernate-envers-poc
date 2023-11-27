package com.example.graphqlserver;

import org.hibernate.envers.RevisionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.example.graphqlserver.entity.AuditRevisionEntry;

/**
 * @author Dorien Lorijn
 */
public class AuditRevisionListener implements RevisionListener {

    private static final Logger logger = LoggerFactory.getLogger(AuditRevisionListener.class);

    @Override
    public void newRevision(Object revisionEntity) {
        var requestAttributes = RequestContextHolder.currentRequestAttributes();
        var headerName = ContextKey.USER_ID.getHeader();
        var currentUser = requestAttributes.getAttribute(headerName, RequestAttributes.SCOPE_SESSION);
        if(currentUser == null) {
            currentUser = "unknown";
        }
        logger.info(String.format("Retrieving %s: %s from the context", headerName, currentUser));

        AuditRevisionEntry audit = (AuditRevisionEntry) revisionEntity;
        audit.setUser(currentUser.toString());
    }
}
