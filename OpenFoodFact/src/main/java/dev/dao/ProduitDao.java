package dev.dao;

import dev.entites.Produit;

import java.util.List;

public interface ProduitDao {
    List<Produit> extraire();

    void inserer(Produit produit);

    int mettreAJourNom(String ancienProduit, String nouvelProduit);

    int supprimer(Produit produit);
}
