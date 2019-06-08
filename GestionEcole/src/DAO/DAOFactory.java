package DAO;

import Controller.Connexion;

import com.mysql.jdbc.Connection;
import java.sql.SQLException;

/**
 *
 * @author 
 */
public class DAOFactory {
    public static Connexion conn;
    static{
        try {
            DAOFactory.conn = new Connexion("ecole","root","");          
        } catch (SQLException ex) {
            System.out.println("Error SQL");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error class not found");
        }
    }
  
  public static DAO getTeacherDAO(){
    return new TeacherDAO(conn);
  }
  
  public static DAO getStudentDAO(){
    return new StudentDAO(conn);
  }
  
  public static DAO getTermDAO(){
    return new TermDAO(conn);
  }
  
  public static DAO getReportCardDetailDAO(){
    return new ReportCardDetailDAO(conn);
  }
  
  public static DAO getReportCardDAO(){
    return new ReportCardDAO(conn);
  }
  
  public static DAO getLevelDAO(){
    return new LevelDAO(conn);
  }
  
  public static DAO getGradeDAO(){
    return new GradeDAO(conn);
  }
  
  public static DAO getFieldDAO(){
    return new FieldDAO(conn);
  }
  
  public static DAO getCourseDAO(){
    return new CourseDAO(conn);
  }
  
  public static DAO getClassDAO(){
    return new ClasseDAO(conn);
  }
  
  public static DAO getAcademicYearDAO(){
    return new AcademicYearDAO(conn);
  }

  
}
