package TP.Services;

import TP.models.Enseignant;
import TP.models.Filiere;
import TP.models.Module;

import java.util.ArrayList;

public class ModuleServices {
    public static Module addFiliere(String intitule, Enseignant chef, Filiere filiere) {
        return  new Module();
    }

    public static Module updateFiliere(int id , String intitule, Enseignant chef,  Filiere filiere){
        return  new Module();
    }
    public static ArrayList<Module> deleteModuleById(int id){
        return  DataBase.modules;
    }

    public static Module getModuleById(int id){
        return  new Module();
    }

    public static ArrayList<Module> getAllModule(){
        return  DataBase.modules;
    }


}
