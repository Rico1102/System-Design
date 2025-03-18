package Theatre;

import Movie.Movie;

import java.util.List;

public class Show {

    private final int id;
    private final Movie movie;
    private final String showTime;
    private final String showDate;
    private final ShowScreen screen;

    public Show(Movie movie, String showTime, String showDate, ShowScreen screen, int id) {
        this.movie = movie;
        this.showTime = showTime;
        this.showDate = showDate;
        this.screen = screen;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public List<Seat> getSeats() {
        return screen.getSeats();
    }

    public int getAvailableSeatCount() {
        return screen.getAvailableSeatCount();
    }

    public Movie getMovie() {
        return movie;
    }

    public String getShowTime() {
        return showTime;
    }

    public String getShowDate() {
        return showDate;
    }

    public ShowScreen getShowScreen() {
        return screen;
    }
}
