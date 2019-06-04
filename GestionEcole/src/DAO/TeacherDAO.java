package DAO;

import Modele.Teacher;
import com.mysql.jdbc.Connection;

/**
 *
 * @author lelel
 */
public class TeacherDAO extends DAO<Teacher>{
    public TeacherDAO(Connection conn){
        super(conn);
    }

    @Override
    public void create(Teacher obj) {
         
    }

    @Override
    public void delete(Teacher obj) {
        
    }

    @Override
    public void update(Teacher obj) {
        
    }

    @Override
    public Teacher find(int id) {
        Teacher t = new Teacher();
        return t;
    }
}
