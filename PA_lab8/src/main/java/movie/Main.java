package movie;

import movie.genres.Genre;
import movie.genres.GenreTable;
import movie.movies.Movie;
import movie.movies.MovieTable;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        DbConnection db = DbConnection.create();
        Connection connection = db.getConnection();

        try {
            Statement statement = connection.createStatement();
            String SQLMovieCreator = "CREATE TABLE movies (id INT UNSIGNED NOT NULL, title VARCHAR(30) NOT NULL, " +
                    "release_date VARCHAR(10) , duration DECIMAL(16,2), score DECIMAL(16,2), PRIMARY KEY(id));";
            //statement.execute(SQLMovieCreator);
            String SQLGenreCreator = "CREATE TABLE genres (id INT UNSIGNED NOT NULL , name VARCHAR(30) NOT NULL, PRIMARY KEY(id));";
            //statement.execute(SQLGenreCreator);
            String SQLAssociation = "CREATE TABLE association(movie_id INT UNSIGNED REFERENCES movies(id), " +
                    "genre_id INT UNSIGNED REFERENCES genres(id));";
            //statement.execute(SQLAssociation);
            String SQLActorsCreator = "CREATE TABLE actors (id INT UNSIGNED NOT NULL, name VARCHAR(30) NOT NULL, " +
                    "age INT UNSIGNED NOT NULL, PRIMARY KEY(id));";
            //statement.execute(SQLActorsCreator);
            String SQLDirectorsCreator = "CREATE TABLE directors (id INT UNSIGNED NOT NULL, name VARCHAR(30) NOT NULL, " +
                    "age INT UNSIGNED NOT NULL, nr_movies INT UNSIGNED, PRIMARY KEY(id));";
            //statement.execute(SQLDirectorsCreator);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Movie movie1 = new Movie(1, "Titanic");
        movie1.setDuration(3.3);
        movie1.setReleaseDate("18-11-1997");
        movie1.setScore(7.8);

        Movie movie2 = new Movie(2, "Avatar");
        movie2.setDuration(2.42);
        movie2.setReleaseDate("18-12-2009");
        movie2.setScore(7.8);

        MovieTable movieTable = new MovieTable();
        //movieTable.createMovie(movie1);
        //movieTable.createMovie(movie2);
        movieTable.showMovie(1, "Titanic");

        Genre genre1 = new Genre(1, "Action");
        Genre genre2 = new Genre(2, "Drama");

        GenreTable genreTable = new GenreTable();
        //genreTable.createGenre(genre1);
        //genreTable.createGenre(genre2);
        genreTable.showGenre(1, "Action");

        db.close();
    }
}
