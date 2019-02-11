package com.twu.biblioteca;

import com.twu.biblioteca.resource.BibliotecaResource;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BibliotecaApp {

  private static final String OPTIONAL_BOOKLIST = "1";
  private static final String OPTIONAL_CHECKOUT = "2";
  private static final String OPTIONAL_QUIT = "QUIT";
  private static BibliotecaResource resource = BibliotecaResource.getInstance();


  public static void main(String[] args) {
    printWelcomeMessage();

    printMenu();

    Scanner scan = new Scanner(System.in);
    while (true) {
      executeMenuSelection(scan);
    }
  }

  private static void executeMenuSelection(Scanner scan) {
    if (scan.hasNext()) {
      switch (scan.next()) {
        case OPTIONAL_BOOKLIST:
          printAllBookList();
          break;
        case OPTIONAL_CHECKOUT:
          checkOutBook(scan);
          break;
        case OPTIONAL_QUIT:
          scan.close();
          break;
        default:
          System.out.println("Please select a valid option!");
      }
    }
  }

  private static void checkOutBook(Scanner scan) {
    System.out.println("Book id:");
    if (scan.hasNext()) {
      long boolId = scan.nextLong();
      resource.getBookList().stream().map(book -> {
        if (book.getId().equals(boolId)) {
          book.setStatus("checked out");
        }
        return book;
      }).collect(Collectors.toList());
    }
  }

  private static void printMenu() {
    System.out.println("*************menu*************");
    System.out.println(String.format("[%s] List of books", OPTIONAL_BOOKLIST));
    System.out.println(String.format("[%s] Check out a book", OPTIONAL_CHECKOUT));
    System.out.println(String.format("[%s] Exit application", OPTIONAL_QUIT));
  }

  private static void printAllBookList() {
    System.out.println("All library books: ");
    resource.getBookList().stream().filter(book -> book.getStatus().equals("returned"))
        .forEach(System.out::print);
  }

  private static void printWelcomeMessage() {
    System.out
        .println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
  }
}
