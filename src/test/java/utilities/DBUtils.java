package utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtils {
    private static final String DB_HOSTNAME = ConfigurationReader.getPropertyValue("dbhosturl");
    private static final String USERNAME = ConfigurationReader.getPropertyValue("dbusername");
    private static final String PASSWORD = ConfigurationReader.getPropertyValue("dbpassword");



    /**
     * Create and return a database connection
     * @return a connection object
     * @throws SQLException if the connection fails
     */
    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_HOSTNAME, USERNAME, PASSWORD);
    }


    /**
     * Execute any query that doesn't return a result (insert, update, delete)
     * This method is used to execute insert, update, delete queries
     * Only use this method when you don't expect a result back from the query
     * @param query the query to execute
     */
    private static void executeUpdate(String query) {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Error executing update: " + query);
            e.printStackTrace();
        }
    }


    /**
     * Select query that will return the first record as a list of strings
     * If your query returns multiple records, only the first record will be returned
     * If your query has multiple columns, all columns will be returned as a list of strings
     * @param query the query to execute
     * @return a list of strings representing the first record
     */
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


    /**
     * Select the first record and return back the data for that specific column
     * @param insertQuery the query to execute
     */
    public static void insertRecord(String insertQuery) {
        executeUpdate(insertQuery);
    }

    /**
     * Update record method
     * @param updateQuery the query to execute
     */
    public static void updateRecord(String updateQuery) {
        executeUpdate(updateQuery);
    }

    /**
     * Delete record method
     * @param deleteQuery the query to execute
     */
    public  static void deleteRecord(String deleteQuery) {
        executeUpdate(deleteQuery);
    }

}
