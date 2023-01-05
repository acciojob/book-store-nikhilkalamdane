package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    BookService bookService;

    // One example controller, make the rest by yourself
    @PostMapping("/create-book")
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        Book newbook = bookService.createBook(book);
        return new ResponseEntity<>(newbook, HttpStatus.CREATED);
    }

    @GetMapping("/get-book-by-id/{id}")
    public ResponseEntity<Book> findBookById(@PathVariable("id") String id){
        return new ResponseEntity<>(bookService.findBookById(id), HttpStatus.FOUND);
    }

    @GetMapping("/get-all-books")
    public ResponseEntity<List<Book>> findAllBooks(){
        return new ResponseEntity<>(bookService.findAllBooks(), HttpStatus.FOUND);
    }

    @DeleteMapping("/delete-book-by-id/{id}")
    public ResponseEntity deleteBookById(@PathVariable("id") String id){
        bookService.deleteBookById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete-all-books")
    public ResponseEntity deleteAllBooks(){
        bookService.deleteAllBooks();
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/get-books-by-author?author=author+name")
    public ResponseEntity<List<Book>> findBooksByAuthor(@RequestParam("author") String author){
        List<Book>  list = bookService.findBooksByAuthor(author);
        return new ResponseEntity<>(list, HttpStatus.FOUND);
    }

    @GetMapping("/get-books-by-genre?genre=genre+name")
    public ResponseEntity<List<Book>> findBooksByGenre(@RequestParam("genre") String genre){
        List<Book>  list = bookService.findBooksByGenre(genre);
        return new ResponseEntity<>(list, HttpStatus.FOUND);
    }

}
