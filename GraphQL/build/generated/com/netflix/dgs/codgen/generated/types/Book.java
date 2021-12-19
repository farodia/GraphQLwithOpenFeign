package com.netflix.dgs.codgen.generated.types;

import java.lang.Object;
import java.lang.Override;
import java.lang.String;

public class Book {
  private String isn;

  private String title;

  private String summary;

  public Book() {
  }

  public Book(String isn, String title, String summary) {
    this.isn = isn;
    this.title = title;
    this.summary = summary;
  }

  public String getIsn() {
    return isn;
  }

  public void setIsn(String isn) {
    this.isn = isn;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  @Override
  public String toString() {
    return "Book{" + "isn='" + isn + "'," +"title='" + title + "'," +"summary='" + summary + "'" +"}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book that = (Book) o;
        return java.util.Objects.equals(isn, that.isn) &&
                            java.util.Objects.equals(title, that.title) &&
                            java.util.Objects.equals(summary, that.summary);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(isn, title, summary);
  }

  public static com.netflix.dgs.codgen.generated.types.Book.Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private String isn;

    private String title;

    private String summary;

    public Book build() {
                  com.netflix.dgs.codgen.generated.types.Book result = new com.netflix.dgs.codgen.generated.types.Book();
                      result.isn = this.isn;
          result.title = this.title;
          result.summary = this.summary;
                      return result;
    }

    public com.netflix.dgs.codgen.generated.types.Book.Builder isn(String isn) {
      this.isn = isn;
      return this;
    }

    public com.netflix.dgs.codgen.generated.types.Book.Builder title(String title) {
      this.title = title;
      return this;
    }

    public com.netflix.dgs.codgen.generated.types.Book.Builder summary(String summary) {
      this.summary = summary;
      return this;
    }
  }
}
