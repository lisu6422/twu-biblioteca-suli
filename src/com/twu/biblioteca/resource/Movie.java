package com.twu.biblioteca.resource;

public class Movie {

  private Long id;
  private String name;
  private String year;
  private String director;
  private String rate;
  private Boolean isCheckedOut;

  public Movie(Long id, String name, String year, String director, String rate,
      Boolean isCheckedOut) {
    this.id = id;
    this.name = name;
    this.year = year;
    this.director = director;
    this.rate = rate;
    this.isCheckedOut = isCheckedOut;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getYear() {
    return year;
  }

  public String getDirector() {
    return director;
  }

  public String getRate() {
    return rate;
  }

  public Boolean getCheckedOut() {
    return isCheckedOut;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setYear(String year) {
    this.year = year;
  }

  public void setDirector(String director) {
    this.director = director;
  }

  public void setRate(String rate) {
    this.rate = rate;
  }

  public void setCheckedOut(Boolean checkedOut) {
    isCheckedOut = checkedOut;
  }

  @Override
  public String toString() {
    return "id=" + id +
        ", name='" + name + '\'' +
        ", year='" + year + '\'' +
        ", director='" + director + '\'' +
        ", rate='" + rate + '\'' +
        ", isCheckedOut='" + isCheckedOut + '\'' + '\n';
  }
}
