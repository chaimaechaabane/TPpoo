package TP.Services;

import TP.models.Departement;
import TP.models.Enseignant;
import TP.models.Filiere;

import java.util.ArrayList;

public class FiliereServices {
    public static Filiere addFiliere(String intitule, Enseignant chef, Departement dept) {
        return  new Filiere();
    }

    public static Filiere updateFiliere(int id , String intitule, Enseignant chef, Departement dept){
        return  new Filiere();
    }
    public static ArrayList<Filiere> deleteFiliereById(int id){
        return  DataBase.filieres;
    }

    public static Filiere getFiliereById(int id){
        return  new Filiere();
    }

    public static ArrayList<Filiere> getAllFiliere(){
        return  DataBase.filieres;
    }
}
