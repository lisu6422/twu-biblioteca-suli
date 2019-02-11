package com.twu.biblioteca.service;

import static org.junit.Assert.assertEquals;

import com.twu.biblioteca.resource.Book;
import java.util.List;
import org.junit.Test;

public class BookServiceTest {

  private BookService service = new BookService.Builder().build();

  @Test
  public void shouldFindBookByIdSuccess() {
    Book result = service.findBookById(1);
    assertEquals(1, result.getId().intValue());
  }

  @Test
  public void shouldReturnTrueWhenSelectedBookIsValid() {
    Book book = new Book(1L, "Life of Pi", "Anand Beck", "2010", false);
    boolean result = service.validCheckedOutBook(book);
    assertEquals(true, result);
  }

  @Test
  public void shouldReturnFalseWhenSelectedBookNotExit() {
    boolean result = service.validCheckedOutBook(null);
    assertEquals(false, result);
  }

  @Test
  public void shouldReturnFalseWhenSelectedBookIsCheckedOut() {
    Book book = new Book(1L, "Life of Pi", "Anand Beck", "2010", true);
    boolean result = service.validCheckedOutBook(book);
    assertEquals(false, result);
  }


  @Test
  public void findAllBookList() {
    List<Book> result = service.findAllBookList();
    assertEquals(4, result.size());
  }

  @Test
  public void shouldReturnTrueWhenReturnedBookIsValid() {
    Book book = new Book(1L, "Life of Pi", "Anand Beck", "2010", true);
    boolean result = service.validReturnedBook(book);
    assertEquals(true, result);
  }

  @Test
  public void shouldReturnFalseWhenReturnedBookIsReturned() {
    Book book = new Book(1L, "Life of Pi", "Anand Beck", "2010", false);
    boolean result = service.validReturnedBook(book);
    assertEquals(false, result);
  }
}