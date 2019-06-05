/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;
import java.sql.*;

/**
 *
 * @author Levanah
 */
public class Connexion {
    public static Connection connecter(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver OK");
            String url = "jdbc:mysql://localhost:3306/ecole";
            String user = "root";
            String password = "";
            Connection connexion = DriverManager.getConnection(url, user, password);
            System.out.println("Connexion reussie");
            return connexion;
            
        }catch(Exception e){
            e.printStackTrace();
        }  
        return null;
    }
}
