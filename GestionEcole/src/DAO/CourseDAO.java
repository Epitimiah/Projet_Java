package DAO;

import Modele.Course;
import java.sql.*;
import java.util.*;
import Controller.Connexion;

/**
 *
 * @author lelel
 */
public class CourseDAO extends DAO<Course>{
    private Statement stat;
    public CourseDAO(Connexion conn){
        super(conn);
        this.stat = null;
    }

    @Override
    public void create(Course obj) {
         String created = "INSERT INTO course(IDteacher, IDfield, IDclass) VALUES ('" +
                obj.getIdTeacher() + "','" + obj.getIdField() + "','" + obj.getIdClass() + "')";
        try {
            this.connect.executeUpdate(created);
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
    }

    @Override
    public void delete(Course obj) {
        String deleted = "DELETE FROM course WHERE ID = '" + obj.getId() +"'";
        try {
            this.connect.executeUpdate(deleted);
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
    }

    @Override
    public void update(Course obj) {
        String updated = "UPDATE course "
                + "SET IDteacher = '" + obj.getIdTeacher() + 
                "', IDfield = '"+ obj.getIdField() + "', IDclass = '"+ obj.getIdClass() + "'"
                + " WHERE ID ='" + obj.getId() + "'";
        try {
            this.connect.executeUpdate(updated);
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
    }

    @Override
    public Course find(int id) {
        Course c = new Course();
        String found = "SELECT * FROM course WHERE ID = '" + id +"'";
        try {
            this.stat = this.connect.getConnection().createStatement();
            ResultSet rs = this.stat.executeQuery(found);
            if(rs.first()){
                c = new Course(rs.getInt("ID"), 
                        rs.getInt("IDteacher"), rs.getInt("IDfield"), rs.getInt("IDlass"));
            }
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
        return c;
    }

    public ArrayList<Course> getAll() {
        ArrayList<Course> res = new ArrayList<>();
        String all = "SELECT * FROM course";
        try {
            this.stat = this.connect.getConnection().createStatement();
            ResultSet rs = this.stat.executeQuery(all);
            while(rs.next()){
                Course c = new Course(rs.getInt("ID"), 
                        rs.getInt("IDteacher"), rs.getInt("IDfield"), rs.getInt("IDlass"));
                res.add(c);
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
