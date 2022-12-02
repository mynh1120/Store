package learn.demo.appquanlysinhvien.model;

/**
 *
 * @author Ngô Duy Minh
 */
public class Mark {
    private String ID, Fullname;
    private float English, PE, Informatics;

    public Mark() {
    }

    public Mark(String ID, String Fullname, float English, float PE, float Informatics) {
        this.ID = ID;
        this.Fullname = Fullname;
        this.English = English;
        this.PE = PE;
        this.Informatics = Informatics;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String Fullname) {
        this.Fullname = Fullname;
    }

    public float getEnglish() {
        return English;
    }

    public void setEnglish(float English) {
        this.English = English;
    }

    public float getPE() {
        return PE;
    }

    public void setPE(float PE) {
        this.PE = PE;
    }

    public float getInformatics() {
        return Informatics;
    }

    public void setInformatics(float Informatics) {
        this.Informatics = Informatics;
    }
    
}
