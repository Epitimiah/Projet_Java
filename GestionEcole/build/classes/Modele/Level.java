package Modele;

/**
 * Classe pour acceder a la table "level" dans la base de donnees
 * @author Adrien  Lea  Levanah
 */
public class Level {
    private int id = 0;
    private String name = "";
    
    public Level(int id, String name){
        this.id = id;
        this.name = name;
    }
    
    public Level(){}
    
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
