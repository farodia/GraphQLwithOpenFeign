package com.example.openfeigndemo;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

/*
    Both BookRepository and BookSummaryService will reuse the same mongoDB container
*/
@SpringBootTest(webEnvironment = RANDOM_PORT)
public abstract class BasicMongoTestContainer {
    static final MongoDBContainer mongoDBContainer;
    static{
        mongoDBContainer = new MongoDBContainer("mongo:5.0.4").withReuse(true);
        mongoDBContainer.start();
    }
    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry){
        registry.add("spring.data.mongodb.uri",mongoDBContainer::getReplicaSetUrl);
        System.out.println("setUrl"+mongoDBContainer.getReplicaSetUrl());
    }
}
