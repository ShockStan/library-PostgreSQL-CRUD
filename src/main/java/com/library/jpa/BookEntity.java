package com.library.jpa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "library_books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity {
    @Id
    private Integer book_id;
    @Column(name = "book_name", nullable = false)
    private String book_name;
    @Column(name = "author")
    private String author;
    @Column(name = "language")
    private String language;
    @Column(name = "scanned")
    private Integer scanned;
    @Override
    public String toString(){
        return "Book [ "+book_id+" , "+book_name+" , "+author+" , "+language+" , "+scanned+" ]";
    }
}
