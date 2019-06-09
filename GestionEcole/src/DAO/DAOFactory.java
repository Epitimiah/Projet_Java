package DAO;

import Controller.Connexion;
<<<<<<< Updated upstream
import com.mysql.jdbc.Connection;
=======
>>>>>>> Stashed changes
import java.sql.SQLException;

/**
 * Classe permettant la creation d'objet des differentes classes DAO 
 * et d'etablir leur connexion à la base de données
 * @author Adrien & Lea & Levanah
 */
public class DAOFactory {
    /**
     * Module pour la connexion à la base de données
     */
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
  
  /**
   * Permet d'appeler TeacherDAO pour creer un objet de la classe
   * @return un objet de la classe
   */
  public static DAO getTeacherDAO(){
    return new TeacherDAO(conn);
  }
  
  /**
   * Permet d'appeler StudentDAO pour creer un objet de la classe
   * @return un objet de la classe
   */
  public static DAO getStudentDAO(){
    return new StudentDAO(conn);
  }
  
  /**
   * Permet d'appeler TermDAO pour creer un objet de la classe
   * @return un objet de la classe
   */
  public static DAO getTermDAO(){
    return new TermDAO(conn);
  }
  
  /**
   * Permet d'appeler ReportCardDetailDAO pour creer un objet de la classe
   * @return un objet de la classe
   */
  public static DAO getReportCardDetailDAO(){
    return new ReportCardDetailDAO(conn);
  }
  
  /**
   * Permet d'appeler ReportCardDAO pour creer un objet de la classe
   * @return un objet de la classe
   */
  public static DAO getReportCardDAO(){
    return new ReportCardDAO(conn);
  }
  
  /**
   * Permet d'appeler LevelDAO pour creer un objet de la classe
   * @return un objet de la classe
   */
  public static DAO getLevelDAO(){
    return new LevelDAO(conn);
  }
  
  /**
   * Permet d'appeler GradeDAO pour creer un objet de la classe
   * @return un objet de la classe
   */
  public static DAO getGradeDAO(){
    return new GradeDAO(conn);
  }
  
  /**
   * Permet d'appeler FieldDAO pour creer un objet de la classe
   * @return un objet de la classe
   */
  public static DAO getFieldDAO(){
    return new FieldDAO(conn);
  }
  
  /**
   * Permet d'appeler CourseDAO pour creer un objet de la classe
   * @return un objet de la classe
   */
  public static DAO getCourseDAO(){
    return new CourseDAO(conn);
  }
  
  /**
   * Permet d'appeler ClassDAO pour creer un objet de la classe
   * @return un objet de la classe
   */
  public static DAO getClassDAO(){
    return new ClasseDAO(conn);
  }
  
  /**
   * Permet d'appeler AcademicYearDAO pour creer un objet de la classe
   * @return un objet de la classe
   */
  public static DAO getAcademicYearDAO(){
    return new AcademicYearDAO(conn);
  }
}
