import java.sql.*;

public class DbConnection {
    private static DbConnection db = null;
    private Connection connection = null;

    private DbConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "r3dx003145");

        } catch (SQLException ex) {
            System.out.println("cannot query the database");
        } catch (ClassNotFoundException ex) {
            System.out.println("cannot connect to database");
        }
    }

    public Connection getConnection() {
        if (connection != null) {
            return connection;
        }
        return null;
    }

    public static DbConnection create() {
        if (db == null) {
            db = new DbConnection();
        }
        return db;
    }

    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println("Cannot close data base");
            }
        }
    }
}

