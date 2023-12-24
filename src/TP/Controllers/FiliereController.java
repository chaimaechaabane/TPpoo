package TP.Controllers;

import TP.Main;
import TP.Services.*;
import TP.models.Etudiant;
import TP.models.Filiere;

public class FiliereController {
    public static void showMenu(){
        System.out.println("----------[ Filiere ]----------");


        System.out.println("1: Pour ajouter une filiere");
        System.out.println("2: Pour afficher les filieres");
        System.out.println("3: Pour modifier une filiere");
        System.out.println("4: Pour supprimer une filiere");
        System.out.println("0: Pour retourner au menu principal");
        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                createFiliere();
                break;
            case 2:
                showFiliere();
                break;
            case 3:
                editFiliere();
                break;
            case 4:
                destroyFiliere();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }

    public static void createFiliere() {
        String intitule = Main.getStringInput("Entrez l'intitule de la filiere :");
        FiliereController.showFiliere();
        int id = Main.getIntInput("Sélecionnez le departement et l'enseignant par id :");
        FiliereServices.addFiliere(intitule, EnseignantServices.getEnsById(id),DepartementService.getDeptById(id));

        showFiliere();
        showMenu();
    }



    public static void showFiliere() {
        for (Filiere filiere : DataBase.filieres) {
            System.out.print("Intitule : " + filiere.getIntitule());
            System.out.print(" | Departement : " + filiere.getDept());
            System.out.print(" | Enseignant : " + filiere.getChef() );
            System.out.println("");
        }
    }

    public static void editFiliere() {
        showFiliere();
        int id = Main.getIntInput("Sélecionnez une filiere par id :");
        String intitule = Main.getStringInput("Entrez l'intitule de la filiere :");

        FiliereController.showFiliere();
        int idDept= Main.getIntInput("Sélecionnez une departement par id :");
        int idEns= Main.getIntInput("Sélecionnez un enseignant par id :");

        FiliereServices.updateFiliere(id, intitule,EnseignantServices.getEnsById(idEns),DepartementService.getDeptById(idDept));

        showFiliere();
        showMenu();
    }

    public static void destroyFiliere() {
        showFiliere();
        int id = Main.getIntInput("Sélecionnez une filiere par id :");
       FiliereServices.deleteFiliereById(id);
        showFiliere();
    }
    }

