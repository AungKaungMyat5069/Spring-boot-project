package org.example.methodsecuritydemo.controller;

import org.example.methodsecuritydemo.ds.Document;
import org.example.methodsecuritydemo.service.DocumentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocumentController {

    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping("/document/{code}")
    public Document document(@PathVariable("code") String code) {
        return documentService.getDocument(code);
    }
}
