package com.example.graphqlserver.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.graphqlserver.entity.AuditEntry;

/**
 * @author Dorien Lorijn
 */

@Repository
public interface AuditEntryRepository extends JpaRepository<AuditEntry, UUID> {

}
