package com.library.repository;

import java.util.Arrays;
import java.util.List;

public class BookRepository {

    public BookRepository() {
        System.out.println("BookRepository created");
    }

    public List<String> getBooks() {
        return Arrays.asList("Let Us C", "Concepts of Physics", "Wings of Fire");
    }
}