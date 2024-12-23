package org.example.methodsecuritydemo.service;

import org.example.methodsecuritydemo.ds.Document;
import org.example.methodsecuritydemo.repository.DocumentRepository;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {

    private final DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

//    @PostAuthorize("hasPermission(returnObject, 'ROLE_ADMIN')")
//    public Document getDocument(String id) {
//       return documentRepository.getDocument(id);
//    }

    @PreAuthorize("hasPermission(#id, 'document', 'ROLE_ADMIN')")
    public Document getDocument(String  id) {
        return documentRepository.getDocument(id);
    }
}
