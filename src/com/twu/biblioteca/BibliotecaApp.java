package com.twu.biblioteca;

import com.twu.biblioteca.resource.BibliotecaResource;
import com.twu.biblioteca.resource.Book;
import java.util.Scanner;

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
      Book selectedBook = resource.getBookList().stream()
          .filter(book -> book.getId().equals(boolId)).findFirst().orElse(null);
      if (selectedBook != null && selectedBook.getStatus().equals("returned")) {
        selectedBook.setStatus("checked out");
        System.out.println("Thank you! Enjoy the book.");
      }
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
