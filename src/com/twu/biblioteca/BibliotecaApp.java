package com.twu.biblioteca;

import com.twu.biblioteca.resource.BibliotecaResource;
import com.twu.biblioteca.resource.Book;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

  private static final Integer OPTIONAL_1 = 1;
  private static BibliotecaResource resource = BibliotecaResource.getInstance();


  public static void main(String[] args) {
    printWelcomeMessage();

    printMenu();

    Scanner scan = new Scanner(System.in);
    executeMenuSelection(scan);
  }

  private static void executeMenuSelection(Scanner scan) {
    if (scan.hasNextInt()) {
      if (scan.nextInt() == OPTIONAL_1) {
        printAllBookList(resource.getBookList());
      }
    }
  }

  private static void printMenu() {
    System.out.println("*************menu*************");
    System.out.println(String.format("[%s] List of books", OPTIONAL_1));
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
