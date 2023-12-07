package TP;

public class Module {
     private String intitule;
     private Filiére filiere;
     private Enseignant professeur;
     Module(){}
    Module(String intitule, Filiére filiere, Enseignant professeur){
         this.intitule = intitule;
         this.filiere = filiere;
         this.professeur = professeur;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Filiére getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiére filiere) {
        this.filiere = filiere;
    }

    public Enseignant getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Enseignant professeur) {
        this.professeur = professeur;
    }

    @Override
    public String toString() {
        return "le module a un intitule"+intitule+ ", une filiere"+filiere+",un prof"+professeur;
     }
}
