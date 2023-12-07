package TP;

public class Filiére {
    private String intitule;
    private Enseignant responsable;
    private Département departement;
    Filiére(){}
    Filiére(String intitule,Enseignant responsable,Département departement){
        this.intitule = intitule;
        this.responsable = responsable;
        this.departement = departement;
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

    public Département getDepartement() {
        return departement;
    }

    public void setDepartement(Département departement) {
        this.departement = departement;
    }

    @Override
    public String toString() {
        return "la filiere a un intitule"+intitule+"et un responsable"+responsable+"et un departement"+departement;
    }
}
