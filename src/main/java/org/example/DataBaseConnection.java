package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    public static final String URL="jdbc:mysql://localhost:3306/dbtest";
    public static final String USER="root";
    public static final String PASSWORD="";
    public static Connection getConnection() throws SQLException {
    try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    return DriverManager.getConnection(URL,USER,PASSWORD);
    }catch (Exception e){
        throw new SQLException("Driver JDBC introuvable",e);
    }
  }


}
