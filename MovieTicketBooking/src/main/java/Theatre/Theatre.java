package Theatre;

import Movie.Movie;

import java.util.ArrayList;
import java.util.List;

public class Theatre {

    private final String name;

    private final City city;

    private final List<Show> shows;

    private final List<Screen> screens;

    public Theatre(String name, City city, List<Screen> screens) {
        this.name = name;
        this.city = city;
        this.shows = new ArrayList<>();
        this.screens = screens;
    }

    public List<Show> getShowsForAMovie(Movie movie) {
        List<Show> showsForMovie = new ArrayList<>();
        for (Show show : shows) {
            if (show.getMovie().equals(movie)) {
                showsForMovie.add(show);
            }
        }
        return showsForMovie;
    }

    public void addShow(Movie movie, String showTime, String showDate, String screenName, int id) {
        screens.forEach(screen -> {
            if (screen.getScreenName().equals(screenName)) {
                shows.add((new Show(movie, showTime, showDate, new ShowScreen(screen), id)));
            }
        });
    }

    public void removeShow(Show show) {
        shows.remove(show);
    }


    public String getName() {
        return name;
    }

    public City getCity() {
        return city;
    }

    public List<Show> getShows() {
        return shows;
    }

    public List<Screen> getScreens() {
        return screens;
    }
}
