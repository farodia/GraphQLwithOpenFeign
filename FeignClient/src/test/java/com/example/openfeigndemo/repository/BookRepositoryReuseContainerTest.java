package com.example.openfeigndemo.repository;

import com.example.openfeigndemo.BasicMongoTestContainer;
import com.example.openfeigndemo.entity.Book;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BookRepositoryReuseContainerTest extends BasicMongoTestContainer {
    @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    void setUp() {
        this.bookRepository.save(new Book("1","Math","this is the version1.0"));
        this.bookRepository.save(new Book("2","Math","this is the version2.0"));
        this.bookRepository.save(new Book("3","on Java 8","this is technical book"));
    }

    @AfterEach
    void cleanUp() {
        this.bookRepository.deleteAll();
    }

    @Test
    void should_return_list_of_books_with_title_regex(){
        List<Book> books = bookRepository.findBookByTitleRegex("Math");
        assertThat(books.size()).isEqualTo(2);
    }

    @Test
    void should_return_list_of_all_books() {
        List<Book> books = bookRepository.findAll();
        assertThat(books.size()).isEqualTo(3);
    }
}
