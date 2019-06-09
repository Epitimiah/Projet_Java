package DAO;

import Modele.Level;
import java.sql.*;
import java.util.ArrayList;
import Controller.Connexion;

/**
 * Classe pour la table "level" de la base de données
 * @author Adrien & Lea & Levanah
 */
public class LevelDAO extends DAO<Level>{
    private Statement stat;
    public LevelDAO(Connexion conn){
        super(conn);
        this.stat = null;
    }

    /**
     * Permet d'ajouter un objet de la classe "niveau" dans la base de données
     * @param obj 
     */
    @Override
    public void create(Level obj) {
         String created = "INSERT INTO level(Name) VALUES ('" +
                obj.getName() + "')";
        try {
            this.connect.executeUpdate(created);
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
    }

    /**
     * Permet de supprimer un objet de la classe "niveau" dans la base de données
     * @param obj 
     */
    @Override
    public void delete(Level obj) {
        String deleted = "DELETE FROM level WHERE ID = '" + obj.getId() +"'";
        try {
            this.connect.executeUpdate(deleted);
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
    }

    /**
     * Permet de mettre a jour un objet de la classe "niveau" dans la base de données
     * @param obj 
     */
    @Override
    public void update(Level obj) {
        String updated = "UPDATE level "
                + "SET FirstName = '" + obj.getName() + 
                " WHERE ID ='" + obj.getId() + "'";
        try {
            this.connect.executeUpdate(updated);
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
    }

    /**
     * Permet de trouver un objet de la classe "niveau" dans la base de données
     * @param id
     * @return l'objet correspondant à la recherche
     */
    @Override
    public Level find(int id) {
        Level lvl = new Level();
        String found = "SELECT * FROM level WHERE ID = '" + id +"'";
        try {
            this.stat = this.connect.getConnection().createStatement();
            ResultSet rs = this.stat.executeQuery(found);
            if(rs.first()){
                lvl = new Level(rs.getInt("ID"), 
                        rs.getString("Name"));
            }
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
        return lvl;
    }
    
    /**
     * Permet de recuperer tous les objets de la table "niveau" de la base de données
     * @return une arraylist avec tous les objets de la table
     */
    @Override
    public ArrayList<Level> getAll() {
        ArrayList<Level> res = new ArrayList<>();
        String all = "SELECT * FROM level";
        try {
            this.stat = this.connect.getConnection().createStatement();
            ResultSet rs = this.stat.executeQuery(all);
            while(rs.next()){
                Level l = new Level(rs.getInt("ID"), 
                        rs.getString("Name"));
                res.add(l);
            }
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
//        for(int i = 0 ; i < res.size() ; i++){
//            System.out.println(res.get(i).getFirstName());    
//        }
        return res;
    }
}
