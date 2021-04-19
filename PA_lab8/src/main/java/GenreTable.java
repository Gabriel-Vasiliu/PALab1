import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class GenreTable implements GenreDAO {
    DbConnection db = DbConnection.create();
    Connection connection = db.getConnection();
    Statement statement = null;
    ResultSet resultSet = null;

    @Override
    public void showGenre(int id, String name) {
        try {
            String SQLGetMovie = "SELECT * FROM genres WHERE id= " + id + " AND name = '" + name + "' ;";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQLGetMovie);
            if (resultSet.next())
                System.out.println(resultSet.getString("name"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void createGenre(Genre genre) {
        try {

            String SQLCreateMovie = "INSERT INTO genres VALUES ( " + genre.getId() + ", '" + genre.getName() + "');";
            statement = connection.createStatement();
            statement.executeUpdate(SQLCreateMovie);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
