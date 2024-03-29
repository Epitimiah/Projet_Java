package Modele;

/**
 * Classe pour acceder a la table "reportcard" dans la base de donnees
 * @author Adrien  Lea  Levanah
 */
public class ReportCard {
    private int id = 0;
    private int idTerm = 0;
    private int idStudent = 0;
    private String generalComment = "";
    
    public ReportCard(int id, String generalComment,int idTerm, int idStudent){
        this.id = id;
        this.idTerm = idTerm;
        this.idStudent = idStudent;
        this.generalComment = generalComment;
    }
    
    public ReportCard(){}
    
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    
    public int getIdTerm(){
        return idTerm;
    }
    public void setIdTerm(int idTerm){
        this.idTerm = idTerm;
    }
    
    public int getIdStudent(){
        return idStudent;
    }
    public void setIdStudent(int idStudent){
        this.idStudent = idStudent;
    }
    
    public String getGeneCom(){
        return generalComment;
    }
    public void setGeneCom(String geneCom){
        this.generalComment = geneCom;
    }
    
    @Override
    public String toString() {
        return "" + this.generalComment;
    }
}
