package DAO;

import com.mysql.jdbc.Connection;
import Modele.Student;
import java.util.ArrayList;
import Controller.Connexion;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lelel
 */
public class StudentDAO extends DAO<Student> {
    public StudentDAO(Connexion conn){
        super(conn);
    }

    @Override
    public void create(Student obj) {
        String created = "INSERT INTO student(FirstName, LastName) VALUES (" + 
                ",'" + obj.getFirstName() + "'," +  ",'" + obj.getLastName() + "')";
        try {
            this.connect.executeUpdate(created);
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
    }

    @Override
    public void delete(Student obj) {
        String deleted = "DELETE FROM student WHERE ID = '" + obj.getId() +"'";
        try {
            this.connect.executeUpdate(deleted);
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
    }

    @Override
    public void update(Student obj) {
        String updated = "UPDATE student"
                + "SET FirstName = '" + obj.getFirstName() + "', LastName = '"+ obj.getLastName() +"',"
                + "WHERE ID ='" + obj.getId() +"'";
        try {
            this.connect.executeUpdate(updated);
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
    }
    
    //requete sql
    @Override
    public Student find(int id) {
        Student s = new Student();
        return s;
    }

    public ArrayList<Student> getAll() {
        ArrayList<Student> res = new ArrayList<>();
        res.add(new Student(0, "Morane", "Bob", 0));
        return res;
    }
}
