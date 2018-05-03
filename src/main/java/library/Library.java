package library;

import library.BookBorrowedException;
import library.BookReservedException;

import javax.ejb.Remote;

@Remote
public interface Library {
    public String borrowBook(int bookId)throws BookBorrowedException,BookReservedException;
    public String reserveBook(int bookId) throws BookReservedException;
    public String returnBook(int bookId)throws BookBorrowedException ;
}
