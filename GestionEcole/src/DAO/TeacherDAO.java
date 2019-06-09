package DAO;

import Modele.Teacher;
import java.util.*;
import Controller.Connexion;
import java.sql.*;

/**
 *
 * @author lelel
 */
public class TeacherDAO extends DAO<Teacher>{
    private Statement stat;
    public TeacherDAO(Connexion conn){
        super(conn);
        this.stat = null;
    }

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

    @Override
    public void delete(Teacher obj) {
        String deleted = "DELETE FROM teacher WHERE ID = '" + obj.getId() +"'";
        try {
            this.connect.executeUpdate(deleted);
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
    }

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
