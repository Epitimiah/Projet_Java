package DAO;

import Modele.AcademicYear;
import Modele.ReportCardDetail;
import com.mysql.jdbc.Connection;
import java.util.ArrayList;
import Controller.Connexion;

/**
 *
 * @author lelel
 */
public class ReportCardDetailDAO extends DAO<ReportCardDetail>{
    public ReportCardDetailDAO(Connexion conn){
        super(conn);
    }

    @Override
    public void create(ReportCardDetail obj) {
         
    }

    @Override
    public void delete(ReportCardDetail obj) {
        
    }

    @Override
    public void update(ReportCardDetail obj) {
        
    }

    @Override
    public ReportCardDetail find(int id) {
        ReportCardDetail rcd = new ReportCardDetail();
        return rcd;
    }
    
    public ArrayList<ReportCardDetail> getAll() {
        ArrayList<ReportCardDetail> res = new ArrayList<>();
        res.add(new ReportCardDetail(0, 0, 0, "Am potat"));
        return res;
    }
}
