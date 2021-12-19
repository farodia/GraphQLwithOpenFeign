package com.example.openfeigndemo.service;

import com.example.openfeigndemo.dto.BookSummaryDTO;
import com.example.openfeigndemo.entity.Book;
import com.example.openfeigndemo.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookSummaryService {
    private final BookRepository bookRepository;

    public BookSummaryService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void createBookSummary(BookSummaryDTO bookDTO){
        Book newBook = Book.builder().isn(bookDTO.getIsn()).title(bookDTO.getTitle()).summary(bookDTO.getSummary()).build();
        bookRepository.insert(newBook);
    }

    public List<Book> findBookByTitle(String title){
        return bookRepository.findBookByTitleRegex(title);
    }

    public List<Book> findAllBooks(){
        System.out.println("service:"+bookRepository.findAll().get(0));
        return bookRepository.findAll();
    }
}
