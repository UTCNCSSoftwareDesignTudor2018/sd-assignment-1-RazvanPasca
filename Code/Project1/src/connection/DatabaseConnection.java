/**
 *
 */
package connection;

import java.sql.*;

/**
 * @author pasca
 *
 */
public class DatabaseConnection {
    private static final String DRIVER ="com.mysql.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/student_system1?autoReconnect=true&useSSL=false";
    private static final String USER= "root";
    private static final String PASS="root";

    private static DatabaseConnection Instance = new DatabaseConnection();

    private DatabaseConnection(){
        try {
            Class.forName(DRIVER);
            System.out.println("connected successfully");
        }
        catch (ClassNotFoundException e){
            System.out.println("connection failed");
            e.printStackTrace();
        }
    }

    private Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DBURL, USER, PASS);
        } catch (SQLException e) {
            System.out.println( "An error occured while trying to connect to the database");
            e.printStackTrace();
        }
        return connection;
    }

    public static Connection getConnection() {
        return Instance.createConnection();
    }

    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println( "An error occured while trying to close the connection");
            }
        }
    }

    public static void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println( "An error occured while trying to close the statement");
            }
        }
    }

    public static void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                System.out.println( "An error occured while trying to close the ResultSet");
            }
        }
    }
}
