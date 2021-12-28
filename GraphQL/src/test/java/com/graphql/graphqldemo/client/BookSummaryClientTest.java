package com.graphql.graphqldemo.client;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.graphql.graphqldemo.datafetcher.FindsDataFetcher;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("test")
class BookSummaryClientTest {
    private static WireMockServer wireMockServer;

    @Autowired
    private FindsDataFetcher findsDataFetcher;

    @BeforeAll
    static void init(){
        wireMockServer = new WireMockServer(
                new WireMockConfiguration().port(7071)
        );
        wireMockServer.start();
        WireMock.configureFor("localhost",7071);
    }

    @AfterAll
    static void end(){
        wireMockServer.stop();
    }

    @Test
    void showAllBooks() {
        stubFor(WireMock.get(urlMatching("/books")).willReturn(aResponse().withStatus(OK.value())));
        findsDataFetcher.finds(null);  // when title filter is null will show all books
        verify(getRequestedFor(urlPathEqualTo("/books")));
    }


    @Test
    void findBooksByTitle() {
        stubFor(WireMock.get(urlMatching("/mockTitle")).willReturn(aResponse().withStatus(OK.value())));
        findsDataFetcher.finds("mockTitle");
        verify(getRequestedFor(urlPathEqualTo("/mockTitle")));
    }
}