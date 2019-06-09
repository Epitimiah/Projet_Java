package Modele;

/**
 * Classe pour acceder a la table "field" dans la base de donnees
 * @author Adrien  Lea  Levanah
 */
public class Field {
    private int id = 0;
    private String name = "";
    
    public Field(int id, String name){
        this.id = id;
        this.name = name;
    }
    public Field(){}
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "" + this.name;
    }
}
