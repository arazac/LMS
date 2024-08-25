package com.lms.book;

public class Book {

    private String title;
    private String author;
    private String isbn;
    private String publishedYear;
    private Boolean isBorrowed;

    public Book(String title, String author, String isbn, String publishedYear){
        this.title=title;
        this.author=author;
        this.isbn= isbn;
        this.publishedYear=publishedYear;
        this.isBorrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(String publishedYear) {
        this.publishedYear = publishedYear;
    }


    public Boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(Boolean borrowed) {
        isBorrowed = borrowed;
    }





}
