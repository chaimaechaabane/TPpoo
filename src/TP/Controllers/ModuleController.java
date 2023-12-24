package TP.Controllers;

import TP.Main;
import TP.Services.*;
import TP.models.Filiere;
import TP.models.Module;

public class ModuleController {
    public static void showMenu(){
        System.out.println("----------[ Module ]----------");


        System.out.println("1: Pour ajouter un Module");
        System.out.println("2: Pour afficher les Modules");
        System.out.println("3: Pour modifier un Module");
        System.out.println("4: Pour supprimer un Module");
        System.out.println("0: Pour retourner au menu principal");
        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                createModule();
                break;
            case 2:
                showModule();
                break;
            case 3:
                editModule();
                break;
            case 4:
                destroyModule();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }

    public static void createModule() {
        String intitule = Main.getStringInput("Entrez l'intitule du Module :");
        ModuleController.showModule();
        int id = Main.getIntInput("Sélecionnez la filiere et l'enseignant par id :");
        ModuleServices.addFiliere(intitule,EnseignantServices.getEnsById(id),FiliereServices.getFiliereById(id));

        showModule();
        showMenu();
    }



    public static void showModule() {
        for (Module module : DataBase.modules) {
            System.out.print("Intitule : " + module.getIntitule());
            System.out.print(" | Filiere : " + module.getFiliere());
            System.out.print(" | Enseignant : " + module.getChef() );
            System.out.println("");
        }
    }

    public static void editModule() {
        showModule();
        int id = Main.getIntInput("Sélecionnez le module par id :");
        String intitule = Main.getStringInput("Entrez l'intitule du module :");

        ModuleController.showModule();
        int idFil= Main.getIntInput("Sélecionnez la filiere par id :");
        int idEns= Main.getIntInput("Sélecionnez un enseignant par id :");
        ModuleServices.updateFiliere(id, intitule,EnseignantServices.getEnsById(idEns),FiliereServices.getFiliereById(idFil));

        showModule();
        showMenu();
    }

    public static void destroyModule() {
        showModule();
        int id = Main.getIntInput("Sélecionnez uu module par id :");
        ModuleServices.deleteModuleById(id);
        showModule();
    }
}

