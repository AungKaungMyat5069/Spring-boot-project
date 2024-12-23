package org.example.fileStore.network;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@ConditionalOnProperty(name = "file.store", havingValue = "network")
public class NetworkFileStoreConfig {

    @Bean
    public NetworkFileStore networkFileStore() {
        return new NetworkFileStore();
    }

}
