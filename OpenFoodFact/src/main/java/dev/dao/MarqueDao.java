package dev.dao;

import dev.entites.Marque;
import dev.entites.Produit;

import java.util.List;

public interface MarqueDao {
    List<Marque> extraire();
    void inserer(Marque marque);
    int mettreAJourNom(String ancienNom, String nouveauNom);
    int mettreAJourProduits(List<Produit> nouveauProduit);
    int supprimer(Marque marque);
}
