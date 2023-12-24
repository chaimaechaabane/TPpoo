package TP.Controllers;


import TP.Main;
import TP.Services.*;
import TP.models.Etudiant;
import TP.models.Filiere;


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
        showEtudiant();
        int id = Main.getIntInput("Sélecionnez un etudiant par id :");
        EtudiantServices.deleteEtdById(id);
        showEtudiant();
    }


    public static void editEtudiant() {
        showEtudiant();
        int id = Main.getIntInput("Sélecionnez un etudiant par id :");
        String nom = Main.getStringInput("Entrez nom de l'etudiant :");
        String prenom = Main.getStringInput("Entrez prenom de l'etudiant :");
        String email = Main.getStringInput("Entrez email de l'etudiant :");
        int apogee = Main.getIntInput("Entrez apogee de l'etudiant:");
        EtudiantController.showEtudiant();
        int idFil = Main.getIntInput("Sélecionnez une filiere par id :");

        EtudiantServices.updateEtd(id, nom,prenom,email,apogee, FiliereServices.getFiliereById(idFil));

        showEtudiant();
        showMenu();
    }

    public static void showEtudiant() {
        for (Etudiant etudiant : DataBase.etudiants) {
            System.out.print("Id : " + etudiant.getId());
            System.out.print(" | Nom : " + etudiant.getNom() + " " + etudiant.getPrenom());
            System.out.print(" | Email : " + etudiant.getEmail() );
            System.out.print(" | Apogee : " + etudiant.getApogee() );
            System.out.print(" | Filiere : " + etudiant.getFiliere() );

            System.out.println("");
        }
    }

    public static void createEtudiant() {
        String nom = Main.getStringInput("Entrez le nom de l'etudiant :");
        String prenom = Main.getStringInput("Entrez le prenom de l'etudiant :");
        String email = Main.getStringInput("Entrez lemail de l'etudiant :");
        int apogee = Main.getIntInput("Entrez l'apogee de l'etudiant :");
        EtudiantController.showEtudiant();
        int id = Main.getIntInput("Sélecionnez la filiere par id :");
        EtudiantServices.addEtd(nom,prenom,email,apogee, FiliereServices.getFiliereById(id));

        showEtudiant();
        showMenu();
    }

}
