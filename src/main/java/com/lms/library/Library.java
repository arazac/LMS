package com.lms.library;

import com.lms.book.Book;
import com.lms.patron.Patron;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Library {

    Map<String, Book> booksInLibrary;
    Map<String, Patron> libraryMembers;

    public Library(){
       this.booksInLibrary = new HashMap<String, Book>();
       this.libraryMembers = new HashMap<String, Patron>();
    }

    public void addBook(Book book){
        booksInLibrary.put(book.getIsbn(),book);
    }

    public void removeBook(Book removeBook){
        booksInLibrary.remove(removeBook.getIsbn());
    }

    public void updateBook(Book updatedBook){
        Book book = booksInLibrary.get(updatedBook.getIsbn());
        book.setAuthor(updatedBook.getAuthor());
        book.setTitle(updatedBook.getTitle());
        book.setPublishedYear(updatedBook.getPublishedYear());
    }

    public Book searchBook(String searchBy, String searchValue){
        if(searchBy.equalsIgnoreCase("isbn")){
            return booksInLibrary.get(searchValue);
        }else if(searchBy.equalsIgnoreCase("title")){
            for(Map.Entry<String,Book> entry : booksInLibrary.entrySet()){
                if(entry.getValue().getTitle().equalsIgnoreCase(searchValue)){
                    return entry.getValue();
                }
            }
        }else if(searchBy.equalsIgnoreCase("author")){
            for(Map.Entry<String,Book> entry : booksInLibrary.entrySet()){
                if(entry.getValue().getAuthor().equalsIgnoreCase(searchValue)){
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    public void addLibraryMembers(Patron libMember){
        libraryMembers.put(libMember.getPatronId(), libMember);
    }

    public void updateLibraryMembers(Patron updatedLibMember){
        Patron member = libraryMembers.get(updatedLibMember.getPatronId());
        member.setAge(updatedLibMember.getAge());
        member.setBooksBorrowed(updatedLibMember.getBooksBorrowed());
        member.setPatronName(updatedLibMember.getPatronName());
    }

    public String checkout(Book book, Patron member){
        //check if the book is available
        if(!book.isBorrowed()){
            member.getBooksBorrowed().add(book);
            book.setBorrowed(true);
            return "Booking confirmed";
        }else{
            return "Book is not available!!";
        }
    }

    public void returnBook(Book bookReturned, Patron patron){

        List<Book> booksBorrowed = patron.getBooksBorrowed();
        booksBorrowed.removeIf(book -> bookReturned.getIsbn().equalsIgnoreCase(book.getIsbn()));
        bookReturned.setBorrowed(false);
        List<Book> booksBorrowedInPast = patron.getBorrowHistory();
        booksBorrowedInPast.add(bookReturned);
    }

    public List<Book> getAvailableBooks(){

        // Filtering books with price greater than 20
        List<Book> booksAvailable = booksInLibrary.values().stream()
                .filter(book -> !book.isBorrowed())
                .collect(Collectors.toList());
         return booksAvailable;
    }

    public List<Book> getBorrowedBooks(){

        // Filtering books with price greater than 20
        List<Book> booksAvailable = booksInLibrary.values().stream()
                .filter(book -> book.isBorrowed())
                .collect(Collectors.toList());
        return booksAvailable;
    }
}
