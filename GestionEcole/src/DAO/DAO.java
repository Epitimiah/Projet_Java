package DAO;

import java.sql.Connection;
import Controller.Connexion;
import java.util.*;

/**
 * Classe abstrate pour l'utilisation de la methode des DAO
 * @author Adrien & Lea & Levanah
 */
public abstract class DAO<T> {
    protected Connexion connect = null;
    
    /**
     * Permet de faire la connexion à la base de données
     * @param conn 
     */
    public DAO(Connexion conn){
        this.connect = conn;
    }
    
    /**
     * Permet d'ajouter un objet à la base de données
     * @param obj 
     */
    public abstract void create(T obj);
    /**
     * Permet de supprimer un objet de la base de données
     * @param obj 
     */
    public abstract void delete(T obj);
    /**
     * Permet de mettre à jour un objet de la base de données
     * @param obj 
     */
    public abstract void update(T obj);
    
    /**
     * Permet de trouver un objet d'une table de la base de données
     * @param id
     * @return l'objet correspondant a la recherche
     */
    public abstract T find(int id);
    
    /**
     * Permet de recuperer tous les objets d'une table de la base de données
     * @return une arraylist avec tous les objets de la table
     */
    public abstract ArrayList<T> getAll();
}
