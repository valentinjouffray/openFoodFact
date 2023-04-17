package dev.dao;

import dev.entites.Allergene;
import dev.entites.Produit;

import java.util.List;

public interface AllergeneDao {
    List<Allergene> extraire();
    void inserer(Allergene allergene);
    int mettreAJourNom(String ancienNom, String nouveauNom);
    int mettreAJourProduits(List<Produit> nouveauProduit);
    int supprimer(Allergene allergene);
}
