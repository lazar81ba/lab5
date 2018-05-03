package library;

public class BookReservedException extends Exception{
    public BookReservedException(String message) {
        super(message);
    }

    public BookReservedException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
