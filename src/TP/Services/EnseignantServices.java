package TP.Services;

import TP.models.Departement;
import TP.models.Enseignant;

import java.util.ArrayList;

public class EnseignantServices {
    public static Enseignant addEns(String nom, String prenom, String email, String grade, Departement dep){
        return  new Enseignant();
    }

    public static Enseignant updateEns(int id, String nom, String prenom, String email, String grade, Departement dep){
        return  new Enseignant();
    }
    public static ArrayList<Enseignant> deleteEnsById(int id){
        return  DataBase.enseignants;
    }

    public static Enseignant getEnsById(int id){
        for (Enseignant enseignant : DataBase.enseignants) {
            if (enseignant.getId() == id) return  enseignant;
        }
        return  new Enseignant();
    }

    public static ArrayList<Enseignant> getAllEns(){
        return  DataBase.enseignants;
    }
}
