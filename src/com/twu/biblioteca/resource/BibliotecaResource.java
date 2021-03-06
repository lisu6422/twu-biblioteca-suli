package com.twu.biblioteca.resource;

import java.util.Arrays;
import java.util.List;

public class BibliotecaResource {

  private static BibliotecaResource instance = new BibliotecaResource();
  private List<Book> bookList = Arrays
      .asList(new Book(1L, "Life of Pi", "Anand Beck", "2010", true),
          new Book(2L, "Fellowship of the Ring", "Yaxuan Evans", "2018", false),
          new Book(3L, "Two Towers", "Sneha Wang", "2017", false),
          new Book(4L, "Dune", "Judy Li", "2016", false));

  private List<Movie> movieList = Arrays
      .asList(new Movie(1L, "Life of Brian", "2018", "Schweta Jain", "6", false),
          new Movie(2L, "Airplane", "2017", "Naval Hunt", "8", false),
          new Movie(3L, "Rush", "2019", "Tanuj Listov", "0", false),
          new Movie(4L, "Day of the Dead", "2015", "Nandini Carmack", "5", false));

  private List<User> userList = Arrays.asList(
      new User(1L, "Anand Li", "123456", "customer", "AnandLi@google.com", "123-456789"),
      new User(2L, "Julian Huang", "123456", "customer", "JulianHuang@google.com", "123-456789"),
      new User(3L, "Julian Schneider", "123456", "customer", "JulianSchneider@google.com", "123-456789"),
      new User(4L, "Judy Singh", "123456", "librarian", "JudySingh@google.com", "123-456789"));

  private List<CheckoutItem> checkoutItemList = Arrays.asList(new CheckoutItem(1L, 1L));

  private BibliotecaResource() {
  }

  public static BibliotecaResource getInstance() {
    return instance;
  }

  public List<Book> getBookList() {
    return bookList;
  }

  public List<Movie> getMovieList() {
    return movieList;
  }

  public List<User> getUserList() {
    return userList;
  }

  public List<CheckoutItem> getCheckoutItemList() {
    return checkoutItemList;
  }
}
