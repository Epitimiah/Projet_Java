package DAO;

import java.sql.Connection;

/**
 *
 * @author 
 */
public abstract class DAO<T> {
    protected Connection connect = null;
    
    public DAO(Connection conn){
        this.connect = conn;
    }
    
    public abstract void create(T obj);
    public abstract void delete(T obj);
    public abstract void update(T obj);
    
    public abstract T find(int id);
}
