package Controller;

import Modele.ReportCardDetail;
import java.util.*;
import Modele.ReportCard;
import java.sql.*;

/**
 * Classe pour la table "reportcarddetail" de la base de données
 * @author Adrien & Lea & Levanah
 */
public class ReportCardDetailDAO extends DAO<ReportCardDetail>{
    private Statement stat;
    public ReportCardDetailDAO(Connexion conn){
        super(conn);
        this.stat = null;
    }

    /**
     * Permet d'ajouter un objet de la classe "detail bulletin" dans la base de données
     * @param obj 
     */
    @Override
    public void create(ReportCardDetail obj) {
         String created = "INSERT INTO reportcarddetail(IDreportCard, IDCourse, Comment) VALUES ('" +
                obj.getIdRC() + "','" + obj.getIdCourse() + "','" + obj.getComment() + "')";
        try {
            this.connect.executeUpdate(created);
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
    }

    /**
     * Permet de supprimer un objet de la classe "detail bulletin" dans la base de données
     * @param obj 
     */
    @Override
    public void delete(ReportCardDetail obj) {
        String deleted = "DELETE FROM reportcarddetail WHERE ID = '" + obj.getId() +"'";
        try {
            this.connect.executeUpdate(deleted);
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
    }

    /**
     * Permet de mettre a jour un objet de la classe "detail bulletin" dans la base de données
     * @param obj 
     */
    @Override
    public void update(ReportCardDetail obj) {
        String updated = "UPDATE reportcarddetail "
                + "SET IDreportCard = '" + obj.getIdRC() + 
                "', IDcourse = '"+ obj.getIdCourse() + "', Comment = '"+ obj.getComment() + "'"
                + " WHERE ID ='" + obj.getId() + "'";
        try {
            this.connect.executeUpdate(updated);
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
    }

    /**
     * Permet de chercher un objet de la classe "detail bulletin" dans la base de données
     * @param id
     * @return l'objet correspondant à la recherche
     */
    @Override
    public ReportCardDetail find(int id) {
        ReportCardDetail rcd = new ReportCardDetail();
        String found = "SELECT * FROM reportcarddetail WHERE ID = '" + id +"'";
        try {
            this.stat = this.connect.getConnection().createStatement();
            ResultSet rs = this.stat.executeQuery(found);
            if(rs.first()){
                rcd = new ReportCardDetail(rs.getInt("ID"), 
                        rs.getInt("IDreportCard"), rs.getInt("IDcourse"), rs.getString("Comment"));
            }
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
        return rcd;
    }
    
    /**
     * Permet de recuperer tous les objets de la table "detail bulletin" de la base de données
     * @return une arraylist de tous les objets de la table
     */
    @Override
    public ArrayList<ReportCardDetail> getAll() {
        ArrayList<ReportCardDetail> res = new ArrayList<>();
        String all = "SELECT * FROM reportcarddetail";
        try {
            this.stat = this.connect.getConnection().createStatement();
            ResultSet rs = this.stat.executeQuery(all);
            while(rs.next()){
                ReportCardDetail rcd = new ReportCardDetail(rs.getInt("ID"), 
                        rs.getInt("IDreportCard"), rs.getInt("IDcourse"), rs.getString("Comment"));
                res.add(rcd);
            }
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
//        for(int i = 0 ; i < res.size() ; i++){
//            System.out.println(res.get(i).getFirstName());    
//        }
        return res;
    }
    
    public ArrayList<ReportCardDetail> findFromReportCardID(int id) {
        ArrayList<ReportCardDetail> res = new ArrayList<ReportCardDetail>();
        String check = "SELECT * FROM reportcarddetail WHERE IDreportCard = '" + id + "'";
        System.out.println(check);
        try {
            this.stat = this.connect.getConnection().createStatement();
            ResultSet rs = this.stat.executeQuery(check);
            while (rs.next()) {
                res.add(new ReportCardDetail(rs.getInt("ID"),
                        rs.getInt("IDreportCard"),
                        rs.getInt("IDcourse"),
                        rs.getString("Comment")));
            }
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
        return res;
    }
}
