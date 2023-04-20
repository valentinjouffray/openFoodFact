package dev.userInterface;

import dev.dao.CategorieDaoJpa;
import dev.dao.DaoManager;
import dev.dao.MarqueDaoJpa;
import dev.entites.Categorie;
import dev.entites.Marque;
import dev.entites.Produit;
import org.apache.commons.text.WordUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Recherche {
    public void option1(){
        List<Produit> meilleursProduits = new ArrayList<>();
        MarqueDaoJpa marqueDaoJpa = new MarqueDaoJpa();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez renseigner la marque que vous recherchez : ");
        String marqueRecherche = scanner.nextLine();
        marqueRecherche = WordUtils.capitalizeFully(marqueRecherche.trim());
        scanner.close();
        DaoManager.OuvrirConnexion();
        List<Marque> marques = marqueDaoJpa.extraire();
        boolean marqueTrouve = false;
        Iterator<Marque> marqueIterator = marques.iterator();
        while (marqueIterator.hasNext() && !marqueTrouve) {
            Marque marque = marqueIterator.next();
            marqueTrouve = isFound(meilleursProduits, marqueRecherche, marque);
        }
        afficherMeilleursProduits(meilleursProduits);
        DaoManager.FermerConnexion();
    }

    private static boolean isFound(List<Produit> meilleursProduits, String marqueRecherche, Marque marque) {
        boolean marqueTrouve = true;
        if (marque.getNom().equals(marqueRecherche)){
            marqueTrouve = true;
            List<Produit> produitListA = new ArrayList<>();
            List<Produit> produitListB = new ArrayList<>();
            List<Produit> produitListC = new ArrayList<>();
            List<Produit> produitListD = new ArrayList<>();
            List<Produit> produitListE = new ArrayList<>();
            int totalProduit = 0;
            Iterator<Produit> iterator = marque.getProduits().iterator();
            while (iterator.hasNext() && totalProduit < 10) {
                Produit produit = iterator.next();
                fillTempList(produitListA, produitListB, produitListC, produitListD, produitListE, produit);
            }
            fillFullList(meilleursProduits, produitListA, produitListB, produitListC, produitListD, produitListE, totalProduit);
        }
        return marqueTrouve;
    }

    private static void fillTempList(List<Produit> produitListA, List<Produit> produitListB, List<Produit> produitListC, List<Produit> produitListD, List<Produit> produitListE, Produit produit) {
        switch (produit.getGradeNutrition()){
            case A -> produitListA.add(produit);
            case B -> produitListB.add(produit);
            case C -> produitListC.add(produit);
            case D -> produitListD.add(produit);
            case E -> produitListE.add(produit);
        }
    }

    private static void afficherMeilleursProduits(List<Produit> meilleursProduits) {
        for (Produit meilleursProduit : meilleursProduits) {
            System.out.println(meilleursProduit);
        }
    }

    private static void fillFullList(List<Produit> meilleursProduits, List<Produit> produitListA, List<Produit> produitListB, List<Produit> produitListC, List<Produit> produitListD, List<Produit> produitListE, int totalProduit) {
        fillList(meilleursProduits, produitListA, totalProduit);
        fillList(meilleursProduits, produitListB, totalProduit);
        fillList(meilleursProduits, produitListC, totalProduit);
        fillList(meilleursProduits, produitListD, totalProduit);
        fillList(meilleursProduits, produitListE, totalProduit);
    }

    private static void fillList(List<Produit> meilleursProduits, List<Produit> produitListA, int totalProduit) {
        Iterator<Produit> produitAIterator = produitListA.iterator();
        while (produitAIterator.hasNext() && !(totalProduit < 10)) {
            meilleursProduits.addAll(produitListA);
            totalProduit++;
        }
    }

    public void option2(){
        List<Produit> meilleursProduits = new ArrayList<>();
        CategorieDaoJpa categorieDaoJpa = new CategorieDaoJpa();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez renseigner la categorie que vous recherchez : ");
        String categorieRecherche = scanner.nextLine();
        categorieRecherche = WordUtils.capitalizeFully(categorieRecherche.trim());
        scanner.close();
        DaoManager.OuvrirConnexion();
        List<Categorie> categories = categorieDaoJpa.extraire();
        boolean categorieTrouve = false;
        Iterator<Categorie> categorieIterator = categories.iterator();
        while (categorieIterator.hasNext() && !categorieTrouve) {
            Categorie categorie = categorieIterator.next();
            categorieTrouve = isFound(meilleursProduits, categorieRecherche, categorie);
        }
        afficherMeilleursProduits(meilleursProduits);
        DaoManager.FermerConnexion();
    }

    private static boolean isFound(List<Produit> meilleursProduits, String categorieRecherche, Categorie categorie) {
        boolean categorieTrouve = false;
        if (categorie.getNom().equals(categorieRecherche)){
            categorieTrouve = true;
            Iterator<Produit> iterator = categorie.getProduits().iterator();
            List<Produit> produitListA = new ArrayList<>();
            List<Produit> produitListB = new ArrayList<>();
            List<Produit> produitListC = new ArrayList<>();
            List<Produit> produitListD = new ArrayList<>();
            List<Produit> produitListE = new ArrayList<>();
            int totalProduit = 0;
            while (iterator.hasNext() && totalProduit < 10) {
                Produit produit = iterator.next();
                fillTempList(produitListA, produitListB, produitListC, produitListD, produitListE, produit);
            }
            fillFullList(meilleursProduits,produitListA,produitListB,produitListC,produitListD,produitListE,totalProduit);
        }
        return categorieTrouve;
    }

    public void option3(){
        List<Produit> meilleursProduits = new ArrayList<>();
        DaoManager.OuvrirConnexion();
        CategorieDaoJpa categorieDaoJpa = new CategorieDaoJpa();
        MarqueDaoJpa marqueDaoJpa = new MarqueDaoJpa();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez renseigner la categorie que vous recherchez d'abord : ");
        String categorieRecherche = scanner.nextLine();
        System.out.println("Veuillez renseigner la marque que vous recherchez ensuite : ");
        String marqueRecherche = scanner.nextLine();
        categorieRecherche = WordUtils.capitalizeFully(categorieRecherche.trim());
        marqueRecherche = WordUtils.capitalizeFully(marqueRecherche.trim());
        scanner.close();
        DaoManager.OuvrirConnexion();
        List<Categorie> categories = categorieDaoJpa.extraire();
        List<Marque> marques = marqueDaoJpa.extraire();
        boolean marqueTrouve = false;
        Iterator<Marque> marqueIterator = marques.iterator();
        while (marqueIterator.hasNext() && !marqueTrouve) {
            Marque marque = marqueIterator.next();
            if (marque.getNom().equals(marqueRecherche)) {
                marqueTrouve = true;
                Iterator<Categorie> categorieIterator = categories.iterator();
                boolean catergorieTrouve = false;
                while (categorieIterator.hasNext() && !catergorieTrouve) {
                    Categorie categorie = categorieIterator.next();
                    catergorieTrouve = isFound(meilleursProduits,categorieRecherche,categorie);
                }
            }
        }
        afficherMeilleursProduits(meilleursProduits);
        DaoManager.FermerConnexion();
    }

    public void afficherResultat(String reponseUtilisateur) {
        //TODO compléter la méthode dans une branche fille de celle-ci
        switch (reponseUtilisateur){
            case "1" -> option1();
            case "2" -> option2();
            case "3" -> option3();
            default -> throw new IllegalStateException("Unexpected value: " + reponseUtilisateur);
        }
    }
}