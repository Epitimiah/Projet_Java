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
public class Bulletin {
    private int Id;
    private String appreciation; 
    private int trimestre_id; 
    private int inscription_id;
        
    public Bulletin(){
        
    }
    
    public Bulletin(Trimestre trim, Inscription inscrip){
        trimestre_id=trim.getId();
        inscription_id=inscrip.getId();
        Id=0;
        appreciation="";
    }

    public Bulletin(int Id, String appreciation, int trimestre_id, int inscription_id) {
        this.Id = Id;
        this.appreciation = appreciation;
        this.trimestre_id = trimestre_id;
        this.inscription_id = inscription_id;
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
