package DAO;

import Modele.Term;
import com.mysql.jdbc.Connection;
import Main.Connexion;

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
}
