package com.example.openfeigndemo.service;

import com.example.openfeigndemo.dto.BookSummaryDTO;
import com.example.openfeigndemo.entity.Book;
import com.example.openfeigndemo.repository.BookRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

//@Testcontainers
//@DataMongoTest(excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
//class BookSummaryServiceTest {
//    @Container
//    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:5.0.4");
//
//    @DynamicPropertySource
//    static void setProperties(DynamicPropertyRegistry registry){
//        registry.add("spring.data.mongodb.uri",mongoDBContainer::getReplicaSetUrl);
//        System.out.println("setUrl"+mongoDBContainer.getReplicaSetUrl());
//    }
//
//    @Autowired
//    private BookRepository bookRepository;
//
//    private BookSummaryService bookSummaryService;
//
//
//    @BeforeEach
//    void setUp() {
//        this.bookSummaryService = new BookSummaryService(bookRepository);
//        bookRepository.save(new Book("1","Math","this is the version1.0"));
//        bookRepository.save(new Book("2","Math","this is the version2.0"));
//        bookRepository.save(new Book("3","Lalaland","this is another book"));
//    }
//
//    @AfterEach
//    void cleanUp(){
//        bookRepository.deleteAll();
//    }
//
//    @Test
//    void should_return_3_books_when_create_successfully() {
//        BookSummaryDTO bookSummaryDTO = new BookSummaryDTO("4","on Java 8","this is a technical book");
//        bookSummaryService.createBookSummary(bookSummaryDTO);
//        List<Book> books = bookRepository.findAll();
//        assertThat(books.size()).isEqualTo(4);
//    }
//
//    @Test
//    void should_return_2_books_when_find_book_by_title() {
//        List<Book> books = bookSummaryService.findBookByTitle("Math");
//        assertThat(books.size()).isEqualTo(2);
//    }
//
//    @Test
//    void should_return_3_books_when_find_all_books() {
//        List<Book> books = bookSummaryService.findAllBooks();
//        assertThat(books.size()).isEqualTo(3);
//    }
//}