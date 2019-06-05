package Main;
import DAO.*;
import Modele.*;
import com.mysql.jdbc.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

import Vue.Display;

/**
 *
 * @author Adrien & Lévanah & Léa
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Display display = new Display();

        try {
            Connexion co = new Connexion("ecole","root","");
        } catch (SQLException ex) {
            System.out.println("Error SQL");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error class not found");
        }

    }
    
}
