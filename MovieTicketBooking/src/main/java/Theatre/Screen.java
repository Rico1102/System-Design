package Theatre;

import java.util.List;

public class Screen {

    private final String screenName;
    private final int totalSeats;
    private final List<Seat> seats;

    public Screen(String screenName, int totalSeats, List<Seat> seats) {
        this.screenName = screenName;
        this.totalSeats = totalSeats;
        this.seats = seats;
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
