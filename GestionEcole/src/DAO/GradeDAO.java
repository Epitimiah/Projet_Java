package DAO;

import Modele.Grade;
import java.sql.*;
import Controller.Connexion;
import java.util.*;

/**
 *
 * @author lelel
 */
public class GradeDAO extends DAO<Grade>{
    private Statement stat;
    public GradeDAO(Connexion conn){
        super(conn);
        this.stat = null;
    }

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

    @Override
    public void delete(Grade obj) {
        String deleted = "DELETE FROM grade WHERE ID = '" + obj.getId() +"'";
        try {
            this.connect.executeUpdate(deleted);
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
    }

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
}

