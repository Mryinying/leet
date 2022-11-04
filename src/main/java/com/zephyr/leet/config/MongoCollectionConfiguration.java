package com.zephyr.leet.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

//@Configuration
//@EnableReactiveMongoRepositories
public class MongoCollectionConfiguration {

//    @Bean
//    public CommandLineRunner initData(MongoOperations mongoOperations) {
//        return (String... args) -> {
//            mongoOperations.dropCollection(PipelineUser.class);
//            mongoOperations.createCollection(PipelineUser.class, CollectionOptions.empty().maxDocuments(500).size(500000000).capped());
//        };
//    }

}
