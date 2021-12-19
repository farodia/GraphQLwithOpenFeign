package com.example.openfeigndemo.repository;

import com.example.openfeigndemo.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book,String> {
    List<Book> findBookByTitleRegex(String title);

    @Override
    List<Book> findAll();
}
