package dev.userInterface;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Menu {
    private final int OPTION_RECHERCHE_N_MEILLEUR_MARQUE = 1;
    private final int OPTION_RECHERCHE_N_MEILLEUR_CATEGORIE = 2;
    private final int OPTION_RECHERCHE_N_MEILLEUR_MARQUE_CATEGORIE = 3;
    private final int OPTION_RECHERCHE_N_INGREDIENTS_PLUS_COURANTS_AVEC_NB_PRODUITS = 4;
    private final int OPTION_RECHERCHE_N_ALLERGENES_PLUS_COURANTS_AVEC_NB_PRODUITS = 5;
    private final int OPTION_RECHERCHE_N_ADDITIFS_PLUS_COURANTS_AVEC_NB_PRODUITS = 6;
    private static final Logger LOGG = LoggerFactory.getLogger(Menu.class);

    public void afficherMenuPrincipal(){
        LOGG.info("placeholder app name");//TODO remplacer le titre de l'application
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        do {
            validerReponseUtilisateur(scanner);
            /*TODO création d'un nouvel objet recherche qui affiche le résultat de la réponse de l'utilisateur*/
            Recherche recherche = new Recherche();
            recherche.afficherResultat();
            exit = demanderSortie(scanner);
        } while (!exit);
        LOGG.info("Fermeture du programme");
        scanner.close();
    }

    private boolean demanderSortie(Scanner scanner) {
        scanner.next("Si vous souhaitez effectuer une nouvelle recherche, entrez le chiffre '1' sinon entrez" +
                " le chiffre '0' pour fermer le programme");
        return false;
    }

    private void validerReponseUtilisateur(Scanner scanner) {
        int reponseUtilisateur;
        boolean estValeurValide = false;
        while (!estValeurValide) {
            afficherOptions();
            LOGG.info("Entrez un chiffre entre 1 et 6 correspondant à une option");
            reponseUtilisateur = scanner.nextInt();
            if (reponseUtilisateur < 1 || reponseUtilisateur > 6) {
                LOGG.info("La reponse entrée n'est pas valide. Veuillez réessayer.");
            } else {
                estValeurValide = true;
            }
        }
    }

    private void afficherOptions() {
        LOGG.info("1- Rechercher les meilleurs produits d'une marque donnée");
        LOGG.info("2- Rechercher les meilleurs produits d'une catégorie donnée");
        LOGG.info("3- Rechercher les meilleurs produits d'une marque et d'une catégorie donnée");
        LOGG.info("4- Rechercher les ingrédients les plus courants avec leur nombre de produits");
        LOGG.info("5- Rechercher les allergènes les plus courants avec leur nombre de produits");
        LOGG.info("6- Rechercher les additifs les plus courants avec leur nombre de produits");
    }
}
