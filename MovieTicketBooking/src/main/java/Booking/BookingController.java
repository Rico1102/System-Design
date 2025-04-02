package Booking;

import Theatre.Seat;

import java.util.List;
import java.util.UUID;

public class BookingController {

    PaymentsController paymentsController = new PaymentsController();

    public boolean bookSeats(List<Seat> seatList, double amount, int timeout, UUID uuid) throws InterruptedException {
        for (Seat seat : seatList) {
            if (seat.lock() && !seat.isBooked()) {
                seat.bookSeat();
            } else {
                System.out.println("One of the Seats is already booked for request with id: " + uuid + ". Please try again.");
                return false;
            }
        }
        System.out.println("Booking ticket...Please complete the payment in 10 seconds");
        boolean status = paymentsController.makePayment(amount, timeout);
        if (!status) {
            System.out.println("Payment failed for request with id: " + uuid + ". Please try again.");
            for (Seat seat : seatList) {
                seat.unbookSeat();
                seat.unlock();
            }
            return false;
        }

        System.out.println("Payment successful for request with id: " + uuid + " Ticket booked successfully");

        return true;
    }

}
