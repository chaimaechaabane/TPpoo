package TP;

public class Enseignant {
    private String nom,prenom;
    private String email,grade;
    private Département departement;
    Enseignant(){}
    Enseignant(String nom,String prenom,String email, String grade,Département departement){
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.grade = grade;
        this.departement = departement;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Département getDepartement() {
        return departement;
    }

    public void setDepartement(Département departement) {
        this.departement = departement;
    }

    @Override
    public String toString() {
        return "l'enseignant de nom"+nom+"et prenom"+prenom+", email"+email+", une grade"+grade+"et de departement"+departement;
    }
}
