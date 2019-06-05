package DAO;

import Modele.Classe;
import com.mysql.jdbc.Connection;
import Main.Connexion;

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

   
}
