package movie.genres;

public interface GenreDAO {
    void showGenre(int id, String name);

    void createGenre(Genre genre);
}
