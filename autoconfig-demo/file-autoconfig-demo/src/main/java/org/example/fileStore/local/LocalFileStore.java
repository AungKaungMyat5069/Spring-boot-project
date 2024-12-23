package org.example.fileStore.local;

import org.example.fileStore.FileStore;

public class LocalFileStore implements FileStore {
    @Override
    public void fileStore() {
        System.out.println("Local File Store");
    }
}
