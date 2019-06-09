package DAO;

import Modele.ReportCard;
import java.util.*;
import java.sql.*;
import Controller.Connexion;

/**
 *
 * @author lelel
 */
public class ReportCardDAO extends DAO<ReportCard> {

    private Statement stat;

    public ReportCardDAO(Connexion conn) {
        super(conn);
        this.stat = null;
    }

    @Override
    public void create(ReportCard obj) {
        String created = "INSERT INTO reportcard(GeneralComment, IDterm, IDstudent) VALUES ('"
                + obj.getGeneCom() + "','" + obj.getIdTerm() + "','" + obj.getIdStudent() + "')";
        try {
            this.connect.executeUpdate(created);
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
    }

    @Override
    public void delete(ReportCard obj) {
        String deleted = "DELETE FROM reportcard WHERE ID = '" + obj.getId() + "'";
        try {
            this.connect.executeUpdate(deleted);
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
    }

    @Override
    public void update(ReportCard obj) {
        String updated = "UPDATE reportcard "
                + "SET GeneralComment = '" + obj.getGeneCom()
                + "', IDterm = '" + obj.getIdTerm() 
                + "', IDstudent = '" + obj.getIdStudent() + "'"
                + " WHERE ID ='" + obj.getId() + "'";
        System.out.println(updated);
        try {
            this.connect.executeUpdate(updated);
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
    }

    @Override
    public ReportCard find(int id) {
        ReportCard rc = new ReportCard();
        String found = "SELECT * FROM reportcard WHERE ID = '" + id + "'";
        try {
            this.stat = this.connect.getConnection().createStatement();
            ResultSet rs = this.stat.executeQuery(found);
            if (rs.first()) {
                rc = new ReportCard(rs.getInt("ID"),
                        rs.getString("GeneralComment"),
                        rs.getInt("IDterm"),
                        rs.getInt("IDstudent"));
            }
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
        return rc;
    }

    /**
     * Methode permettant de trouver le bulletin correspondant a un eleve
     *
     * @param idStudent
     * @return un bulletin
     */
    public ReportCard findFromStudentID(int idStudent) {
        String check = "SELECT * FROM reportcard WHERE IDstudent = '" + idStudent + "' LIMIT 1";
        System.out.println(check);
        try {
            this.stat = this.connect.getConnection().createStatement();
            ResultSet rs = this.stat.executeQuery(check);
            while (rs.first()) {
                ReportCard rc = new ReportCard(rs.getInt("ID"),
                        rs.getString("GeneralComment"),
                        rs.getInt("IDterm"),
                        rs.getInt("IDstudent"));
                return rc;
            }
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
        return null;
    }

    /**
     * Methode prenant tous les bulletins de la BDD et les met dans une
     * arraylist
     *
     * @return une arraylist de bulletins
     */
    @Override
    public ArrayList<ReportCard> getAll() {
        ArrayList<ReportCard> res = new ArrayList<>();
        String all = "SELECT * FROM reportcard";
        try {
            this.stat = this.connect.getConnection().createStatement();
            ResultSet rs = this.stat.executeQuery(all);
            while (rs.next()) {
                ReportCard stu = new ReportCard(rs.getInt("ID"),
                        rs.getString("GeneralComment"),
                        rs.getInt("IDterm"),
                        rs.getInt("IDstudent"));
                res.add(stu);
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
