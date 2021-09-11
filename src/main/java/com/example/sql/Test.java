package com.example.sql;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test {


    public static Connection getConnection(){
        String databaseUser = "root";
        String databasePassword = "";
        String url = "jdbc:mysql://localhost:3306/user";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url,databaseUser,databasePassword);
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
        return null;
    }


}
