package Theatre;

import Movie.Movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController {

    List<Theatre> theatres;

    public TheatreController() {
        this.theatres = new ArrayList<>();
    }

    public Map<Theatre, List<Show>> findShows(Movie movie, City city) {
        Map<Theatre, List<Show>> showsMap = new HashMap<>();
        for (Theatre theatre : theatres) {
            if (theatre.getCity().equals(city)) {
                showsMap.put(theatre, theatre.getShowsForAMovie(movie));
            }
        }
        return showsMap;
    }

    public void addTheatre(Theatre theatre) {
        theatres.add(theatre);
    }

    public void removeTheatre(Theatre theatre) {
        theatres.remove(theatre);
    }

    public List<Theatre> getTheatres() {
        return theatres;
    }

}
