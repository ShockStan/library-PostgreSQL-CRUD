package com.library.jpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@RequestMapping("/api/library")
public class BookController {
    @Autowired
    private LibraryRepository librepo;
    @GetMapping("/allbooks")
    public List<BookEntity> getAllBooks(){
        return librepo.findAll();
    }
    @GetMapping("/getbook/{book_id}")
    public BookEntity getBookById(@PathVariable(value = "book_id") Integer book_id){
        return librepo.findById(book_id).get();
    }
    @PostMapping("/createbook")
    public BookEntity createBook(@RequestBody BookEntity book){
        return librepo.save(book);
    }
    @PutMapping("/update/{book_id}")
    public ResponseEntity<BookEntity> updateBook(@PathVariable(value = "book_id") Integer book_id, @RequestBody BookEntity bookDetails){
        BookEntity book = librepo.findById(book_id).get();
        book.setBook_name(bookDetails.getBook_name());
        book.setAuthor(bookDetails.getAuthor());
        book.setLanguage(bookDetails.getLanguage());
        book.setScanned(bookDetails.getScanned());

        return ResponseEntity.ok(librepo.save(book));
    }

    @DeleteMapping("/delete/{book_id}")
    public Map<String, Boolean> deleteBook(@PathVariable(value = "book_id") Integer book_id){
        librepo.delete(librepo.findById(book_id).get());
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return response;
    }
}
