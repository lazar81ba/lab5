package example;

public interface TheatreBooker {
    public String bookSeat(int seatId)throws SeatBookedException,
            NotEnoughMoneyException;
}
