package DAO;

import Modele.Term;
import java.util.*;
import java.sql.*;
import Controller.Connexion;

/**
 *
 * @author lelel
 */
public class TermDAO extends DAO<Term>{
    private Statement stat;
    public TermDAO(Connexion conn){
        super(conn);
        this.stat = null;
    }

    @Override
    public void create(Term obj) {
         String created = "INSERT INTO term(Number, Start, End) VALUES ('" + 
                 obj.getNumber()+ "','" + obj.getStart()+ "','" + obj.getEnd()+ "')";
        try {
            this.connect.executeUpdate(created);
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
    }

    @Override
    public void delete(Term obj) {
        String deleted = "DELETE FROM term WHERE ID = '" + obj.getId() +"'";
        try {
            this.connect.executeUpdate(deleted);
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
    }

    @Override
    public void update(Term obj) {
        String updated = "UPDATE term "
                + "SET Number = '" + obj.getNumber() + 
                "', Start = '"+ obj.getStart() + "', End = '"+ obj.getEnd() +  
                "', IDacademicYear = '"+ obj.getIdAcademicYear() +
                "' WHERE ID ='" + obj.getId() + "'";
        try {
            this.connect.executeUpdate(updated);
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
    }

    @Override
    public Term find(int id) {
        Term t = new Term();
        String found = "SELECT * FROM term WHERE ID = '" + id +"'";
        try {
            this.stat = this.connect.getConnection().createStatement();
            ResultSet rs = this.stat.executeQuery(found);
            if(rs.first()){
                t = new Term(rs.getInt("ID"), 
                        rs.getInt("Number"), rs.getString("Start"), rs.getString("End"), 
                        rs.getInt("IDacademicYear"));
            }
        } catch (SQLException ex) {
            System.out.println("Error SQL request");
        }
        return t;
    }

    @Override
    public ArrayList<Term> getAll() {
        ArrayList<Term> res = new ArrayList<>();
        String all = "SELECT * FROM termt";
        try {
            this.stat = this.connect.getConnection().createStatement();
            ResultSet rs = this.stat.executeQuery(all);
            while(rs.next()){
                Term t = new Term(rs.getInt("ID"), 
                        rs.getInt("Number"), rs.getString("Start"), rs.getString("End"), 
                        rs.getInt("IDacademicYear"));
                res.add(t);
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
