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
public class Ecole {
    private int Id_ecole;
    private String nom_ecole; 
    
        
    public Ecole(){
        Id_ecole=0;
        nom_ecole="";
    }
    
    public Ecole(int Id_ecole, String nom_ecole){
        this.Id_ecole = Id_ecole;
        this.nom_ecole= nom_ecole; 
    }

    public int getId_ecole() {
        return Id_ecole;
    }
 
    public String getnom_ecole(){
        return nom_ecole;
    }
    
    public void setId_ecole(int ident){
        Id_ecole=ident;
    }
    
    public void setnom_ecole(String name){
        nom_ecole=name;
    }
    
}
