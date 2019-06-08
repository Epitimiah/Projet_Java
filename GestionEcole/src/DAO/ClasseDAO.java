package DAO;

import Modele.Classe;
import java.sql.*;
import Controller.Connexion;
import java.util.*;

/**
 *
 * @author lelel
 */
public class ClasseDAO extends DAO<Classe>{
    private Statement stat;
    public ClasseDAO(Connexion conn){
        super(conn);
        this.stat = null;
    }

    @Override
    public void create(Classe obj) {
         String created = "INSERT INTO class(Name, IDlevel, IDacademicYear) VALUES ('" +
                obj.getName() + "','" + obj.getIdLevel() + "','" + obj.getIdAcademicYear() + "')";
        try {
            this.connect.executeUpdate(created);
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
    }

    @Override
    public void delete(Classe obj) {
        String deleted = "DELETE FROM class WHERE ID = '" + obj.getId() +"'";
        try {
            this.connect.executeUpdate(deleted);
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
    }

    @Override
    public void update(Classe obj) {
        String updated = "UPDATE class "
                + "SET Name = '" + obj.getName() + 
                "', IDlevel = '"+ obj.getIdLevel() + "', IDacademicYear = '"
                + obj.getIdAcademicYear() + "'"
                + " WHERE ID ='" + obj.getId() + "'";
        try {
            this.connect.executeUpdate(updated);
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
    }

    @Override
    public Classe find(int id) {
        Classe c = new Classe();
        String found = "SELECT * FROM class WHERE ID = '" + id +"'";
        try {
            this.stat = this.connect.getConnection().createStatement();
            ResultSet rs = this.stat.executeQuery(found);
            if(rs.first()){
                c = new Classe(rs.getInt("ID"), 
                        rs.getString("Name"), rs.getInt("IDlevel"), rs.getInt("IDacademicYear"));
            }
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
        return c;
    }

    public ArrayList<Classe> getAll() {
        ArrayList<Classe> res = new ArrayList<>();
        String all = "SELECT * FROM class";
        try {
            this.stat = this.connect.getConnection().createStatement();
            ResultSet rs = this.stat.executeQuery(all);
            while(rs.next()){
                Classe cl = new Classe(rs.getInt("ID"), 
                        rs.getString("Name"), rs.getInt("IDlevel"), rs.getInt("IDacademicYear"));
                res.add(cl);
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
