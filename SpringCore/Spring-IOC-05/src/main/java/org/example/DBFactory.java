package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBFactory {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection con = null;
        try{
           if(con == null){
               Class.forName("com.mysql.cj.jdbc.Driver");
               con = DriverManager.getConnection("jdbc:mysql://localhost:3306/keyboard","root","root");
           }
       }catch (Exception e){
           e.printStackTrace();
       }
        return con;
    }
}
