package dev.dao;

import dev.entites.Allergene;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AllergeneDaoJpaTest extends BaseTest {
    private final AllergeneDaoJpa allergeneDaoJpa = new AllergeneDaoJpa();
    private void populateDatabase(){
        Allergene allergene = new Allergene();
        allergene.setNom("ok");
        allergeneDaoJpa.inserer(allergene);
    }

    @Test
    public void testExtraire() {
        DaoManager.OuvrirConnexion();
        populateDatabase();
        assertEquals("ok",allergeneDaoJpa.extraire().get(0).getNom());
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
        String nouveauNom = "nok";
        populateDatabase();
        assertEquals(1,allergeneDaoJpa.mettreAJourNom("ok",nouveauNom));
        DaoManager.FermerConnexion();
    }

    @Test
    public void testSupprimer() {
        DaoManager.OuvrirConnexion();
        populateDatabase();
        Allergene allergene = new Allergene();
        allergene.setId(1);
        allergene.setNom("Balenciaga");
        assertEquals(1,allergeneDaoJpa.supprimer(allergene));
        DaoManager.FermerConnexion();
    }
}