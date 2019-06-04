package DAO;

import Modele.Class;
import com.mysql.jdbc.Connection;

/**
 *
 * @author lelel
 */
public class ClassDAO extends DAO<Class>{
    public ClassDAO(Connection conn){
        super(conn);
    }

    @Override
    public void create(Class obj) {
         
    }

    @Override
    public void delete(Class obj) {
        
    }

    @Override
    public void update(Class obj) {
        
    }

    @Override
    public Class find(int id) {
        Class c = new Class();
        return c;
    }
}
