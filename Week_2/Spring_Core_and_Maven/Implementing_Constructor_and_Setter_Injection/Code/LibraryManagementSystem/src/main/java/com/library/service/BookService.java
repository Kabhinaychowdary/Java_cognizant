package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private String libraryName;
    private BookRepository bookRepository;

    public BookService(String libraryName) {
        this.libraryName = libraryName;
        System.out.println("BookService created for library: " + libraryName);
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookRepository injected into BookService");
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void getBooks() {
        System.out.println("Books: " + bookRepository.getBooks());
    }
}