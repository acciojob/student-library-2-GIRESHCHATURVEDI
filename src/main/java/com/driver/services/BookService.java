package com.driver.services;

import com.driver.models.Author;
import com.driver.models.Book;
import com.driver.models.Card;
import com.driver.repositories.AuthorRepository;
import com.driver.repositories.BookRepository;
import com.driver.repositories.CardRepository;
import com.driver.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {


    @Autowired
    BookRepository bookRepository2;
    @Autowired
    AuthorRepository authorRepository ;
    @Autowired
    CardRepository cardRepository ;
    @Autowired
    TransactionRepository transactionRepository ;

    public void createBook(Book book){
        Author author = authorRepository.findById(book.getAuthor().getId()).get();
        Card card = cardRepository.findById(book.getCard().getId()).get();
        book.setAuthor(author);
        book.setAvailable(true) ;
        book.setCard(card) ;
        bookRepository2.save(book);
    }

    public List<Book> getBooks(String genre, boolean available, String author){
        List<Book> books = new ArrayList<>() ;
        if(genre!=null && available==true){
            books.add((Book) bookRepository2.findBooksByGenre(genre , true));
            books.add((Book) bookRepository2.findBooksByGenreAuthor(genre , null , true)) ;
        }
        else if(genre!=null && author!=null && available==false ){
            books.add((Book) bookRepository2.findBooksByGenre(genre , false)) ;
            books.add((Book) bookRepository2.findByAvailability(false) );
        }
        return books;
    }
}
