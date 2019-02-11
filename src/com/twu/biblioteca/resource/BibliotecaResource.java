package com.twu.biblioteca.resource;

import java.util.Arrays;
import java.util.List;

public class BibliotecaResource {

  private static BibliotecaResource instance = new BibliotecaResource();
  private List<Book> bookList = Arrays
      .asList(new Book("Life of Pi"), new Book("Fellowship of the Ring"), new Book("Two Towers"),
          new Book("Dune"));

  private BibliotecaResource() {}

  public static BibliotecaResource getInstance() {
    return instance;
  }

  public List<Book> getBookList() {
    return bookList;
  }
}
