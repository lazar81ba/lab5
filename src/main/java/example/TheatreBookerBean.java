package example;


import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateful;

@Stateful
@Remote(TheatreBooker.class)
public class TheatreBookerBean implements TheatreBooker {
    int money;
    @EJB
    TheatreBox theatreBox;
    @PostConstruct
    public void createCustomer() {
        this.money=100;
    }


    public String bookSeat(int seatId) throws SeatBookedException, NotEnoughMoneyException {
        Seat seat = theatreBox.getSeatList().get(seatId);
        // Logika biznesowa.
        if (seat.isBooked()) {
            throw new SeatBookedException("To miejsce jest już zarezerwowane!");
        }
        if (seat.getPrice() > money) {
            throw new NotEnoughMoneyException("Nie masz wystarczających środków, aby kupić ten bilet!");
        }
        theatreBox.buyTicket(seatId);
        money = money -seat.getPrice();
        return "Rezerwacja przyjęta.";
    }
}