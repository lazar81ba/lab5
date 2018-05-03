package example;

public class SeatBookedException extends Exception {

    public SeatBookedException(String message) {
        super(message);
    }

    public SeatBookedException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
