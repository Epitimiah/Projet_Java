package DAO;

import Modele.Term;
import com.mysql.jdbc.Connection;
import java.util.ArrayList;
import Controller.Connexion;

/**
 *
 * @author lelel
 */
public class TermDAO extends DAO<Term>{
    public TermDAO(Connexion conn){
        super(conn);
    }

    @Override
    public void create(Term obj) {
         
    }

    @Override
    public void delete(Term obj) {
        
    }

    @Override
    public void update(Term obj) {
        
    }

    @Override
    public Term find(int id) {
        Term t = new Term();
        return t;
    }

    public ArrayList<Term> getAll() {
        ArrayList<Term> res = new ArrayList<>();
        res.add(new Term(0, 1, "5 septembre", "20 décembre", 0));
        return res;
    }
}
