package com.lms.patron;

import com.lms.book.Book;

import java.util.ArrayList;
import java.util.List;

public class Patron {

    private String patronId;
    private String patronName;
    private String age;
    private List<Book> booksBorrowed;
    private List<Book> borrowHistory;

    public Patron(String patronId, String patronName, String age) {
        this.patronId = patronId;
        this.patronName = patronName;
        this.age = age;
        this.booksBorrowed = new ArrayList<Book>();
        this.borrowHistory = new ArrayList<Book>();
    }

    public String getPatronId() {
        return patronId;
    }

    public void setPatronId(String patronId) {
        this.patronId = patronId;
    }

    public String getPatronName() {
        return patronName;
    }

    public void setPatronName(String patronName) {
        this.patronName = patronName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public List<Book> getBooksBorrowed() {
        return booksBorrowed;
    }

    public void setBooksBorrowed(List<Book> booksBorrowed) {
        this.booksBorrowed = booksBorrowed;
    }

    public void borrow(Book book){
         booksBorrowed.add(book);
    }

    public void returnBook(Book book){
        booksBorrowed.remove(book);
    }


    public List<Book> getBorrowHistory() {
        return borrowHistory;
    }

    public void setBorrowHistory(List<Book> borrowHistory) {
        this.borrowHistory = borrowHistory;
    }


}
