package com.example.graphqlserver.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.graphqlserver.entity.AuditEntry;
import com.example.graphqlserver.repository.AuditEntryRepository;

/**
 * TODO: Description
 * @author Dorien Lorijn
 */
@Service
public class AuditService {

    private final AuditEntryRepository auditEntryRepository;

    public AuditService(AuditEntryRepository auditEntryRepository) {
        this.auditEntryRepository = auditEntryRepository;
    }

    public AuditEntry create(AuditEntry entry) { return auditEntryRepository.save(entry); }

    public AuditEntry update(AuditEntry entry) { return auditEntryRepository.save(entry); }

    public void delete(AuditEntry entry) { auditEntryRepository.delete(entry); }

    public List<AuditEntry> findAll() { return auditEntryRepository.findAll(); }

}
