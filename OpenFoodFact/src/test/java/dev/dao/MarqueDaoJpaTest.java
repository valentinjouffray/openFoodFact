package dev.dao;

import dev.entites.Marque;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MarqueDaoJpaTest extends BaseTest{
    private final MarqueDaoJpa marqueDaoJpa = new MarqueDaoJpa();

    private void populateDatabase() {
        Marque marque = new Marque();
        marque.setNom("Balenciaga");
        marqueDaoJpa.inserer(marque);
    }

    @Test
    public void extraire() {
        DaoManager.OuvrirConnexion();
        populateDatabase();
        assertEquals("Balenciaga",marqueDaoJpa.extraire().get(0).getNom());
        DaoManager.FermerConnexion();
    }

    @Test
    public void inserer() {
        DaoManager.OuvrirConnexion();
        populateDatabase();
        DaoManager.FermerConnexion();
    }

    @Test
    public void mettreAJourNom() {
        DaoManager.OuvrirConnexion();
        String nouveauNom = "Gucci";
        populateDatabase();
        assertEquals(1,marqueDaoJpa.mettreAJourNom("Balenciaga",nouveauNom));
        DaoManager.FermerConnexion();
    }

    @Test
    public void supprimer() {
        DaoManager.OuvrirConnexion();
        populateDatabase();
        Marque marque = new Marque();
        marque.setId(1);
        marque.setNom("Balenciaga");
        assertEquals(1,marqueDaoJpa.supprimer(marque));
        DaoManager.FermerConnexion();
    }
}
