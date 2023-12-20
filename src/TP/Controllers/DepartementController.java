package TP.Controllers;

import TP.Main;
import TP.Services.DepartementService;
import TP.Services.DataBase;
import TP.Services.EnseignantServices;
import TP.models.Departement;

public class DepartementController {
    public static void showMenu(){
        System.out.println("-------------------------[ Départements ]---------------------------");


        System.out.println("1: Pour ajouter un département");
        System.out.println("2: Pour afficher les départements");
        System.out.println("3: Pour modifier un département");
        System.out.println("4: Pour supprimer un département");
        System.out.println("0: Pour retourner au menu principal");

        //"Veuillez sélectionner une option : ")
        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                createDepartement();
                break;
            case 2:
                showDepartements();
                break;
            case 3:
                editDepartement();
                break;
            case 4:
                destroyDepartement();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }
    public static void showDepartements(){
        for (Departement departement : DataBase.departements) {
            System.out.print("Id : " + departement.getIntitule());
            System.out.print(" | Intitulé : " + departement.getIntitule());
            if (! Main.isNull(departement.getChefdept())) {
                System.out.print(" | Chef : " + departement.getChefdept().getNom() + " " + departement.getChefdept().getPrenom());
            }
            System.out.println("");
        }

    }
    public static void createDepartement(){
        String intitule = Main.getStringInput("Entrez l'intitulé :");
        EnseignantController.showEnseignants();
        int id = Main.getIntInput("Sélecionnez un enseignant par id :");
        DepartementService.addDept(intitule, EnseignantServices.getEnsById(id));

        showDepartements();
        showMenu();


    }
    public static void editDepartement(){
        showDepartements();
        int id = Main.getIntInput("Sélecionnez un departement par id :");
        String intitule = Main.getStringInput("Entrez l'intitulé :");
        EnseignantController.showEnseignants();
        int idEns = Main.getIntInput("Sélecionnez un enseignant par id :");

        DepartementService.updateDept(id, intitule, EnseignantServices.getEnsById(idEns));

        showDepartements();
        showMenu();
    }
    public static void destroyDepartement(){
        showDepartements();
        int id = Main.getIntInput("Sélecionnez un departement par id :");
        DepartementService.deleteDeptById(id);
        showDepartements();

    }
}
