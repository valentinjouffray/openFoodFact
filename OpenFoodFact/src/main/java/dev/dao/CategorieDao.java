package dev.dao;

import dev.entites.Categorie;

import java.util.List;

public interface CategorieDao {
    List<Categorie> extraire();
    void inserer(Categorie categorie);
    int mettreAJourNom(String ancienNom, String nouveauNom);
    int supprimer(Categorie categorie);
}