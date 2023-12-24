package TP.models;

import java.util.ArrayList;

public class Enseignant {
    public int length;
    private int id;
    private String nom,prenom;

    private String email,grade;
    private Departement dep;
    ArrayList<Module> modules = new ArrayList<Module>();


    public Enseignant() {
    }

    public Enseignant(int id, String nom, String prenom, String email, String grade, Departement dep) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.grade = grade;
        this.dep = dep;
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

    public Departement getDep() {
        return dep;
    }

    public void setDep(Departement dep) {
        this.dep = dep;
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public void setModules(ArrayList<Module> modules) {
        this.modules = modules;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public boolean equals(Enseignant obj) {
        if (obj == null) {
            return false;
        }


        if (obj.getId() != this.id) {
            return false;
        }

        return true;
    }
}
