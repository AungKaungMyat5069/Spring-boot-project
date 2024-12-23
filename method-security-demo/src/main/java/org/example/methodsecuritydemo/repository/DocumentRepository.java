package org.example.methodsecuritydemo.repository;

import org.example.methodsecuritydemo.ds.Document;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class DocumentRepository {

    private Map<String , Document> documents =
            Map.of(
                    "abc123", new Document("john"),
                    "bff455", new Document("john"),
                    "htt489", new Document("mary")
            );

    public Document getDocument(String id) {
        return documents.get(id);
    }
}
