package MODEL;

import common.config;

import java.sql.*;

public class MyConnection {
    public static Connection connection = null;

    public void driverTest() throws ClassNotFoundException{
        try {
            Class.forName(config.DRIVER);
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException("JDBC Driver not found" + e.getMessage());
        }
    }

    public java.sql.Connection connectDB() throws ClassNotFoundException, SQLException {
        driverTest();
        try {
            connection = DriverManager.getConnection(config.URL_DATABASE, config.USERNAME, config.PASSWORD);
            if(connection != null) System.out.println("Connect DB successfully");
        } catch (SQLException e) {
            throw new SQLException("Connect DB fail " + e.getMessage());
        }
        return connection;
    }

    public PreparedStatement prepape(String sql){
        System.out.println(">>" + sql);

        try {
            return connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return  null;
        }
    }

    public  PreparedStatement prepapeUpdate(String sql){
        System.out.println(">>" + sql);

        try {
            return  connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public void closeConnection() throws SQLException {
        if (connection != null){
            connection.close();
            System.out.println(">> close connection");
        }
    }
}
