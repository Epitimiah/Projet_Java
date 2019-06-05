package DAO;

import Modele.Course;
import com.mysql.jdbc.Connection;
import java.util.ArrayList;

/**
 *
 * @author lelel
 */
public class CourseDAO extends DAO<Course>{
    public CourseDAO(Connection conn){
        super(conn);
    }

    @Override
    public void create(Course obj) {
         
    }

    @Override
    public void delete(Course obj) {
        
    }

    @Override
    public void update(Course obj) {
        
    }

    @Override
    public Course find(int id) {
        Course c = new Course();
        return c;
    }

    public ArrayList<Course> getAll() {
        ArrayList<Course> res = new ArrayList<>();
        res.add(new Course(1, 2, 3, 4));
        return res;
    }
}
