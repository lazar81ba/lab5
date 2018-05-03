package library;

public class BookBorrowedException extends Exception{
    public BookBorrowedException(String message) {
        super(message);
    }

    public BookBorrowedException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
