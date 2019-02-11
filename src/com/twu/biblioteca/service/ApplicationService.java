package com.twu.biblioteca.service;

import com.twu.biblioteca.resource.BibliotecaResource;
import com.twu.biblioteca.resource.Book;
import com.twu.biblioteca.resource.Menu;
import com.twu.biblioteca.resource.Movie;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ApplicationService {

  private final List<Menu> menus;
  private final Map<Integer, Menu> menuMap = new HashMap<>();
  private final BibliotecaResource resource = BibliotecaResource.getInstance();

  public ApplicationService(Builder builder) {
    this.menus = builder.menus;
    menus.forEach(it -> menuMap.put(it.getCode(), it));
  }

  public Menu getOptionalMenu(int optional) {
    return menuMap.get(optional);
  }

  public Book findBookById(long bookId) {
    return resource.getBookList().stream()
        .filter(book -> book.getId().equals(bookId)).findFirst().orElse(null);
  }

  public boolean validCheckedOutBook(Book book) {
    return book != null && !book.getCheckedOut();
  }

  public boolean validReturnedBook(Book book) {
    return book != null && book.getCheckedOut();
  }

  public void changeBookStatus(Book book) {
    book.setCheckedOut(!book.getCheckedOut());
  }

  public List<Book> findAllBookList() {
    return resource.getBookList().stream().filter(book -> !book.getCheckedOut())
        .collect(Collectors.toList());
  }

  public List<Movie> findAllMovieList() {
    return resource.getMovieList().stream().filter(movie -> !movie.getCheckedOut())
        .collect(Collectors.toList());
  }

  public Movie findMovieById(long movieId) {
    return resource.getMovieList().stream()
        .filter(movie -> movie.getId().equals(movieId)).findFirst().orElse(null);
  }

  public boolean validCheckedOutMovie(Movie movie) {
    return movie != null && !movie.getCheckedOut();
  }

  public void changeMovieStatus(Movie movie) {
    movie.setCheckedOut(!movie.getCheckedOut());
  }


  public void stop() {

  }

  public static class Builder {

    private final List<Menu> menus = new ArrayList<>();

    public Builder addMenu(Menu menu) {
      menus.add(menu);
      return this;
    }

    public ApplicationService build() {
      return new ApplicationService(this);
    }
  }

  public List<Menu> getMenus() {
    return menus;
  }
}
