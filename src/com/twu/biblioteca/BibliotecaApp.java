package com.twu.biblioteca;

import com.twu.biblioteca.resource.BibliotecaResource;
import com.twu.biblioteca.resource.Book;
import java.util.List;

public class BibliotecaApp {


  public static void main(String[] args) {
    printWelcomeMessage();

    BibliotecaResource resource = BibliotecaResource.getInstance();
    printAllBookList(resource.getBookList());
  }

  private static void printAllBookList(List<Book> bookList) {
    System.out.println("All library books: ");
    bookList.forEach(System.out::print);
  }

  private static void printWelcomeMessage() {
    System.out
        .println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
  }
}
