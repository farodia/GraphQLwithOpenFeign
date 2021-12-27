package com.graphql.graphqldemo.client;

import com.graphql.graphqldemo.dto.BookDTO;
import com.graphql.graphqldemo.entity.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "summary", url = "${base.url.http}")
public interface BookSummaryClient {
    @PostMapping
    void addBook(@RequestBody BookDTO bookRequestDTO);

    @GetMapping("/books")
    @ResponseStatus(HttpStatus.OK)
    List<Book> showAllBooks();

    @GetMapping(value = "/{title}")
    List<Book> findBooksByTitle(@PathVariable("title") String title);
}
