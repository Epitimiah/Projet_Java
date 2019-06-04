package DAO;

import Modele.Level;
import com.mysql.jdbc.Connection;

/**
 *
 * @author lelel
 */
public class LevelDAO extends DAO<Level>{
    public LevelDAO(Connection conn){
        super(conn);
    }

    @Override
    public void create(Level obj) {
         
    }

    @Override
    public void delete(Level obj) {
        
    }

    @Override
    public void update(Level obj) {
        
    }

    @Override
    public Level find(int id) {
        Level lvl = new Level();
        return lvl;
    }
}
