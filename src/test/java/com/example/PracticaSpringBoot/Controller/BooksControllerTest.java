package com.example.PracticaSpringBoot.Controller;

import com.example.PracticaSpringBoot.Entities.Books;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BooksControllerTest {

    private  TestRestTemplate testRestTemplate;
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
   @LocalServerPort
    private int port;



    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:"+ port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @Test
    void findAll() {
      ResponseEntity<Books[]> result =
              testRestTemplate.getForEntity("/api/books", Books[].class);

      assertEquals(HttpStatus.OK, result.getStatusCode());
      List<Books> list=  Arrays.asList(result.getBody());

    }

    @Test
    void getfindById() {
        ResponseEntity<Books> result=
                testRestTemplate.getForEntity("/api/books/1", Books.class);
        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
    }

    @Test
    void createBook() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        String json = """
{
"id": null,
"title":"Libro numero 1",
"author":"Rutito2010",
"pages":200,
"price":10.99,
"description":"Libro test",
"date":"2015-02-25"
}
 """;

        HttpEntity<String> request=  new HttpEntity<>(json, headers);
         ResponseEntity<Books> response = testRestTemplate.exchange("/api/books",HttpMethod.POST,request,Books.class);
             Books result= response.getBody();
       assertEquals(1L,result.getId());
       assertEquals("Libro numero 1", result.getTitle());
    }
}