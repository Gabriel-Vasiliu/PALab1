package movie.movies;

import movie.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MovieTable implements MovieDAO {
    DbConnection db = DbConnection.create();
    Connection connection = db.getConnection();
    Statement statement = null;
    ResultSet resultSet = null;

    @Override
    public void showMovie(int id, String name) {
        try {
            String SQLGetMovie = "SELECT * FROM movies WHERE id= " + id + " AND title = '" + name + "' ;";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQLGetMovie);
            if (resultSet.next())
                System.out.println(resultSet.getString("title")
                        + " " + resultSet.getString("release_date") + ", duration: " +
                        resultSet.getString("duration") + ", score: " + resultSet.getString("score"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void createMovie(Movie movie) {
        try {

            String SQLCreateMovie = "INSERT INTO movies VALUES ( " +
                    movie.getId() + ", '" + movie.getTitle() + "', '" + movie.getReleaseDate() + "', " +
                    movie.getDuration() + ", " + movie.getScore() + ");";
            statement = connection.createStatement();
            statement.executeUpdate(SQLCreateMovie);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
