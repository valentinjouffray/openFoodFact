package dev.dao;

import dev.entites.Additif;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface AdditifDao {
    List<Additif> extraire() throws SQLException, IOException, ClassNotFoundException;

    void inserer(Additif additif) throws ClassNotFoundException, IOException, SQLException;

    int mettreAJourNom(String ancienAdditif, String nouvelAdditif) throws ClassNotFoundException, IOException, SQLException;

    int supprimer(Additif additif) throws ClassNotFoundException, IOException, SQLException;
}
