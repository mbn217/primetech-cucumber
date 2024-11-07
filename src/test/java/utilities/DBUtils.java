package utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtils {
    private static final String DB_HOSTNAME = ConfigurationReader.getPropertyValue("dbhosturl");
    private static final String USERNAME = ConfigurationReader.getPropertyValue("dbusername");
    private static final String PASSWORD = ConfigurationReader.getPropertyValue("dbpassword");

    // Method to create and return a database connection
    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_HOSTNAME, USERNAME, PASSWORD);
    }

    // General method to execute any query that doesn't return a result (insert, update, delete)
    private static void executeQuery(String query) {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Error executing update: " + query);
            e.printStackTrace();
        }
    }

    // Select query method that returns the first record as a List of strings
    public static List<String> selectRecord(String query) {
        List<String> list = new ArrayList<>();
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            ResultSetMetaData rsmd = resultSet.getMetaData();
            if (resultSet.next()) {
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    list.add(resultSet.getString(i));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error executing select query: " + query);
            e.printStackTrace();
        }
        return list;
    }

    // Insert record method
    public static void insertRecord(String insertQuery) {
        executeQuery(insertQuery);
    }

    // Update record method
    public static void updateRecord(String updateQuery) {
        executeQuery(updateQuery);
    }

    // Delete record method
    public  static void deleteRecord(String deleteQuery) {
        executeQuery(deleteQuery);
    }

}
