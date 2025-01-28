package com.security.springSecurity.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
@RequestMapping("/public")
public class ApiController {

    @Value("${url.baseUrl}")
    private String baseUrl;

    @Value(("${url.teams}"))
    private String collectionName;

    private final RestClient restClient;

    public ApiController(RestClient restClient) {
        this.restClient = restClient;
    }

    @GetMapping("/greet")
    ResponseEntity<String> greetings(){
       return ResponseEntity.status(HttpStatus.OK).body("Hello User.");
    }

    @GetMapping("/naruto")
    ResponseEntity<String> getAllakatsukiData(String url){
        ResponseEntity<String> entity = restClient.get()
                .uri(baseUrl+collectionName)
                .retrieve()
                .toEntity(String.class);

        return entity;

    }


}
