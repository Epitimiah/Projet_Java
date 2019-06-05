/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author levanah
 */
public class Trimestre {
    private int Id;
    private int numero;
    private String debut; 
    private String fin;
    private int annee_scolaire_id;
    
        
    public Trimestre(){
        
    }
    
    public Trimestre(AnneeScolaire annee){
        annee_scolaire_id=annee.getId();
        Id=0;
        numero=0;
        debut="";
        fin="";
    }

    public Trimestre(int Id, int numero, String debut, String fin, int annee_scolaire_id) {
        this.Id = Id;
        this.numero = numero;
        this.debut = debut;
        this.fin = fin;
        this.annee_scolaire_id = annee_scolaire_id;
    }
    
    public int getId(){
        return Id;
    }
    
    public int getnumero(){
        return numero;
    }
    
    public String getdebut(){
    return debut;
    }
    
    public String getfin(){
        return fin;
    }
    
}
