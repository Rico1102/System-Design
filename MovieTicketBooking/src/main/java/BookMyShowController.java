import Booking.BookingController;
import Movie.Movie;
import Movie.MovieController;
import Theatre.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.*;

public class BookMyShowController {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        BookingController bookingController = new BookingController();

        City bangalore = new City("Bangalore", "Karnataka");
        City mumbai = new City("Mumbai", "Maharashtra");

        Seat seat1 = new Seat("A1", SeatType.VIP);
        Seat seat2 = new Seat("A2", SeatType.PREMIUM);
        Seat seat3 = new Seat("A3", SeatType.REGULAR);

        Screen screen1 = new Screen("Screen 1", 3, List.of(seat1, seat2, seat3));

        Theatre theatre1 = new Theatre("Theatre 1", bangalore, List.of(screen1));
        Theatre theatre2 = new Theatre("Theatre 2", mumbai, List.of(screen1));

        Movie movie1 = new Movie("Movie 1", "Action", "English");
        Movie movie2 = new Movie("Movie 2", "Comedy", "Hindi");

        theatre1.addShow(movie1, "10:00", "2021-10-10", "Screen 1", 1);
        theatre1.addShow(movie2, "12:00", "2021-10-10", "Screen 2", 2);

        theatre2.addShow(movie1, "10:00", "2021-10-10", "Screen 1", 1);
        theatre2.addShow(movie2, "12:00", "2021-10-10", "Screen 2", 2);

        MovieController movieController = new MovieController();
        movieController.addMovie(movie1);
        movieController.addMovie(movie2);

        TheatreController theatreController = new TheatreController();
        theatreController.addTheatre(theatre1);
        theatreController.addTheatre(theatre2);

        //Find All Shows for a Movie
        Map<Theatre, List<Show>> showsForMovieMumbai = theatreController.findShows(movie1, mumbai);

        System.out.println("\n--------------------");
        System.out.println("Shows for Movie in Mumbai");

        for (Map.Entry<Theatre, List<Show>> entry : showsForMovieMumbai.entrySet()) {
            System.out.println("Theatre: " + entry.getKey().getName());
            for (Show show : entry.getValue()) {
                System.out.println("Movie Name: " + show.getMovie().getName());
                System.out.println("Show Time: " + show.getShowTime());
                System.out.println("Show Date: " + show.getShowDate());
                System.out.println("Screen Name: " + show.getShowScreen().getScreenName());
                System.out.println("Available Seats: " + show.getShowScreen().getAvailableSeatCount());
            }
        }

        System.out.println("--------------------\n");

        List<Seat> seats = showsForMovieMumbai.get(theatre2).get(0).getSeats();

        for (Seat seat : seats) {
            System.out.println("--------------------");
            System.out.println("Seat Number: " + seat.getSeatNumber());
            System.out.println("Seat Type: " + seat.getSeatType());
            System.out.println("Is Booked: " + seat.isBooked());
            System.out.println("--------------------\n");
        }

        ExecutorService executor = Executors.newFixedThreadPool(5);

        UUID requestId1 = UUID.randomUUID();
        UUID requestId2 = UUID.randomUUID();
        //Book a Seat
        Future<Boolean> future1 = executor.submit(() -> bookingController.bookSeats(List.of(seats.get(0), seats.get(1)), 120, 11000, requestId1));
        Thread.sleep(13000);
        Future<Boolean> future2 = executor.submit(() -> bookingController.bookSeats(List.of(seats.get(1), seats.get(2)), 120, 2000, requestId2));

        if (future1.get()) {
            System.out.println("Seats Booked Successfully for Request with ID: " + requestId1);
        } else {
            System.out.println("Seat Booking Failed for Request with ID: " + requestId1);
        }

        if (future2.get()) {
            System.out.println("Seats Booked Successfully for Request with ID: " + requestId2);
        } else {
            System.out.println("Seat Booking Failed for Request with ID: " + requestId2);
        }

        for (Seat seat : seats) {
            System.out.println("--------------------");
            System.out.println("Seat Number: " + seat.getSeatNumber());
            System.out.println("Seat Type: " + seat.getSeatType());
            System.out.println("Is Booked: " + seat.isBooked());
            System.out.println("--------------------\n");
        }

        for (Map.Entry<Theatre, List<Show>> entry : showsForMovieMumbai.entrySet()) {
            System.out.println("Theatre: " + entry.getKey().getName());
            for (Show show : entry.getValue()) {
                System.out.println("Movie Name: " + show.getMovie().getName());
                System.out.println("Show Time: " + show.getShowTime());
                System.out.println("Show Date: " + show.getShowDate());
                System.out.println("Screen Name: " + show.getShowScreen().getScreenName());
                System.out.println("Available Seats: " + show.getShowScreen().getAvailableSeatCount());
            }
        }

        System.out.println("\n--------------------");
        System.out.println("Shows for Movie in Bangalore");

        Map<Theatre, List<Show>> showsForMovieBangalore = theatreController.findShows(movie1, bangalore);

        for (Map.Entry<Theatre, List<Show>> entry : showsForMovieBangalore.entrySet()) {
            System.out.println("Theatre: " + entry.getKey().getName());
            for (Show show : entry.getValue()) {
                System.out.println("Movie Name: " + show.getMovie().getName());
                System.out.println("Show Time: " + show.getShowTime());
                System.out.println("Show Date: " + show.getShowDate());
                System.out.println("Screen Name: " + show.getShowScreen().getScreenName());
                System.out.println("Available Seats: " + show.getShowScreen().getAvailableSeatCount());
            }
        }

        System.out.println("--------------------\n");

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

    }

}
