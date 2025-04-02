package Booking;

public class PaymentsController {

    public boolean makePayment(double amount, int timeout) throws InterruptedException {
        Thread.sleep(timeout);
//        return new Random().nextBoolean();
        return timeout < 10000;
    }

}
