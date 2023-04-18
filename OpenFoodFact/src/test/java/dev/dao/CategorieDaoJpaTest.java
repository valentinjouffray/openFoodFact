package dev.dao;

import dev.entites.Categorie;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CategorieDaoJpaTest extends BaseTest{
    private final CategorieDaoJpa categorieDaoJpa = new CategorieDaoJpa();
    private void populateDatabase(){
        Categorie categorie = new Categorie();
        categorie.setNom("Viande");
        categorieDaoJpa.inserer(categorie);
    }

    @Test
    public void testExtraire() {
        DaoManager.OuvrirConnexion();
        populateDatabase();
        assertEquals("Viande",categorieDaoJpa.extraire().get(0).getNom());
        DaoManager.FermerConnexion();
    }

    @Test
    public void testInserer() {
        DaoManager.OuvrirConnexion();
        populateDatabase();
        DaoManager.FermerConnexion();
    }

    @Test
    public void testMettreAJourNom() {
        DaoManager.OuvrirConnexion();
        String nouveauNom = "Vegan";
        populateDatabase();
        assertEquals(1,categorieDaoJpa.mettreAJourNom("Viande",nouveauNom));
        DaoManager.FermerConnexion();
    }

    @Test
    public void testSupprimer() {
        DaoManager.OuvrirConnexion();
        populateDatabase();
        Categorie categorie = new Categorie();
        categorie.setId(1);
        categorie.setNom("Balenciaga");
        assertEquals(1,categorieDaoJpa.supprimer(categorie));
        DaoManager.FermerConnexion();
    }
}
