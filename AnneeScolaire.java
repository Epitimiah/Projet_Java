/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;
import java.util.*;
/**
 *
 * @author Levanah
 */
public class AnneeScolaire {
    private int Id;
    
    public AnneeScolaire(){
        Id=0;
    }
    
    public AnneeScolaire(int Id){
       this.Id = Id; 
    }
    
    public int getId(){
        return Id;
    }
    
    public void setId(int ident){
        Id=ident;
    }
    
}
