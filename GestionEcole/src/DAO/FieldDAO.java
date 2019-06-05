package DAO;

import Modele.AcademicYear;
import Modele.Field;
import com.mysql.jdbc.Connection;
import java.util.ArrayList;

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
    
    public ArrayList<Field> getAll() {
        ArrayList<Field> res = new ArrayList<>();
        res.add(new Field(0, "SVT"));
        return res;
    }
}
