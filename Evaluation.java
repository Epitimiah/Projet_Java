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
public class Evaluation {
    private int Id;
    private int note;
    private String appreciation; 
    private int detail_bulletin_id;
   
    public Evaluation(){
    }
        
    public Evaluation(DetailBulletin DetBul){
        detail_bulletin_id=DetBul.getId();
        Id=0;
        note=0;
        appreciation="";
    }

    public Evaluation(int Id, int note, String appreciation, int detail_bulletin_id) {
        this.Id = Id;
        this.note = note;
        this.appreciation = appreciation;
        this.detail_bulletin_id = detail_bulletin_id;
    }
  
    public int getId(){
        return Id;
    }
    
    public int getnote(){
        return note;
    }
    
    public String getappreciation(){
        return appreciation; 
    }
    
    public void setId(int ident){
        Id=ident;
    }
    
    public void setnote(int not){
        note=not;
    }
    
    public void setappreciation(String apprec){
    appreciation=apprec;
    }
}
