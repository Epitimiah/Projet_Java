package Modele;

import Modele.ReportCard;
import DAO.*;

/**
 *
 * @author lelel
 */
public class Student {
    private int id = 0;
    private String LastName = "";
    private String FirstName = "";
    private int idClass = 0;
    
    public Student(int id, String LastName, String FirstName, int idClass){
        this.id = id;
        this.LastName = LastName;
        this.FirstName = FirstName;
        this.idClass = idClass;
    }
    
    public Student(){}
    
    
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
    
    public int getIdClass(){
        return idClass;
    }
    public void setIdClass(int idClass){
        this.idClass = idClass;
    }
    
    @Override
    public String toString() {
        return "" + this.FirstName + " " + this.LastName;
    }
}
