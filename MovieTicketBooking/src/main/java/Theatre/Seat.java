package Theatre;

import java.util.concurrent.locks.ReentrantLock;

public class Seat {

    private final String seatNumber;

    private final SeatType seatType;
    private final ReentrantLock lock = new ReentrantLock();
    private boolean isBooked;

    public Seat(String seatNumber, SeatType seatType) {
        this.seatNumber = seatNumber;
        this.isBooked = false;
        this.seatType = seatType;
    }

    public Seat(Seat seat) {
        this.seatNumber = seat.getSeatNumber();
        this.isBooked = seat.isBooked();
        this.seatType = seat.getSeatType();
    }

    public void bookSeat() {
        this.isBooked = true;
    }

    public void unbookSeat() {
        this.isBooked = false;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public boolean lock() {
        return lock.tryLock();
    }

    public void unlock() {
        lock.unlock();
    }
}
