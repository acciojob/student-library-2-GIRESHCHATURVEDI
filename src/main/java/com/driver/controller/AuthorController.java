package com.driver.controller;

//Add required annotations

import com.driver.models.Author;
import com.driver.services.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("author")
public class AuthorController {

    @Autowired
    AuthorService authorService ;
    //Write createAuthor API with required annotations
    @PostMapping("/createAuthor")
    public ResponseEntity<String> createAuthor(Author author){
        authorService.create(author);
     return new ResponseEntity("Success", HttpStatus.CREATED);
    }
}
