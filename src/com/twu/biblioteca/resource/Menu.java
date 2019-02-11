package com.twu.biblioteca.resource;

public class Menu {

  public static final int OPTIONAL_BOOKLIST = 1;
  public static final int OPTIONAL_CHECKOUT = 2;
  public static final int OPTIONAL_QUIT = 0;

  private Integer code;
  private String title;
  private OnMenuSelectListener listener;

  public Menu(Builder builder) {
    this.code = builder.code;
    this.title = builder.title;
  }

  public void setSelectListener(OnMenuSelectListener listener) {
    this.listener = listener;
  }

  public void select() {
    if (listener != null) {
      listener.onMenuSelect(this);
    }
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @Override
  public String toString() {
    return String.format("[%s] %s", code, title);
  }

  public interface OnMenuSelectListener {

    void onMenuSelect(Menu menu);
  }

  public static class Builder {

    private Integer code;
    private String title;

    public Builder code(int code) {
      this.code = code;
      return this;
    }

    public Builder title(String title) {
      this.title = title;
      return this;
    }

    public Menu build() {
      return new Menu(this);
    }
  }
}
