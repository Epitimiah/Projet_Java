package Controller;

import Modele.Student;
import java.util.*;
import java.sql.*;


/**
 * Classe pour la table "student" de la base de données
 * @author Adrien  Lea  Levanah
 */
public class StudentDAO extends DAO<Student> {
    private Statement stat;
    public StudentDAO(Connexion conn){
        super(conn);
        this.stat = null;
    }

    /**
     * Permet d'ajouter un objet de la classe "eleve" dans la base de données
     * @param obj 
     */
    @Override
    public void create(Student obj) {
        String created = "INSERT INTO student(FirstName, LastName, IDClass) VALUES ('" +
                obj.getFirstName() + "','" + obj.getLastName() + "','" + obj.getIdClass() + "')";
        try {
            this.connect.executeUpdate(created);
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
    }

    /**
     * Permet de supprimer un objet de la classe "eleve" dans la base de données
     * @param obj 
     */
    @Override
    public void delete(Student obj) {
        String deleted = "DELETE FROM student WHERE ID = '" + obj.getId() +"'";
        try {
            this.connect.executeUpdate(deleted);
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
    }

    /**
     * Permet de mettre a jour un objet de la classe "eleve" dans la base de données
     * @param obj 
     */
    @Override
    public void update(Student obj) {
        String updated = "UPDATE student "
                + "SET FirstName = '" + obj.getFirstName() + 
                "', LastName = '"+ obj.getLastName() + "', IDClass = '"+ obj.getIdClass() + "'"
                + " WHERE ID ='" + obj.getId() + "'";
        try {
            this.connect.executeUpdate(updated);
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
    }
    
    /**
     * Permet de chercher un objet de la classe "eleve" dans la base de données
     * @param id
     * @return l'objet correspondant à la recherche
     */
    @Override
    public Student find(int id) {
        Student s = new Student();
        String found = "SELECT * FROM student WHERE ID = '" + id +"'";
        try {
            this.stat = this.connect.getConnection().createStatement();
            ResultSet rs = this.stat.executeQuery(found);
            if(rs.first()){
                s = new Student(rs.getInt("ID"), 
                        rs.getString("FirstName"), rs.getString("LastName"), rs.getInt("IDClass"));
            }
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
        return s;
    }

    /**
     * Permet de recuperer tous les objets de la table "eleve" de la base de données
     * @return une arraylist de tous les objets de la table
     */
    @Override
    public ArrayList<Student> getAll() {
        ArrayList<Student> res = new ArrayList<>();
        String all = "SELECT * FROM student";
        try {
            this.stat = this.connect.getConnection().createStatement();
            ResultSet rs = this.stat.executeQuery(all);
            while(rs.next()){
                Student stu = new Student(rs.getInt("ID"), 
                        rs.getString("FirstName"), rs.getString("LastName"), rs.getInt("IDClass"));
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
    
    public ArrayList<Student> findFromSimilarName(String name) {
        ArrayList<Student> res = new ArrayList<>();
        String all = "SELECT * FROM student WHERE FirstName LIKE '%" + name + "%'";
        try {
            this.stat = this.connect.getConnection().createStatement();
            ResultSet rs = this.stat.executeQuery(all);
            while(rs.next()){
                Student stu = new Student(rs.getInt("ID"), 
                        rs.getString("FirstName"), 
                        rs.getString("LastName"), 
                        rs.getInt("IDClass"));
                res.add(stu);
            }
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
        return res;
    }
    
    public ArrayList<Student> findFromClasseID(int id) {
        ArrayList<Student> res = new ArrayList<>();
        String all = "SELECT * FROM student WHERE IDClass = '" + id + "'";
        //System.out.println(all);
        try {
            this.stat = this.connect.getConnection().createStatement();
            ResultSet rs = this.stat.executeQuery(all);
            while(rs.next()){
                Student stu = new Student(rs.getInt("ID"), 
                        rs.getString("FirstName"), 
                        rs.getString("LastName"), 
                        rs.getInt("IDClass"));
                res.add(stu);
            }
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
        return res;
    }
}
