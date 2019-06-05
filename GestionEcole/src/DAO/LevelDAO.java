package DAO;

import Modele.Level;
import com.mysql.jdbc.Connection;
import java.util.ArrayList;
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
    
    public ArrayList<Level> getAll() {
        ArrayList<Level> res = new ArrayList<>();
        res.add(new Level(0, "3eme"));
        return res;
    }
}
