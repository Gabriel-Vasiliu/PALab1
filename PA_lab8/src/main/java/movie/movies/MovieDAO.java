package movie.movies;

public interface MovieDAO {
    void showMovie(int id, String name);

    void createMovie(Movie movie);
}
