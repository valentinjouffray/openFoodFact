package dev.dao;

import dev.entites.Allergene;

import java.util.List;

public interface AllergeneDao {
    List<Allergene> extraire();
    void inserer(Allergene allergene);
    int mettreAJourNom(String ancienNom, String nouveauNom);
    int supprimer(Allergene allergene);
}