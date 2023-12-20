package TP.Services;

import TP.models.Etudiant;
import TP.models.Filiere;

import java.util.ArrayList;

public class EtudiantServices {
    public static Etudiant addEtd(String nom, String prenom, String email, int apogee, Filiere filiere){
        return  new Etudiant();
    }

    public static Etudiant updateEtd(int id,String nom, String prenom, String email, int apogee, Filiere filiere){
        return  new Etudiant();
    }
    public static ArrayList<Etudiant> deleteEtdById(int id){
        return  DataBase.etudiants;
    }

    public static Etudiant getEtdById(int id){
        return  new Etudiant();
    }

    public static ArrayList<Etudiant> getAllEtd(){
        return  DataBase.etudiants;
    }
}
