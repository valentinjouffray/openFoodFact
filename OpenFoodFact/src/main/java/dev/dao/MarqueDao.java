package dev.dao;

import dev.entites.Marque;

import java.util.List;

public interface MarqueDao {
    List<Marque> extraire();
    void inserer(Marque marque);
    int mettreAJourNom(String ancienNom, String nouveauNom);
    int supprimer(Marque marque);
}