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
public class Discipline {
    private int Id;
    private String nom; 
        
    public Discipline(){
        Id=0;
        nom="";
    }
    
    public Discipline(int Id, String nom){
        this.Id = Id;
        this.nom= nom;  
    }
    
    public int getId(){
        return Id;
    } 
    
    public String getnom(){
        return nom;
    }
    
    public void setId(int ident){
        Id=ident;
    }
    
    public void setnom(String name){
        nom=name;
    }
    
    
}
