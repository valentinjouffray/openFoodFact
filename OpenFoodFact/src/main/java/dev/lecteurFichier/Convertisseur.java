package dev.lecteurFichier;

import dev.entites.*;

public class Convertisseur {
    private LecteurFicher lecteurFicher;
    private String[][] result;
    public void insertionProduits(){
        for (String[] strings : result) {
            Categorie categorie = new Categorie();
            categorie.setNom(strings[0]);
            Marque marque = new Marque();
            marque.setNom(strings[1]);
            Additif additif = new Additif();
//            additif.setNom(strings[]);
//            Allergene allergene = new Allergene();
//            Ingredient ingredient = new Ingredient();
            Vitamine vitamine = new Vitamine();
//            vitamine.setVitamine();
            Produit produit = new Produit();
            produit.setNom(strings[2]);
            produit.setCategorie(categorie);
            produit.setMarque(marque);
        }
    }
}
