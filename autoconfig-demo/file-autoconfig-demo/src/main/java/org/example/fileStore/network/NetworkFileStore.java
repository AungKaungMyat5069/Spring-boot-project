package org.example.fileStore.network;

import org.example.fileStore.FileStore;

public class NetworkFileStore implements FileStore {

    @Override
    public void fileStore() {
        System.out.println("Network File Store");
    }
}
