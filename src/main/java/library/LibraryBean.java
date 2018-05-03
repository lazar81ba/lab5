package library;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateful;

@Stateful
@Remote(Library.class)
public class LibraryBean implements Library {
    @EJB
    LibraryState state;
    @Override
    public String borrowBook(int bookId) throws BookBorrowedException,BookReservedException {
        Book book = state.getBook(bookId);
        if (book.isBorrowed()) {
            throw new BookBorrowedException("Ksiazka zajeta!");
        }
        if (book.isReserved()) {
            throw new BookReservedException("Ksiazka zarezerwowana");
        }
        state.borrowBook(bookId);
        return "Ksiazka wypozyczona.";
    }

    @Override
    public String reserveBook(int bookId) throws BookReservedException{
        Book book = state.getBook(bookId);
        if (book.isReserved()) {
            throw new BookReservedException("Ksiazka zarezerwowana");
        }
        state.reserveBook(bookId);
        return "Ksiazka zarezerwowana.";

    }

    @Override
    public String returnBook(int bookId)throws BookBorrowedException {
        Book book = state.getBook(bookId);
        if (!book.isBorrowed()) {
            throw new BookBorrowedException("Ksiazka nie wypozyczona!");
        }
        state.freeBook(bookId);
        return "Ksiazka zwrocona.";

    }
}
