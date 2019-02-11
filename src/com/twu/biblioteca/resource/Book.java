package com.twu.biblioteca.resource;

public class Book {

  private Long id;
  private String title;
  private String author;
  private String publicationYear;

  public Book(Long id, String title, String author, String publicationYear) {
    this.id = id;
    this.title = title;
    this.author = author;
    this.publicationYear = publicationYear;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @Override
  public String toString() {
    return "id='" + id + '\'' +
        ", title='" + title + '\'' +
        ", author='" + author + '\'' +
        ", publicationYear='" + publicationYear + '\'' + '\n';
  }
}
