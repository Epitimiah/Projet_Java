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
public class DetailBulletin {
    private int Id;
    private String appreciation; 
    private int bulletin_id;
    private int enseignement_id;
        
    public DetailBulletin(){
    }
    
    public DetailBulletin(Bulletin bul, Enseignement enseig){
        bulletin_id=bul.getId();
        enseignement_id=enseig.getId();
        Id=0;
        appreciation="";
    }

    public DetailBulletin(int Id, String appreciation, int bulletin_id, int enseignement_id) {
        this.Id = Id;
        this.appreciation = appreciation;
        this.bulletin_id = bulletin_id;
        this.enseignement_id = enseignement_id;
    }
     
    public int getId(){
        return Id;
    }
    
    public String getappreciation(){
        return appreciation;
    }
    
    public void setId(int ident){
        Id=ident;
    }
    
    public void setappreciation(String apprec){
        appreciation=apprec;
    }
    
}
