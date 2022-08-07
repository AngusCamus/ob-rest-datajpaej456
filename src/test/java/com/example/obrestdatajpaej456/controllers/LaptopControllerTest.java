package com.example.obrestdatajpaej456.controllers;

import com.example.obrestdatajpaej456.entities.Laptop;
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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaptopControllerTest {


    private TestRestTemplate testRestTemplate;
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);

    }

    @Test
    void findAll() {
        ResponseEntity<Laptop[]> response = testRestTemplate.getForEntity("/api/laptops", Laptop[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        List<Laptop> laptops = Arrays.asList(response.getBody());

    }

    @Test
    void create() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                
                {
                  "manufacturer": "Dell",
                  "color": "Blue",
                  "screenSize": 17
                }
                
                
                
                """;
        HttpEntity<String> request = new HttpEntity<>(json, headers);

        ResponseEntity<Laptop> response =
                testRestTemplate.exchange("/api/laptops", HttpMethod.POST, request , Laptop.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        Laptop result = response.getBody();
        assertEquals("Dell", result.getManufacturer());


    }

    @Test
    void findOneById() {
        ResponseEntity<Laptop> response = testRestTemplate.getForEntity("/api/laptops/1", Laptop.class);
        //assertTrue(response.getBod);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

    }

    @Test
    void update() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                
                {
                  "id": 1,
                  "manufacturer": "Dell",
                  "color": "Blue",
                  "screenSize": 17
                }
                
                
                
                """;
        HttpEntity<String> request = new HttpEntity<>(json, headers);

        ResponseEntity<Laptop> response =
                testRestTemplate.exchange("/api/laptops/1", HttpMethod.PUT, request , Laptop.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        Laptop result = response.getBody();
        assertEquals("Dell", result.getManufacturer());




    }

    @Test
    void delete() {
        ResponseEntity<Laptop> response = testRestTemplate.getForEntity("/api/laptops/", Laptop.class);
        ResponseEntity<Laptop> response2 = testRestTemplate.getForEntity("/api/laptops/5", Laptop.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(HttpStatus.NOT_FOUND, response2.getStatusCode());
    }

    @Test
    void deleteAll() {
        ResponseEntity<Laptop> response = testRestTemplate.getForEntity("/api/laptops/1", Laptop.class);
        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
    }
}