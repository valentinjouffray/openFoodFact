package dev.dao;

import dev.entites.Produit;
import junit.framework.TestCase;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ProduitDaoJpaTest extends TestCase {

    private static final Logger LOG = LoggerFactory.getLogger(ProduitDaoJpaTest.class);
    private static ProduitDaoJpa produitDaoJpa;
    private static Produit p;

    @Before
    public void setUp(){
        DaoManager.OuvrirConnexion();
        produitDaoJpa = new ProduitDaoJpa();
        p = new Produit();
    }
    @Test
    public void testExtraire() {
        List<Produit> lectureProduit = produitDaoJpa.extraire();
        LOG.info(lectureProduit.toString());
        assertNotNull(lectureProduit);
    }

    @Test
    public void testInserer() {
        p.setNom("Aromatisation pour yaourtière arôme vanille");
        produitDaoJpa.inserer(p);
    }

    @Test
    public void testMettreAJourNom() {
        int modif = produitDaoJpa.mettreAJourNom("Aromatisation pour yaourtière arôme vanille", "Coulis Tomate de Provence");
        LOG.info("Ligne(s) modifiée(s) : " + modif);
        assertTrue(modif > 0);
    }

    @Test
    public void testSupprimer() {
        p.setNom("Coulis Tomate de Provence");
        int supprimer = produitDaoJpa.supprimer(p);
        LOG.info("Suppression : " + supprimer);
        assertTrue(supprimer > 0);
    }

    @After
    public void tearDown(){
        DaoManager.FermerConnexion();
    }
}