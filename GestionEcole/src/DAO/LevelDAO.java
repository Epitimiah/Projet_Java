package DAO;

import Modele.Level;
import com.mysql.jdbc.Connection;
import Main.Connexion;

/**
 *
 * @author lelel
 */
public class LevelDAO extends DAO<Level>{
    public LevelDAO(Connexion conn){
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
