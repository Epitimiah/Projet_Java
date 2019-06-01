package DAO;

import com.mysql.jdbc.Connection;
import Modele.Student;

/**
 *
 * @author lelel
 */
public class StudentDAO extends DAO<Student> {
    public StudentDAO(Connection conn){
        super(conn);
    }

    @Override
    public void create(Student obj) {
         
    }

    @Override
    public void delete(Student obj) {
        
    }

    @Override
    public void update(Student obj) {
        
    }

    @Override
    public Student find(int id) {
        Student s = new Student();
        return s;
    }
}
