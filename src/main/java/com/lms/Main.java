package com.lms;

import com.lms.book.Book;
import com.lms.library.Library;
import com.lms.patron.Patron;

public class Main {
    public static void main(String[] args) {

        Library library = new Library();

        Book b1 = new Book("HP and Sorcerer's Stone", "JK Rowling", "i101", "2000");
        Book b2 = new Book("Pride and Prejudice", "Jane Austin", "i102", "2001");
        Book b3 = new Book("Game of Thrones", "George RR Martin", "i103", "1996");
        Book b4 = new Book("The Diary of a Young Girl", "Anne Frank", "i104", "1980");

        // Create Patrons
        Patron p1 = new Patron("p1", "Zareen","30");
        Patron p2 = new Patron("p2", "Arshad","31");
        Patron p3 = new Patron("p3", "Syed","32");

        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);
        library.addBook(b4);

        library.addLibraryMembers(p1);
        library.addLibraryMembers(p2);
        library.addLibraryMembers(p3);

        //Check out
        System.out.println(library.checkout(b1, p1)); //checking out a book
        System.out.println(library.checkout(b1,p2)); //trying to checkout a book that is already borrowed

        System.out.println(library.checkout(b2, p1));
        System.out.println(library.checkout(b3, p1));

        //Return book
        library.returnBook(b1,p1);

        System.out.println("*******AVAILABLE BOOKS*******");
        // Available Books
        library.getAvailableBooks().forEach(book ->
                System.out.println(book.getTitle() + " by " + book.getAuthor() + " costs " + book.getPublishedYear()));

        System.out.println("*******BORROWED BOOKS*******");
        //Borrowed Books
        library.getBorrowedBooks().forEach(book ->
                System.out.println(book.getTitle() + " by " + book.getAuthor() + " costs " + book.getPublishedYear()));

        System.out.println("*******BOOKING HISTORY FOR P1*******");
        //Booking History for a member
        p1.getBorrowHistory().forEach(book ->
                System.out.println(book.getTitle() + " by " + book.getAuthor() + " costs " + book.getPublishedYear()));
    }

}