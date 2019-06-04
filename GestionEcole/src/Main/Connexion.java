package Main;

import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author 
 */
public class Connexion {
    /**
     * Attributs prives : connexion JDBC, statement, ordre requete et resultat
     * requete
     */
    private Connection conn;
    private Statement stmt;
   
    /**
     * ArrayList public pour les tables
     */
    public ArrayList<String> tables = new ArrayList<>();
    /**
     * ArrayList public pour les requêtes de sélection
     */
    public ArrayList<String> requetes = new ArrayList<>();
    /**
     * ArrayList public pour les requêtes de MAJ
     */
    public ArrayList<String> requetesMaj = new ArrayList<>();

    /**
     * Constructeur avec 3 paramètres : nom, login et password de la BDD locale
     *
     * @param nameDatabase
     * @param loginDatabase
     * @param passwordDatabase
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public Connexion(String nameDatabase, String loginDatabase, String passwordDatabase) throws SQLException, ClassNotFoundException {
        // chargement driver "com.mysql.jdbc.Driver"
        Class.forName("com.mysql.jdbc.Driver");

        // url de connexion "jdbc:mysql://localhost:3305/usernameECE"
        String urlDatabase = "jdbc:mysql://localhost/" + nameDatabase;

        //création d'une connexion JDBC à la base 
        conn = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);

        // création d'un ordre SQL (statement)
        stmt = conn.createStatement();
    }
}
