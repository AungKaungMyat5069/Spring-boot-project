package org.example.methodsecuritydemo.evaluator;

import org.example.methodsecuritydemo.ds.Document;
import org.example.methodsecuritydemo.repository.DocumentRepository;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.security.Permission;

//this method is Post
@Component
public class DocumentPermissionEvaluator implements PermissionEvaluator {

    private final DocumentRepository documentRepository;

    public DocumentPermissionEvaluator(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        Document document = (Document) targetDomainObject;
        String permit = (String) permission;
        //anyMatch is like Or
        // allMatch is like And
        // none Match is not
        boolean admin = authentication.getAuthorities().stream().anyMatch(g -> g.getAuthority().equals(permit));
        return admin || document.getOwner().equals(authentication.getName());
    }

    // this method is Pre
    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        String code = (String) targetId;
        String permit = (String) permission;
        Document document = documentRepository.getDocument(code);
        boolean admin = authentication.getAuthorities().stream().anyMatch(g -> g.getAuthority().equals(permit));
        return admin || document.getOwner().equals(authentication.getName());
    }
}
