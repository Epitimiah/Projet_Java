package Modele;

/**
 * Classe pour acceder a la table "academicyear" dans la base de donnees
 * @author Adrien  Lea  Levanah
 */
public class AcademicYear {
    private int id = 0;
    
    public AcademicYear(int id){
        this.id = id;
    }
    public AcademicYear(){}
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "" + this.id;
    }
}
