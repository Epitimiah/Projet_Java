package Modele;

/**
 *
 * @author lelel
 */
public class Term {
    private int id = 0;
    private int number = 0;
    private String start = "";
    private String end = "";
    private int idAcademicYear = 0;
    
    public Term(int id, int number, String start, String end, int idAcademicYear){
        this.id = id;
        this.number = number;
        this.start = start;
        this.end = end;
        this.idAcademicYear = idAcademicYear;
    }
    
    public Term(){}
    
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    
    public int getNumber(){
        return number;
    }
    public void setNumber(int number){
        this.number = number;
    }
    
    public String getStart(){
        return start;
    }
    public void setStart(String start){
        this.start = start;
    }
    
    public String getEnd(){
        return end;
    }
    public void setEnd(String end){
        this.end = end;
    }
    
    public int getIdAcademicYear(){
        return idAcademicYear;
    }
    public void setIdAcamdemicYear(int idAcademicYear){
        this.idAcademicYear = idAcademicYear;
    }
    
    @Override
    public String toString() {
        return "" + this.number + " " + this.start + "  -  " + this.end;
    }
}
