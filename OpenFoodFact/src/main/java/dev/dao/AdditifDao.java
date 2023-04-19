package dev.dao;

import dev.entites.Additif;

import java.util.List;

public interface AdditifDao {
    List<Additif> extraire();

    void inserer(Additif additif);

    int mettreAJourNom(String ancienAdditif, String nouvelAdditif);

    int supprimer(Additif additif);
}
