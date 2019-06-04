package DAO;

import Main.Connexion;

import com.mysql.jdbc.Connection;

/**
 *
 * @author 
 */
public class DAOFactory {
    public static Connection conn;
  
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
    return new ClassDAO(conn);
  }
  
  public static DAO getAcademicYearDAO(){
    return new AcademicYearDAO(conn);
  }

  
}
