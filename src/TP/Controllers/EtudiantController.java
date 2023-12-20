package TP.Controllers;

import TP.Main;
import TP.Services.DataBase;
import TP.Services.DepartementService;
import TP.Services.EnseignantServices;
import TP.models.Enseignant;

public class EtudiantController {
    public static void showMenu(){
        System.out.println("----------[ Etudiant ]----------");


        System.out.println("1: Pour ajouter un etudiant");
        System.out.println("2: Pour afficher les etudiants");
        System.out.println("3: Pour modifier un etudiant");
        System.out.println("4: Pour supprimer un etudiant");
        System.out.println("0: Pour retourner au menu principal");
        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                createEtudiant();
                break;
            case 2:
                showEtudiant();
                break;
            case 3:
                editEtudiant();
                break;
            case 4:
                destroyEtudiant();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }

    public static void destroyEtudiant() {
    }

    public static void editEtudiant() {

    }

    public static void showEtudiant() {
        for (Enseignant enseignant : DataBase.enseignants) {
            System.out.print("Id : " + enseignant.getId());
            System.out.print(" | Nom : " + enseignant.getNom() + " " + enseignant.getPrenom());
            System.out.print(" | Email : " + enseignant.getEmail() );

            System.out.println("");
        }
    }

    public static void createEtudiant() {
    }


}
