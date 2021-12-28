package com.example.openfeigndemo.controller;

import com.example.openfeigndemo.dto.BookSummaryDTO;
import com.example.openfeigndemo.entity.Book;
import com.example.openfeigndemo.service.BookSummaryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookSummaryController.class)
public class BookSummaryControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Value("${base.url}")
    private String url;

    @MockBean
    private BookSummaryService bookSummaryService;


    @Test
    public void add_book() throws Exception {
        BookSummaryDTO mockBook = BookSummaryDTO.builder().isn("1").title("mock title1").summary("mock summary1").build();
        doNothing().when(bookSummaryService).createBookSummary(mockBook);
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        java.lang.String requestJson = ow.writeValueAsString(mockBook);

        mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON).content(requestJson)).andExpect(status().isCreated());

    }

    @Test
    public void show_books() throws Exception {
        List<Book> books = Arrays.asList(
                Book.builder().isn("1").title("mock title1").summary("mock summary1").build(),
                Book.builder().isn("2").title("mock title2").summary("mock summary2").build()
        );
        when(bookSummaryService.findAllBooks())
                .thenReturn(books);
        mockMvc.perform(get(url+"/books")).andExpect(status().isOk());
    }
}
