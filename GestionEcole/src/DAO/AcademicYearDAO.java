package DAO;

import Modele.AcademicYear;
import java.sql.*;
import java.util.*;
import Controller.Connexion;

/**
 *
 * @author lelel
 */
public class AcademicYearDAO extends DAO<AcademicYear>{
    private Statement stat;
    public AcademicYearDAO(Connexion conn){
        super(conn);
        this.stat = null;
    }

    @Override
    public void create(AcademicYear obj) {
          String created = "INSERT INTO academicyear(ID) VALUES ('" +
                obj.getId() + "')";
        try {
            this.connect.executeUpdate(created);
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
    }

    @Override
    public void delete(AcademicYear obj) {
        String deleted = "DELETE FROM academicyear WHERE ID = '" + obj.getId() +"'";
        try {
            this.connect.executeUpdate(deleted);
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
    }

    //Peu utile pour cette classe
    @Override
    public void update(AcademicYear obj) {
        String updated = "UPDATE academicyear "
                + "SET ID = '" + obj.getId() + 
                " WHERE ID ='" + obj.getId() + "'";
        try {
            this.connect.executeUpdate(updated);
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
    }

    @Override
    public AcademicYear find(int id) {
        AcademicYear ay = new AcademicYear();
        String found = "SELECT * FROM academicyear WHERE ID = '" + id +"'";
        try {
            this.stat = this.connect.getConnection().createStatement();
            ResultSet rs = this.stat.executeQuery(found);
            if(rs.first()){
                ay = new AcademicYear(rs.getInt("ID"));
            }
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
        return ay;
    }
    
    @Override
    public ArrayList<AcademicYear> getAll() {
        ArrayList<AcademicYear> res = new ArrayList<>();
        String all = "SELECT * FROM academicyear";
        try {
            this.stat = this.connect.getConnection().createStatement();
            ResultSet rs = this.stat.executeQuery(all);
            while(rs.next()){
                AcademicYear ay = new AcademicYear(rs.getInt("ID"));
                res.add(ay);
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
