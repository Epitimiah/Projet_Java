package DAO;

import Modele.Course;
import com.mysql.jdbc.Connection;

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
}
