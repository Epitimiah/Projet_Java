package Modele;

/**
 * Classe pour acceder a la table "grade" dans la base de donnees
 * @author Adrien  Lea  Levanah
 */
public class Grade {
    private int id = 0;
    private float grade = 0;
    private String gradeComment = "";
    private int idReportCardDetail = 0;
    
    public Grade(int id, float grade, String gradeComment, int idRCDetail){
        this.id = id;
        this.grade = grade;
        this.gradeComment = gradeComment;
        this.idReportCardDetail = idRCDetail;
    }
    public Grade(){}
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    
    public float getGrade(){
        return grade;
    }
    public void setGrade(float grade){
        this.grade = grade;
    }
    
    public String getGradeCom(){
        return gradeComment;
    }
    public void setGradeCom(String gradeCom){
        this.gradeComment = gradeCom;
    }
    
    public int getIdRCDetail(){
        return idReportCardDetail;
    }
    public void setIdRCDetail(int idRCDetail){
        this.idReportCardDetail = idRCDetail;
    }
    
    @Override
    public String toString() {
        return "" + this.grade + " " + this.gradeComment;
    }
}
