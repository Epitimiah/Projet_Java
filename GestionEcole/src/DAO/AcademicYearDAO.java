package DAO;

import com.mysql.jdbc.Connection;
import Modele.AcademicYear;
import Main.Connexion;

/**
 *
 * @author lelel
 */
public class AcademicYearDAO extends DAO<AcademicYear>{
    public AcademicYearDAO(Connexion conn){
        super(conn);
    }

    @Override
    public void create(AcademicYear obj) {
         
    }

    @Override
    public void delete(AcademicYear obj) {
        
    }

    @Override
    public void update(AcademicYear obj) {
        
    }

    @Override
    public AcademicYear find(int id) {
        AcademicYear ay = new AcademicYear();
        return ay;
    }
}
