package com.example.plutoplanetnine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection getConnection(){
        Connection connection = null;
        String username ="devUser";
        String databasePassword = "Skittlesquad@@77";
        String databaseName = "UserAccount";
        String url = "jdbc:mySQL://localhost/" + databaseName;

        try{
            connection = DriverManager.getConnection(url, username, databasePassword);
            System.out.println("You are Connected!");
        }catch(SQLException e){
            e.printStackTrace();

        }
        return connection;
    }

}
