package DAO;

import Modele.ReportCardDetail;
import com.mysql.jdbc.Connection;

/**
 *
 * @author lelel
 */
public class ReportCardDetailDAO extends DAO<ReportCardDetail>{
    public ReportCardDetailDAO(Connection conn){
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
}
