package Controller;

import Modele.Grade;
import java.sql.*;
import java.util.*;

/**
 * 
 * @author Adrien  Lea Levanah
 */
public class GradeDAO extends DAO<Grade>{
    private Statement stat;
    public GradeDAO(Connexion conn){
        super(conn);
        this.stat = null;
    }

    /**
     * Permet d'ajouter un objet de la classe "note" dans la base de données
     * @param obj 
     */
    @Override
    public void create(Grade obj) {
         String created = "INSERT INTO grade(Grade, GradeComment, IDreportCardDetail) VALUES ('" +
                obj.getGrade() + "','" + obj.getGradeCom() + "','" + obj.getIdRCDetail() + "')";
        try {
            this.connect.executeUpdate(created);
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
    }

    /**
     * Permet de supprimer un objet de la classe "note" dans la base de données
     * @param obj 
     */
    @Override
    public void delete(Grade obj) {
        String deleted = "DELETE FROM grade WHERE ID = '" + obj.getId() +"'";
        try {
            this.connect.executeUpdate(deleted);
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
    }

    /**
     * Permet de mettre ajour un objet de la classe "note" dans la base de données
     * @param obj 
     */
    @Override
    public void update(Grade obj) {
        String updated = "UPDATE grade "
                + "SET Grade = '" + obj.getGrade() + 
                "', GradeComment = '"+ obj.getGradeCom() + "', IDreportCardDetail = '"
                + obj.getIdRCDetail() + "'"
                + " WHERE ID ='" + obj.getId() + "'";
        try {
            this.connect.executeUpdate(updated);
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
    }

    /**
     * Permet de trouver un objet de la classe "note" dans la base de données
     * @param id
     * @return l'objet correspondant à la recherche
     */
    @Override
    public Grade find(int id) {
        Grade g = new Grade();
        String found = "SELECT * FROM grade WHERE ID = '" + id +"'";
        try {
            this.stat = this.connect.getConnection().createStatement();
            ResultSet rs = this.stat.executeQuery(found);
            if(rs.first()){
                g = new Grade(rs.getInt("ID"), 
                        rs.getInt("Grade"), rs.getString("GradeComment"), rs.getInt("IDreportCardDetail"));
            }
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
        return g;
    }
    
    /**
     * Permet de recuperer tous les objets de la table "note" de la base données
     * @return une arraylist avec tous les objets de la table
     */
    @Override
    public ArrayList<Grade> getAll() {
        ArrayList<Grade> res = new ArrayList<>();
        String all = "SELECT * FROM grade";
        try {
            this.stat = this.connect.getConnection().createStatement();
            ResultSet rs = this.stat.executeQuery(all);
            while(rs.next()){
                Grade g = new Grade(rs.getInt("ID"), 
                        rs.getInt("Grade"), rs.getString("GradeComment"), rs.getInt("IDreportCardDetail"));
                res.add(g);
            }
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
//        for(int i = 0 ; i < res.size() ; i++){
//            System.out.println(res.get(i).getFirstName());    
//        }
        return res;
    }
    
    public ArrayList<Grade> findFromReportCardDetailID(int id) {
        ArrayList<Grade> res = new ArrayList<>();
        String check = "SELECT * FROM grade WHERE IDreportCardDetail = '" + id + "'";
        System.out.println(check);
        try {
            this.stat = this.connect.getConnection().createStatement();
            ResultSet rs = this.stat.executeQuery(check);
            while (rs.next()) {
                res.add(new Grade(rs.getInt("ID"),
                        rs.getFloat("Grade"),
                        rs.getString("GradeComment"),
                        rs.getInt("IDReportCardDetail")));
            }
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
        return res;
    }
}

