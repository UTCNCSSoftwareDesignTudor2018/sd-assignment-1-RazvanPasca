package test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import connection.DatabaseConnection;

import java.sql.ResultSet;



public class Main {

    public static void main(String args[]) {
        Statement stmt = null;
        ResultSet rs = null;

        Connection conn = DatabaseConnection.getConnection();

        try {
            stmt = conn.createStatement();
            String query  = "INSERT INTO students " + "VALUES (0,'email','name','cnp','password')";
            stmt.executeUpdate(query);
            // or alternatively, if you don't know ahead of time that
            // the query will be a SELECT...
            System.out.println("statement executed");

            // Now do something with the ResultSet ....
        }
        catch (SQLException ex){
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        finally {
            // it is a good idea to release
            // resources in a finally{} block
            // in reverse-order of their creation
            // if they are no-longer needed

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { } // ignore

                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore

                stmt = null;
            }
        }
    }
}
