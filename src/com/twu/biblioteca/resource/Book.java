package com.twu.biblioteca.resource;

public class Book {

  private Long id;
  private String title;
  private String author;
  private String publicationYear;
  private String status;

  public Book(Long id, String title, String author, String publicationYear, String status) {
    this.id = id;
    this.title = title;
    this.author = author;
    this.publicationYear = publicationYear;
    this.status = status;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Long getId() {
    return id;
  }

  @Override
  public String toString() {
    return "id='" + id + '\'' +
        ", title='" + title + '\'' +
        ", author='" + author + '\'' +
        ", publicationYear='" + publicationYear + '\'' +
        ", status='" + status + '\'' + '\n';
  }
}
