package view;

import MODEL.MyConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class main {
    public static void main(String[] args) {
        MyConnection myConnection = new MyConnection();

        try {
            myConnection.connectDB();


            PreparedStatement preparedStatement = myConnection.prepape("SELECT * FROM category");
           
            System.out.println("ID\t\tNAME\t\t\t\t\tDELETE");


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
