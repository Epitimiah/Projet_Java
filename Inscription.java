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
public class Inscription {
    private int Id;
    private int classe_id;
    private int personne_id;
    

    public Inscription(){
        
    }
    
    public Inscription(Classe classe, Personne pers){
        classe_id=classe.getId();
        personne_id=pers.getId();
        Id=0;
    }

    public Inscription(int Id, int classe_id, int personne_id) {
        this.Id = Id;
        this.classe_id = classe_id;
        this.personne_id = personne_id;
    }
   
    public int getId(){
        return Id;
    }
    
    public void setId(int ident){
        Id=ident;
    }

}
