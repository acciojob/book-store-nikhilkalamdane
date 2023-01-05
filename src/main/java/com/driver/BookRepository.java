package com.driver;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    HashMap<Integer, Book> bookDB;

    private int id;

    public BookRepository(){
        bookDB = new HashMap<>();
        this.id = 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book save(Book book){
        book.setId(this.id);
        bookDB.put(book.getId(), book);
        setId(getId() + 1);
        return book;
    }

    public Book findBookById(int id){
        return bookDB.get(id);
    }

    public List<Book> findAll(){
        List<Book> list = new ArrayList<>();
        for(Book b: bookDB.values()){
            list.add(b);
        }
        return list;
    }

    public void deleteBookById(int id){
        bookDB.remove(id);
        return;
    }

    public void deleteAll(){
        bookDB.clear();
        return;
    }

    public List<Book> findBooksByAuthor(String author){
        return null;
    }

    public List<Book> findBooksByGenre(String genre){
        return null;
    }
}
