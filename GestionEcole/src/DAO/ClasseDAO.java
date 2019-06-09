package DAO;

import Modele.Classe;
import java.sql.*;
import Controller.Connexion;
import java.util.*;

/**
 * Classe pour la table class de la base de données
 * @author Adrien & Lea & Levanah
 */
public class ClasseDAO extends DAO<Classe>{
    private Statement stat;
    public ClasseDAO(Connexion conn){
        super(conn);
        this.stat = null;
    }

    /**
     * Permet d'ajouter un objet de la classe "classe" dans la base de données
     * @param obj 
     */
    @Override
    public void create(Classe obj) {
         String created = "INSERT INTO class(Name, IDlevel, IDacademicYear) VALUES ('" +
                obj.getName() + "','" + obj.getIdLevel() + "','" + obj.getIdAcademicYear() + "')";
        try {
            this.connect.executeUpdate(created);
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
    }

    /**
     * Permet de supprimer un objet de la classe "classe" dans la base de données
     * @param obj 
     */
    @Override
    public void delete(Classe obj) {
        String deleted = "DELETE FROM class WHERE ID = '" + obj.getId() +"'";
        try {
            this.connect.executeUpdate(deleted);
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
    }

    /**
     * Permet de mettre à jour un objet de la classe "classe" dans la base de données
     * @param obj 
     */
    @Override
    public void update(Classe obj) {
        String updated = "UPDATE class "
                + "SET Name = '" + obj.getName() + 
                "', IDlevel = '"+ obj.getIdLevel() + "', IDacademicYear = '"
                + obj.getIdAcademicYear() + "'"
                + " WHERE ID ='" + obj.getId() + "'";
        try {
            this.connect.executeUpdate(updated);
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
    }

    /**
     * Permet de trouver un objet de la classe "classe" dans la base de données
     * @param id
     * @return l'objet correspondant à la recherche
     */
    @Override
    public Classe find(int id) {
        Classe c = new Classe();
        String found = "SELECT * FROM class WHERE ID = '" + id +"'";
        try {
            this.stat = this.connect.getConnection().createStatement();
            ResultSet rs = this.stat.executeQuery(found);
            if(rs.first()){
                c = new Classe(rs.getInt("ID"), 
                        rs.getString("Name"), rs.getInt("IDlevel"), rs.getInt("IDacademicYear"));
            }
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
        return c;
    }

    /**
     * Permet de recuperer tous les objets de la table "classe" de la base de données
     * @return une arraylist avec tous les objets de la table
     */
    public ArrayList<Classe> getAll() {
        ArrayList<Classe> res = new ArrayList<>();
        String all = "SELECT * FROM class";
        try {
            this.stat = this.connect.getConnection().createStatement();
            ResultSet rs = this.stat.executeQuery(all);
            while(rs.next()){
                Classe cl = new Classe(rs.getInt("ID"), 
                        rs.getString("Name"), rs.getInt("IDlevel"), rs.getInt("IDacademicYear"));
                res.add(cl);
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
