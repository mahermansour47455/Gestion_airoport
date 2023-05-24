package com.airplane.demo;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connexion {
    public static Connection getConnexionn() {
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con= (Connection) DriverManager.getConnection("jdbc:mysql://"+"localhost:3306/airplane_java","root","");
        }
        catch (Exception e){
            System.out.println("impossible de se connecter a la base de donnes");
        }
        return con;
    }
}
