package Controller;

import Modele.Field;
import java.sql.*;
import java.util.*;

/**
 * Classe pour la table "field" de la base de données
 * @author Adrien Lea  Levanah
 */
public class FieldDAO extends DAO<Field>{
    private Statement stat;
    public FieldDAO(Connexion conn){
        super(conn);
        this.stat = null;
    }

    /**
     * Permet d'ajouter un objet de la classe "matiere" dans la base de données
     * @param obj 
     */
    @Override
    public void create(Field obj) {
         String created = "INSERT INTO field(Name) VALUES ('" +
                obj.getName() + "')";
        try {
            this.connect.executeUpdate(created);
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
    }

    /**
     * Permet de supprimer un objet de la classe "matiere" dans la base de données
     * @param obj 
     */
    @Override
    public void delete(Field obj) {
        String deleted = "DELETE FROM field WHERE ID = '" + obj.getId() +"'";
        try {
            this.connect.executeUpdate(deleted);
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
    }

    /**
     * Permet de mettre à jour un objet de la classe "matiere" dans la base de données
     * @param obj 
     */
    @Override
    public void update(Field obj) {
        String updated = "UPDATE field "
                + "SET Name = '" + obj.getName()
                + " WHERE ID ='" + obj.getId() + "'";
        try {
            this.connect.executeUpdate(updated);
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
    }
    
    /**
     * Permet de chercher un objet de la classe "matiere" dans la base de données
     * @param id
     * @return l'objet correspondant a la recherche
     */
    @Override
    public Field find(int id) {
        Field f = new Field();
        String found = "SELECT * FROM field WHERE ID = '" + id +"'";
        try {
            this.stat = this.connect.getConnection().createStatement();
            ResultSet rs = this.stat.executeQuery(found);
            if(rs.first()){
                f = new Field(rs.getInt("ID"), 
                        rs.getString("Name"));
            }
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
        return f;
    }
    
    /**
     * Permet de recuperer tous les objets de la classe "matiere" dans la base de données
     * @return une arraylist avec tous les objets de la table
     */
    @Override
    public ArrayList<Field> getAll() {
        ArrayList<Field> res = new ArrayList<>();
        String all = "SELECT * FROM field";
        try {
            this.stat = this.connect.getConnection().createStatement();
            ResultSet rs = this.stat.executeQuery(all);
            while(rs.next()){
                Field f = new Field(rs.getInt("ID"), 
                        rs.getString("Name"));
                res.add(f);
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
