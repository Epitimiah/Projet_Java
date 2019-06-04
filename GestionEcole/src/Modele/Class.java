package Modele;

/**
 *
 * @author lelel
 */
public class Class {
    private int id = 0;
    private String name = "";
    private int idLevel = 0;
    private int idAcademicYear = 0;
    
    public Class(int id, String name, int idLevel, int idAcademicYear){
        this.id = id;
        this.name = name;
        this.idLevel = idLevel;
        this.idAcademicYear = idAcademicYear;
    }
    public Class(){}
    
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
    
    public int getIdLevel(){
        return idLevel;
    }
    public void setIdLevel(int idLevel){
        this.idLevel = idLevel;
    }
    
    public int getIdAcademicYear(){
        return idAcademicYear;
    }
    public void setIdAcademicYear(int idAcademicYear){
        this.idAcademicYear = idAcademicYear;
    }
}
