package Modele;

/**
 *
 * @author lelel
 */
public class Course {
    private int id = 0;
    private int idTeacher = 0;
    private int idField = 0;
    private int idClass = 0;
    
    public Course(int id, int idTeacher, int idField, int idClass){
        this.id = id;
        this.idTeacher = idTeacher;
        this.idField = idField;
        this.idClass = idClass;
    }
    public Course(){}
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    
    public int getIdTeacher(){
        return idTeacher;
    }
    public void setIdTeacher(int idTeacher){
        this.idTeacher = idTeacher;
    }
    
    public int getIdField(){
        return idField;
    }
    public void setIdField(int idField){
        this.idField = idField;
    }
    
    public int getIdClass(){
        return idClass;
    }
    public void setIdClass(int idClass){
        this.idClass = idClass;
    }
    
    @Override
    public String toString() {
        return "" + this.id;
    }
}
