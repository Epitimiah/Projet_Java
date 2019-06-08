package Controller;
import DAO.*;
import Modele.*;
import com.mysql.jdbc.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

import Vue.Display;

/**
 *
 * @author Adrien & Lévanah & Léa
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Display display = new Display();

       
        Student s = new Student(8, "oui", "slt", 1);
        DAO<Student> e = DAOFactory.getStudentDAO();
        //e.create(s);
        //e.delete(s);
        //System.out.println(e.find(2).getFirstName());
        //e.update(s);
        //System.out.println(e.getAll());
       
    }
    
}
