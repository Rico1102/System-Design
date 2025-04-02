package Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieController {

    List<Movie> movies;

    public MovieController() {
        this.movies = new ArrayList<>();
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void removeMovie(Movie movie) {
        movies.remove(movie);
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public Movie getMovieByName(String name) {
        for (Movie movie : movies) {
            if (movie.getName().toLowerCase().contains(name.toLowerCase())) {
                return movie;
            }
        }
        return null;
    }

}
