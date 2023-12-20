package TP.Services;

import TP.models.Departement;
import TP.models.Enseignant;

import java.util.ArrayList;

public class DepartementService {
    public static Departement addDept(String intitule, Enseignant... chefdept){
        Departement departement = new Departement();
        departement.setIntitule(intitule);
        departement.setId(DataBase.getDeptId());
        if (chefdept.length > 0) {
            departement.setChefdept(chefdept[0]);
        }
        DataBase.departements.add(departement);

        return  departement;
    }

    public static Departement updateDept(int id , String intitule, Enseignant... chefdept){
        for (Departement departement : DataBase.departements) {
            if (departement.getId() == id) {
                departement.setIntitule(intitule);
                if (chefdept.length > 0){
                    departement.setChefdept(chefdept[0]);
                }
                return departement;
            }
        }

        return  new Departement(); //???
    }
    public static ArrayList<Departement> deleteDeptById(int id){
        DataBase.departements.remove(getDeptById(id));
        return DataBase.departements ;
    }

    public static Departement getDeptById(int id){
        for (Departement departement : DataBase.departements) {
            if (departement.getId() == id) return  departement;
        }
        return  new Departement();//la nouvelle dept
    }

    public static ArrayList<Departement> getAllDept(){

        return  DataBase.departements;
    }
}
