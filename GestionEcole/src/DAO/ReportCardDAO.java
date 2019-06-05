package DAO;

import Modele.ReportCard;
import com.mysql.jdbc.Connection;
import java.util.ArrayList;
import Main.Connexion;

/**
 *
 * @author lelel
 */
public class ReportCardDAO extends DAO<ReportCard> {
    public ReportCardDAO(Connexion conn){
        super(conn);
    }

    @Override
    public void create(ReportCard obj) {
         
    }

    @Override
    public void delete(ReportCard obj) {
        
    }

    @Override
    public void update(ReportCard obj) {
        
    }

    @Override
    public ReportCard find(int id) {
        ReportCard rc = new ReportCard();
        return rc;
    }

    public ArrayList<ReportCard> getAll() {
        ArrayList<ReportCard> res = new ArrayList<>();
        res.add(new ReportCard(1, 2, 3, "patate"));
        return res;
    }
}
