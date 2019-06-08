package DAO;

import java.sql.Connection;
import Controller.Connexion;
import java.util.*;

/**
 *
 * @author 
 */
public abstract class DAO<T> {
    protected Connexion connect = null;
    
    public DAO(Connexion conn){
        this.connect = conn;
    }
    
    public abstract void create(T obj);
    public abstract void delete(T obj);
    public abstract void update(T obj);
    
    public abstract T find(int id);
    
    public abstract ArrayList<T> getAll();
}
