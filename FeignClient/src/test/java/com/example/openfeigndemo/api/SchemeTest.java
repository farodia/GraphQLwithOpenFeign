package com.example.openfeigndemo.api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static io.restassured.RestAssured.get;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class SchemeTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() throws Exception {
        RestAssured.port = port;
    }

    @Test
    void should_get_matching_scheme_when_get_show_all_books_response() {
        get("/books").then().assertThat().body(matchesJsonSchemaInClasspath
                ("booksummary.json")).statusCode(500);
    }
}
