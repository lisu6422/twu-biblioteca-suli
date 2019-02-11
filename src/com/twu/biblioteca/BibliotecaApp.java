package com.twu.biblioteca;

import com.twu.biblioteca.resource.BibliotecaResource;
import java.util.Scanner;

public class BibliotecaApp {

  private static final int OPTIONAL_1 = 1;
  private static BibliotecaResource resource = BibliotecaResource.getInstance();


  public static void main(String[] args) {
    printWelcomeMessage();

    printMenu();

    Scanner scan = new Scanner(System.in);
    executeMenuSelection(scan);
  }

  private static void executeMenuSelection(Scanner scan) {
    if (scan.hasNextInt()) {
      switch (scan.nextInt()) {
        case OPTIONAL_1:
          printAllBookList();
        default:
          System.out.println("Please select a valid option!");
      }
    }
  }

  private static void printMenu() {
    System.out.println("*************menu*************");
    System.out.println(String.format("[%s] List of books", OPTIONAL_1));
  }

  private static void printAllBookList() {
    System.out.println("All library books: ");
    resource.getBookList().forEach(System.out::print);
  }

  private static void printWelcomeMessage() {
    System.out
        .println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
  }
}
