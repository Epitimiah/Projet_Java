package Modele;


/**
 * Classe pour acceder a la table "teacher" dans la base de donnees
 * @author Adrien  Lea  Levanah
 */
public class Teacher {
    private int id = 0;
    private String LastName = "";
    private String FirstName = "";
    
    
    public Teacher(int id, String LastName, String FirstName){
        this.id = id;
        this.LastName = LastName;
        this.FirstName = FirstName;
    }
    
    public Teacher(){}
    
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    
    public String getLastName(){
        return LastName;
    }
    public void setLastName(String LastName){
        this.LastName = LastName;
    }
    
    public String getFirstName(){
        return FirstName;
    }
    public void setFirstName(String FirstName){
        this.FirstName = FirstName;
    }
    
    @Override
    public String toString() {
        return "" + this.FirstName + " " + this.LastName;
    }
}
