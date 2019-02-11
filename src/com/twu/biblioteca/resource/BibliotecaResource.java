package com.twu.biblioteca.resource;

import java.util.Arrays;
import java.util.List;

public class BibliotecaResource {

  private static BibliotecaResource instance = new BibliotecaResource();
  private List<Book> bookList = Arrays
      .asList(new Book(1L, "Life of Pi", "Anand Beck", "2010", "returned"),
          new Book(2L, "Fellowship of the Ring", "Yaxuan Evans", "2018", "returned"),
          new Book(3L, "Two Towers", "Sneha Wang", "2017", "returned"),
          new Book(4L, "Dune", "Judy Li", "2016", "returned"));

  private BibliotecaResource() {
  }

  public static BibliotecaResource getInstance() {
    return instance;
  }

  public List<Book> getBookList() {
    return bookList;
  }
}
