package com.graphql.graphqldemo.datafetcher;

import com.graphql.graphqldemo.client.BookSummaryClient;
import com.graphql.graphqldemo.entity.Book;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@DgsComponent
public class FindsDataFetcher {

    private final BookSummaryClient bookSummaryClient;

    public FindsDataFetcher(BookSummaryClient bookSummaryClient) {
        this.bookSummaryClient = bookSummaryClient;
    }

    @DgsQuery
    public List<Book> finds(@InputArgument("titleFilter") String titleFilter) {
        if (titleFilter == null) {
            return bookSummaryClient.showAllBooks();
        }

//        System.out.println("query"+bookService.findBookByTitle(titleFilter));
        return bookSummaryClient.findBooksByTitle(titleFilter);
    }
}
