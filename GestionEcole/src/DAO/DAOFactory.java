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

  
}
