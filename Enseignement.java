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
public class Enseignement {
    private int Id;
    private int classe_id;
    private int discipline_id; 
    private int personne_id;
    
        
    public Enseignement(){
        
    }
    
    public Enseignement(Classe classe, Discipline disc, Personne pers){
        classe_id=classe.getId();
        discipline_id=disc.getId();
        personne_id=pers.getId();
        Id=0;
    }

    public Enseignement(int Id, int classe_id, int discipline_id, int personne_id) {
        this.Id = Id;
        this.classe_id = classe_id;
        this.discipline_id = discipline_id;
        this.personne_id = personne_id;
    }
          
    public int getId(){
        return Id;
    }
    
    public void setId(int ident){
        Id=ident;
    }
    
}
