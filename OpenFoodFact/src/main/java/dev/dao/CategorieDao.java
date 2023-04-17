package dev.dao;

import dev.entites.Categorie;
import dev.entites.Produit;

import java.util.List;

public interface CategorieDao {
    List<Categorie> extraire();
    void inserer(Categorie categorie);
    int mettreAJourNom(String ancienNom, String nouveauNom);
    int mettreAJourProduits(List<Produit> nouveauProduit);
    int supprimer(Categorie categorie);
}
