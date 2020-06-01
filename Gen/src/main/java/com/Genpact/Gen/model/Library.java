package com.Genpact.Gen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Librarys")
public class Library {

    private long id;
    private String libraryName;


    public Library() {

    }

    public Library(String libraryName) {
        this.libraryName = libraryName;

    }

    @OneToMany(mappedBy = "library")
    private List<Book> bookList;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "library_name", nullable = false)
    public String getlibraryName() {
        return libraryName;
    }
    public void getlibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public List<Book> getBookList() {
        return bookList;
    }
    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Library [id=" + id + ", getlibraryName=" + libraryName + "]";
    }

}
