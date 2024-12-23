package org.example.fileStore.local;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@ConditionalOnProperty(name = "file.store", havingValue = "local")
public class LocalFileStoreConfig {

    @Bean
    public LocalFileStore localFileStore() {
        return new LocalFileStore();
    }
}
