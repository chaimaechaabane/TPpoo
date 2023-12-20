package TP.models;

import java.util.ArrayList;

public class Departement {
    private int id;
    private String intitule;
    private Enseignant chefdept;
    ArrayList<Filiere> filieres = new ArrayList<Filiere>();
    public Departement(){}
    public Departement(String intitule, Enseignant chefdept){
        this.intitule = intitule;
        this.chefdept = chefdept;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Enseignant getChefdept() {
        return chefdept;
    }

    public void setChefdept(Enseignant chefdept) {
        this.chefdept = chefdept;
    }

    public ArrayList<Filiere> getFilieres() {
        return filieres;
    }

    public void setFilieres(ArrayList<Filiere> filieres) {
        this.filieres = filieres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
