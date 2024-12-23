package org.example.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import javax.sql.DataSource;

@AutoConfiguration
@ConditionalOnClass({org.hsqldb.Database.class})//if this class is existed, bean will have
public class DataSourceConfig {

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .generateUniqueName(true)
                .setScriptEncoding("utf-8")
                .addScript("my-schema.sql")
                .addScript("my-data.sql")
                .build();
        // my-schema.sql and my-data.sql can not be read unless import properties
    }
}
