package DAO;

import com.mysql.jdbc.Connection;
import Modele.Student;
import Main.Connexion;
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
    public void create(Student objt) {
        String created = "INSERT INTO student(FirstName, LastName) VALUES (" + 
                ",'" + objt.getFirstName() + "'," +  ",'" + objt.getLastName() + "')";
        try {
            this.connect.executeUpdate(created);
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
    }

    //utiliser id
    @Override
    public void delete(Student obj) {
        String deleted = "";
        deleted = "DELETE FROM ";
    }

    //utiliser id
    @Override
    public void update(Student obj) {
        String updated = "";
        updated = "UPDATE ecole SET colonne = 'nouvelle valeur' WHERE a = b";
    }
    
    //requete sql
    @Override
    public Student find(int id) {
        Student s = new Student();
        return s;
    }
}
