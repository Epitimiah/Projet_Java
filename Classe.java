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
public class Classe {
    private int Id;
    private String nom;
    private int annee_scolaire_id;
    private int ecole_id;
    private int niveau_id;

        
    public Classe(){
        
    }
    
    public Classe(AnneeScolaire annee, Ecole ecole, Niveau niv){
        
        annee_scolaire_id=annee.getId();
        ecole_id=ecole.getId_ecole();
        niveau_id=niv.getId();
        Id=0;
        nom="";
        
    }

    public Classe(int Id, String nom, int annee_scolaire_id, int ecole_id, int niveau_id) {
        this.Id = Id;
        this.nom = nom;
        this.annee_scolaire_id = annee_scolaire_id;
        this.ecole_id = ecole_id;
        this.niveau_id = niveau_id;
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
