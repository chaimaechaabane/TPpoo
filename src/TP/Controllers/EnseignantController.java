package TP.Controllers;


import TP.Main;
import TP.Services.DataBase;

import TP.Services.DepartementService;
import TP.Services.EnseignantServices;
import TP.models.Departement;
import TP.models.Enseignant;

public class EnseignantController {
    public static void showMenu(){
        System.out.println("----------[ Enseignant ]----------");


        System.out.println("1: Pour ajouter un enseignant");
        System.out.println("2: Pour afficher les enseignants");
        System.out.println("3: Pour modifier un enseignant");
        System.out.println("4: Pour supprimer un enseignant");
        System.out.println("0: Pour retourner au menu principal");
        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                createEnseignant();
                break;
            case 2:
                showEnseignants();
                break;
            case 3:
                editEnseignant();
                break;
            case 4:
                destroyEnseignant();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }
    public static void showEnseignants(){
        for (Enseignant enseignant : DataBase.enseignants) {
            System.out.print("Id : " + enseignant.getId());
            System.out.print(" | Nom : " + enseignant.getNom() + " " + enseignant.getPrenom());
            System.out.print(" | Email : " + enseignant.getEmail() );

            System.out.println("");
        }
    }
    public static void createEnseignant(){
        String nom = Main.getStringInput("Entrez le nom de l'enseignant :");
        String prenom = Main.getStringInput("Entrez le prenom de l'enseignant :");
        String email = Main.getStringInput("Entrez lemail de l'enseignant :");
        String grade = Main.getStringInput("Entrez le grade de l'enseignant :");
        EnseignantController.showEnseignants();
        int id = Main.getIntInput("Sélecionnez le departement par id :");
        EnseignantServices.addEns(nom,prenom,email,grade,DepartementService.getDeptById(id));

        showEnseignants();
        showMenu();

    }
    public static void editEnseignant(){
        showEnseignants();
        int id = Main.getIntInput("Sélecionnez un enseignant par id :");
        String nom = Main.getStringInput("Entrez nom de l'enseignant :");
        String prenom = Main.getStringInput("Entrez prenom de l'enseignant :");
        String email = Main.getStringInput("Entrez email de l'enseignant :");
        String grade = Main.getStringInput("Entrez grade de l'enseignant :");
        EnseignantController.showEnseignants();
        int idDep = Main.getIntInput("Sélecionnez un departement par id :");

        EnseignantServices.updateEns(id, nom,prenom,email,grade,DepartementService.getDeptById(idDep));

        showEnseignants();
        showMenu();
    }
    public static void destroyEnseignant(){
        showEnseignants();
        int id = Main.getIntInput("Sélecionnez un enseignant par id :");
        EnseignantServices.deleteEnsById(id);
        showEnseignants();
    }
}
