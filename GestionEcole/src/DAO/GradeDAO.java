package DAO;

import Modele.Grade;
import com.mysql.jdbc.Connection;
import Controller.Connexion;

/**
 *
 * @author lelel
 */
public class GradeDAO extends DAO<Grade>{
    public GradeDAO(Connexion conn){
        super(conn);
    }

    @Override
    public void create(Grade obj) {
         
    }

    @Override
    public void delete(Grade obj) {
        
    }

    @Override
    public void update(Grade obj) {
        
    }

    @Override
    public Grade find(int id) {
        Grade g = new Grade();
        return g;
    }
}
