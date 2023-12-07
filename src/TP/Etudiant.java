package TP;

public class Etudiant {
    private String nom,prenom,email;
    private int apogee;
    private Filiére filiere;
    Etudiant(){}
    Etudiant(String nom, String prenom, String email, int apogee, Filiére filiere){
        this.apogee = apogee;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.filiere = filiere;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getApogee() {
        return apogee;
    }

    public void setApogee(int apogee) {
        this.apogee = apogee;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Filiére getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiére filiere) {
        this.filiere = filiere;
    }

    @Override
    public String toString() {
        return "l'etudiant a un nom"+nom+"et un prenom"+prenom+",un email"+email+",un code apogee"+apogee+"et une filiere"+filiere;
    }
}
