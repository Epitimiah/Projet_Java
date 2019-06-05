package DAO;

import Modele.Classe;
import com.mysql.jdbc.Connection;
import Main.Connexion;
import java.util.ArrayList;

/**
 *
 * @author lelel
 */
public class ClasseDAO extends DAO<Classe>{
    public ClasseDAO(Connexion conn){
        super(conn);
    }

    @Override
    public void create(Classe obj) {
         
    }

    @Override
    public void delete(Classe obj) {
        
    }

    @Override
    public void update(Classe obj) {
        
    }

    @Override
    public Classe find(int id) {
        Classe c = new Classe();
        return c;
    }

    public ArrayList<Classe> getAll() {
        ArrayList<Classe> res = new ArrayList<>();
        res.add(new Classe(0, "3eme", 1, 1));
        return res;
    }

   
}
