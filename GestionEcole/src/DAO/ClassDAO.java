package DAO;

import Modele.Classe;
import com.mysql.jdbc.Connection;
import java.util.ArrayList;

/**
 *
 * @author lelel
 */
public class ClassDAO extends DAO<Classe>{
    public ClassDAO(Connection conn){
        super(conn);
    }

    @Override
    public void create(Classe obj) {
         
    }

    @Override
    public void delete(Classe obj) {
        
    }

    @Override
    public void update(Classe obj) {
        
    }

    @Override
    public Classe find(int id) {
        Classe c = new Classe();
        return c;
    }
    
    public ArrayList<Classe> getAll() {
        ArrayList<Classe> res = new ArrayList<>();
        res.add(new Classe(0, "A", 1, 1));
        res.add(new Classe(1, "B", 2, 2));
        res.add(new Classe(2, "C", 3, 3));
        res.add(new Classe(3, "D", 4, 4));
        return res;
    }
}
