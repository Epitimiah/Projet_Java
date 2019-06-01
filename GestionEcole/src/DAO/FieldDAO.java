package DAO;

import Modele.Field;
import com.mysql.jdbc.Connection;

/**
 *
 * @author lelel
 */
public class FieldDAO extends DAO<Field>{
    public FieldDAO(Connection conn){
        super(conn);
    }

    @Override
    public void create(Field obj) {
         
    }

    @Override
    public void delete(Field obj) {
        
    }

    @Override
    public void update(Field obj) {
        
    }

    @Override
    public Field find(int id) {
        Field f = new Field();
        return f;
    }
}
