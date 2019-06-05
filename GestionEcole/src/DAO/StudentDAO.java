package DAO;

import com.mysql.jdbc.Connection;
import Modele.Student;
import java.util.ArrayList;

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

    public ArrayList<Student> getAll() {
        ArrayList<Student> res = new ArrayList<>();
        res.add(new Student(0, "Morane", "Bob", 0));
        return res;
    }
}
