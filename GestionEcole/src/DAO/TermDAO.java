package DAO;

import Modele.Term;
import com.mysql.jdbc.Connection;

/**
 *
 * @author lelel
 */
public class TermDAO extends DAO<Term>{
    public TermDAO(Connection conn){
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
