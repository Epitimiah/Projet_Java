package DAO;

import Modele.ReportCardDetail;
import java.util.*;
import Controller.Connexion;
import java.sql.*;

/**
 *
 * @author lelel
 */
public class ReportCardDetailDAO extends DAO<ReportCardDetail>{
    private Statement stat;
    public ReportCardDetailDAO(Connexion conn){
        super(conn);
        this.stat = null;
    }

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

    @Override
    public void delete(ReportCardDetail obj) {
        String deleted = "DELETE FROM reportcarddetail WHERE ID = '" + obj.getId() +"'";
        try {
            this.connect.executeUpdate(deleted);
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
    }

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
}
