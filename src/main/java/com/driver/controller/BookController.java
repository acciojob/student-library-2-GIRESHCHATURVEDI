package com.driver.controller;

import com.driver.models.Book;
import com.driver.services.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Add required annotations
@RestController
@RequestMapping("book")

public class BookController {


    //Write createBook API with required annotations
    @Autowired
    BookService bookSerivce ;
    //Add required annotations
    @PostMapping("/createBooks")
    public ResponseEntity<String> createBook(@RequestBody Book book){
        bookSerivce.createBook(book) ;
        return new ResponseEntity<>("Sucess",HttpStatus.CREATED);
    }
    @GetMapping("/getBooks")
    public ResponseEntity getBooks(@RequestParam(value = "genre", required = false) String genre,
                                   @RequestParam(value = "available", required = false, defaultValue = "false") boolean available,
                                   @RequestParam(value = "author", required = false) String author){

        List<Book> bookList =  bookSerivce.getBooks(genre , available,author) ;
        //find the elements of the list by yourself

        return new ResponseEntity<>(bookList, HttpStatus.OK);

    }
}
