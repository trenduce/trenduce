package com.trenduce.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by prafulmantale on 1/4/15.
 */
@Configuration
@EnableMongoRepositories("com.trenduce.repositories")
public class MongoConfig  extends AbstractMongoConfiguration{

    private static final String dbName = "trenduce";
    private static final String mongoHost = "localhost";
    private static final int mongoPort = 27017;

    @Override
    protected String getDatabaseName() {
        return dbName;
    }

    @Override
    public Mongo mongo() throws Exception {
        MongoClient mongoClient = new MongoClient(mongoHost, mongoPort);
        mongoClient.setWriteConcern(WriteConcern.NORMAL);

        return mongoClient;
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception{

        return new MongoTemplate(mongo(), getDatabaseName());
    }
}
