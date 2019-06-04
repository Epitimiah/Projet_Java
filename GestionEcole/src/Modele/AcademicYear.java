package Modele;

/**
 *
 * @author lelel
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
}
