package com.example.graphqlserver;

import org.hibernate.envers.RevisionListener;

import com.example.graphqlserver.entity.AuditRevisionEntry;

/**
 * TODO: Description
 * @author Dorien Lorijn
 */
public class AuditRevisionListener implements RevisionListener {

    @Override
    public void newRevision(Object revisionEntity) {
        String currentUser = "tmp";

        AuditRevisionEntry audit = (AuditRevisionEntry) revisionEntity;
        audit.setUser(currentUser);
    }
}
