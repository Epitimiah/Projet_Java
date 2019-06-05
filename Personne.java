/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author Levanah
 */
public class Personne {
    private int Id;
    private String nom;
    private String prenom;
    private boolean type; 
    
        
    public Personne(){
        Id=0;
        nom="";
        prenom="";
    }

    public Personne(int Id, String nom, String prenom, boolean type) {
        this.Id = Id;
        this.nom = nom;
        this.prenom = prenom;
        this.type = type;
    }
    
    public int getId(){
        return Id;
    }
    
    public String getnom(){
        return nom;
    }
    
    public String getprenom(){
        return prenom;
    }
    
    public boolean gettype(){
        return type;
    }
    
    public void setId(int ident){
        Id=ident;
    }
    
    public void setnom(String name){
        nom=name;
    }
    public void setprenom(String pren){
        prenom=pren;
    }
    
}
