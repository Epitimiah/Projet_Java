package Modele;

/**
 *
 * @author lelel
 */
public class ReportCardDetail {
    private int id = 0;
    private int idReportCard = 0;
    private int idCourse = 0;
    private String comment = "";
    
    public ReportCardDetail(int id, int idReportCard, int idCourse, String comment){
        this.id = id;
        this.idReportCard = idReportCard;
        this.idCourse = idCourse;
        this.comment = comment;
    }
    
    public ReportCardDetail(){}
    
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    
    public int getIdRC(){
        return idReportCard;
    }
    public void setIdRC(int idRC){
        this.idReportCard = idRC;
    }
    
    public int getIdCourse(){
        return idCourse;
    }
    public void setIdCourse(int idCourse){
        this.idCourse = idCourse;
    }
    
    public String getComment(){
        return comment;
    }
    public void setComment(String comment){
        this.comment = comment;
    }
    
    @Override
    public String toString() {
        return "" + this.comment;
    }
}
