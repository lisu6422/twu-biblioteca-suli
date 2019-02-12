package com.twu.biblioteca;

import com.twu.biblioteca.resource.Book;
import com.twu.biblioteca.resource.Menu;
import com.twu.biblioteca.resource.Menu.OnMenuSelectListener;
import com.twu.biblioteca.resource.Movie;
import com.twu.biblioteca.resource.User;
import com.twu.biblioteca.service.ApplicationService;
import com.twu.biblioteca.service.CheckOutItemService;
import com.twu.biblioteca.service.UserService;
import java.util.Scanner;

public class BibliotecaApp {

  private ApplicationService applicationService;
  private UserService userService = new UserService();
  private CheckOutItemService checkOutItemService = new CheckOutItemService();
  private Menu bookList;
  private Menu checkOutBook;
  private Menu returnBook;
  private Menu movieList;
  private Menu checkOutMovie;
  private Menu quit;

  private final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    new BibliotecaApp().start();
  }

  public BibliotecaApp() {

    buildMenu();

    setSelectListener();
  }

  private void setSelectListener() {
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

    movieList.setSelectListener(new OnMenuSelectListener() {
      @Override
      public void onMenuSelect(Menu menu) {
        printAllMovieList();
        inputOptional();
      }
    });

    checkOutMovie.setSelectListener(new OnMenuSelectListener() {
      @Override
      public void onMenuSelect(Menu menu) {
        checkOutMovie();
        inputOptional();
      }
    });

    quit.setSelectListener(new OnMenuSelectListener() {
      @Override
      public void onMenuSelect(Menu menu) {
        applicationService.stop();
      }
    });
  }

  private void buildMenu() {
    bookList = new Menu.Builder().code(Menu.OPTIONAL_BOOKLIST).title("List of books").build();
    checkOutBook = new Menu.Builder().code(Menu.OPTIONAL_CHECKOUTBOOK).title("Checkout a book")
        .build();
    returnBook = new Menu.Builder().code(Menu.OPTIONAL_RETURNBOOK).title("Return a book").build();
    movieList = new Menu.Builder().code(Menu.OPTIONAL_MOVIELIST).title("List of movies").build();
    checkOutMovie = new Menu.Builder().code(Menu.OPTIONAL_CHECKOUTMOVIE).title("Checkout a movie")
        .build();
    quit = new Menu.Builder().code(Menu.OPTIONAL_QUIT).title("Quit").build();

    applicationService = new ApplicationService.Builder()
        .addMenu(bookList)
        .addMenu(checkOutBook)
        .addMenu(returnBook)
        .addMenu(movieList)
        .addMenu(checkOutMovie)
        .addMenu(quit)
        .build();
  }

  private void start() {
    printWelcomeMessage();
    User loginedUser = login();
    if (loginedUser.getType().equals("librarian")) {
      printAllBorrowers();
    } else {
      inputOptional();
    }
  }

  private void printAllBorrowers() {
    System.out.println("All users who has checked out a book:");
    checkOutItemService.findAllUsersInCheckOutItem().forEach(System.out::println);
  }

  private User login() {
    User user = getLoginInfo();
    while (!userService.validUser(user)) {
      System.out.println("Login information error! Please input again.");
      user = getLoginInfo();
    }
    return user;
  }

  private User getLoginInfo() {
    System.out.println("userName:");
    String userName = null, password = null, type = null;
    if (scanner.hasNextLine()) {
      userName = scanner.nextLine();
      System.out.println("password:");
    }
    if (scanner.hasNextLine()) {
      password = scanner.nextLine();
      System.out.println("type:");
    }
    if (scanner.hasNextLine()) {
      type = scanner.nextLine();
    }
    return new User(userName, password, type);
  }

  public void inputOptional() {
    Menu menu;
    do {
      printMenu();
      menu = applicationService.getOptionalMenu(scanner.nextInt());
    } while (menu == null);

    menu.select();
  }

  public void checkOutMovie() {
    System.out.println("Movie id:");
    while (scanner.hasNext()) {
      long movieId = scanner.nextLong();
      Movie selectedMovie = applicationService.findMovieById(movieId);
      if (applicationService.validCheckedOutMovie(selectedMovie)) {
        applicationService.changeMovieStatus(selectedMovie);
        System.out.println("Thank you! Enjoy the movie.");
        return;
      } else {
        System.out.println("Sorry, that movie is not available.");
        System.out.println("Movie id:");
      }
    }
  }

  private void printAllMovieList() {
    System.out.println("All library movies: ");
    applicationService.findAllMovieList().forEach(System.out::println);
  }

  public void returnBook() {
    System.out.println("Book id:");
    while (scanner.hasNext()) {
      long bookId = scanner.nextLong();
      Book selectedBook = applicationService.findBookById(bookId);
      if (applicationService.validReturnedBook(selectedBook)) {
        applicationService.changeBookStatus(selectedBook);
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
      Book selectedBook = applicationService.findBookById(bookId);
      if (applicationService.validCheckedOutBook(selectedBook)) {
        applicationService.changeBookStatus(selectedBook);
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
    applicationService.getMenus().forEach(System.out::println);
  }

  private void printAllBookList() {
    System.out.println("All library books: ");
    applicationService.findAllBookList().forEach(System.out::println);
  }

  private void printWelcomeMessage() {
    System.out
        .println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
  }
}
