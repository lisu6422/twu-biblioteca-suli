package com.twu.biblioteca.resource;

public class Book {

  private Long id;
  private String title;
  private String author;
  private String publicationYear;
  private Boolean isCheckedOut;

  public Book(Long id, String title, String author, String publicationYear, Boolean isCheckedOut) {
    this.id = id;
    this.title = title;
    this.author = author;
    this.publicationYear = publicationYear;
    this.isCheckedOut = isCheckedOut;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Boolean getCheckedOut() {
    return isCheckedOut;
  }

  public void setCheckedOut(Boolean checkedOut) {
    isCheckedOut = checkedOut;
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
        ", isCheckedOut='" + isCheckedOut + '\'' + '\n';
  }
}
