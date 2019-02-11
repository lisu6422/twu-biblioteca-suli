package com.twu.biblioteca;

import com.twu.biblioteca.resource.Book;
import com.twu.biblioteca.resource.Menu;
import com.twu.biblioteca.resource.Menu.OnMenuSelectListener;
import com.twu.biblioteca.service.BookService;
import java.util.Scanner;

public class BibliotecaApp {

  private BookService bookService;
  private Menu bookList;
  private Menu checkOutBook;
  private Menu returnBook;
  private Menu quit;

  private final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    new BibliotecaApp().start();
  }

  public BibliotecaApp() {

    bookList = new Menu.Builder().code(Menu.OPTIONAL_BOOKLIST).title("List of books").build();
    checkOutBook = new Menu.Builder().code(Menu.OPTIONAL_CHECKOUT).title("Checkout a book").build();
    returnBook = new Menu.Builder().code(Menu.OPTIONAL_RETURN).title("Return abook").build();
    quit = new Menu.Builder().code(Menu.OPTIONAL_QUIT).title("Quit").build();

    bookService = new BookService.Builder()
        .addMenu(bookList)
        .addMenu(checkOutBook)
        .addMenu(returnBook)
        .addMenu(quit)
        .build();

    bookList.setSelectListener(new OnMenuSelectListener() {
      @Override
      public void onMenuSelect(Menu menu) {
        printAllBookList();
        inputOptional();
      }
    });

    checkOutBook.setSelectListener(new OnMenuSelectListener() {
      @Override
      public void onMenuSelect(Menu menu) {
        checkOutBook();
        inputOptional();
      }
    });

    returnBook.setSelectListener(new OnMenuSelectListener() {
      @Override
      public void onMenuSelect(Menu menu) {
        returnBook();
        inputOptional();
      }
    });

    quit.setSelectListener(new OnMenuSelectListener() {
      @Override
      public void onMenuSelect(Menu menu) {
        bookService.stop();
      }
    });
  }

  private void start() {
    printWelcomeMessage();
    inputOptional();
  }

  public void inputOptional() {
    Menu menu;
    do {
      printMenu();
      menu = bookService.getOptionalMenu(scanner.nextInt());
    } while (menu == null);

    menu.select();
  }

  public void returnBook() {
    System.out.println("Book id:");
    while (scanner.hasNext()) {
      long bookId = scanner.nextLong();
      Book selectedBook = bookService.findBookById(bookId);
      if (bookService.validReturnedBook(selectedBook)) {
        bookService.changeBookStatus(selectedBook);
        System.out.println("Thank you for returning the book.");
        return;
      } else {
        System.out.println("That is not a valid book to return.");
        System.out.println("Book id:");
      }
    }
  }

  public void checkOutBook() {
    System.out.println("Book id:");
    while (scanner.hasNext()) {
      long bookId = scanner.nextLong();
      Book selectedBook = bookService.findBookById(bookId);
      if (bookService.validCheckedOutBook(selectedBook)) {
        bookService.changeBookStatus(selectedBook);
        System.out.println("Thank you! Enjoy the book.");
        return;
      } else {
        System.out.println("Sorry, that book is not available.");
        System.out.println("Book id:");
      }
    }
  }

  private void printMenu() {
    System.out.println("*************menu*************");
    bookService.getMenus().forEach(System.out::println);
  }

  private void printAllBookList() {
    System.out.println("All library books: ");
    bookService.findAllBookList().forEach(System.out::println);
  }

  private void printWelcomeMessage() {
    System.out
        .println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
  }
}
