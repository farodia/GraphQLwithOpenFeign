package com.example.openfeigndemo.controller;

import com.example.openfeigndemo.dto.BookSummaryDTO;
import com.example.openfeigndemo.entity.Book;
import com.example.openfeigndemo.service.BookSummaryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class BookSummaryController {
    private final BookSummaryService bookSummaryService;

    public BookSummaryController(BookSummaryService bookSummaryService) {
        this.bookSummaryService = bookSummaryService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addBook(@RequestBody BookSummaryDTO bookRequestDTO) {
        bookSummaryService.createBookSummary(bookRequestDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Book> showAllBooks() {
        return bookSummaryService.findAllBooks();
    }

    @GetMapping("/{title}")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> findBookByTitle(@PathVariable("title") String title) {
        return bookSummaryService.findBookByTitle(title);
    }
}
