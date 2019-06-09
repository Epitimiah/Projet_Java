package DAO;

import Modele.Teacher;
import java.util.*;
import Controller.Connexion;
import java.sql.*;

/**
 * Classe pour la table "teacher" de la base de données
 * @author Adrien & Lea & Levanah
 */
public class TeacherDAO extends DAO<Teacher>{
    private Statement stat;
    public TeacherDAO(Connexion conn){
        super(conn);
        this.stat = null;
    }

    /**
     * Permet d'ajouter un objet de la classe "professeur" dans la base de données
     * @param obj 
     */
    @Override
    public void create(Teacher obj) {
         String created = "INSERT INTO teacher(FirstName, LastName) VALUES ('" + 
                obj.getFirstName() + "','" + obj.getLastName() + "')";
        try {
            this.connect.executeUpdate(created);
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
    }

    /**
     * Permet de supprimer un objet de la classe "professeur" dans la base de données
     * @param obj 
     */
    @Override
    public void delete(Teacher obj) {
        String deleted = "DELETE FROM teacher WHERE ID = '" + obj.getId() +"'";
        try {
            this.connect.executeUpdate(deleted);
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
    }

    /**
     * Permet de mettre a jour un objet de la classe "professeur" dans la base de données
     * @param obj 
     */
    @Override
    public void update(Teacher obj) {
        String updated = "UPDATE teacher "
                + "SET FirstName = '" + obj.getFirstName() + 
                "', LastName = '"+ obj.getLastName()
                + "' WHERE ID ='" + obj.getId() + "'";
        try {
            this.connect.executeUpdate(updated);
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
    }

    /**
     * Permet de chercher un objet de la classe "professeur" dans la base de données
     * @param id
     * @return l'objet correspondant à la recherche
     */
    @Override
    public Teacher find(int id) {
        Teacher t = new Teacher();
        String found = "SELECT * FROM teacher WHERE ID = '" + id +"'";
        try {
            this.stat = this.connect.getConnection().createStatement();
            ResultSet rs = this.stat.executeQuery(found);
            if(rs.first()){
                t = new Teacher(rs.getInt("ID"), 
                        rs.getString("FirstName"), rs.getString("LastName"));
            }
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
        return t;
    }
    
    /**
     * Permet de verifier si un professeur existe dans la base de donnees ou non
     * @param name
     * @param surname
     * @return true ou false selon si le professeur est dans la base de données ou non
     */
    public boolean findIfExistsFromName(String name, String surname) {
        String check = "SELECT * FROM teacher WHERE LastName = '" + name + "' AND FirstName = '" + surname + "'";
        try {
            this.stat = this.connect.getConnection().createStatement();
            ResultSet rs = this.stat.executeQuery(check);
            while(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
        return false;
    }
    
    /**
     * Permet de recuperer tous les objets de la table "professeur" de la base de données
     * @return une arraylist de tous les objets de la table
     */
    public ArrayList<Teacher> getAll() {
        ArrayList<Teacher> res = new ArrayList<>();
        String all = "SELECT * FROM teacher";
        try {
            this.stat = this.connect.getConnection().createStatement();
            ResultSet rs = this.stat.executeQuery(all);
            while(rs.next()){
                Teacher tea = new Teacher(rs.getInt("ID"), 
                        rs.getString("FirstName"), rs.getString("LastName"));
                res.add(tea);
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
