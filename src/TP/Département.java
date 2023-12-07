package TP;

public class Département {
   private String intitule;
   private Enseignant responsable;
   Département(){}
    Département( String intitule, Enseignant responsable){
       this.intitule = intitule;
       this.responsable = responsable;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Enseignant getResponsable() {
        return responsable;
    }

    public void setResponsable(Enseignant responsable) {
        this.responsable = responsable;
    }

    @Override
    public String toString() {
        return "le département est d'intitulé"+intitule+", est de responsable"+responsable;
    }
}
