package library;

import javax.ejb.Remote;

@Remote
public interface LibraryInfo {
    public String printBook(int bookId);
    public String printNotBorrowedBooks();
    public String printNotReservedBooks();
}
