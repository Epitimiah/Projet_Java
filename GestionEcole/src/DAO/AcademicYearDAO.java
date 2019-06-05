package DAO;

import com.mysql.jdbc.Connection;
import Modele.AcademicYear;
import Modele.Level;
import java.util.ArrayList;

/**
 *
 * @author lelel
 */
public class AcademicYearDAO extends DAO<AcademicYear>{
    public AcademicYearDAO(Connection conn){
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
    
    public ArrayList<AcademicYear> getAll() {
        ArrayList<AcademicYear> res = new ArrayList<>();
        res.add(new AcademicYear(0));
        return res;
    }
}
