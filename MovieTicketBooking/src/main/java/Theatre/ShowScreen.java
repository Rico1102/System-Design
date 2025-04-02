package Theatre;

import java.util.ArrayList;
import java.util.List;

public class ShowScreen {

    private final String screenName;
    private final int totalSeats;
    private final List<Seat> seats;

    public ShowScreen(Screen screen) {
        this.screenName = screen.getScreenName();
        this.totalSeats = screen.getTotalSeats();
        this.seats = new ArrayList<>();
        for (Seat seat : screen.getSeats()) {
            this.seats.add(new Seat(seat));
        }
    }

    public int getAvailableSeatCount() {
        int availableSeats = 0;
        for (Seat seat : seats) {
            if (!seat.isBooked()) {
                availableSeats++;
            }
        }
        return availableSeats;
    }

    public String getScreenName() {
        return screenName;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public List<Seat> getSeats() {
        return seats;
    }

}
