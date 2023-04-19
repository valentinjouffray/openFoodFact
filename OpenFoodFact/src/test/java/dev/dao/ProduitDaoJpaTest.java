package dev.dao;

import dev.entites.Produit;
import junit.framework.TestCase;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/** ProduitDaoJpaTest est une classe Test qui permet de vérifier le bon fonctionnement des méthodes de ProduitDaoJpa
 * @author Clement
 * @version 1.00
 * Date de mise à jour : 18/04/2023
 */
public class ProduitDaoJpaTest extends TestCase {

    private static final Logger LOG = LoggerFactory.getLogger(ProduitDaoJpaTest.class);
    private static ProduitDaoJpa produitDaoJpa;
    private static Produit p;

    /**
     * Code éxécuté avant chaque Test
     * Permet d'Ouvrir une connexion avec EntityManagerFactory
     * Création d'un objet ProduitDaoJpa et Produit
     */
    @Before
    public void setUp(){
        DaoManager.OuvrirConnexion();
        produitDaoJpa = new ProduitDaoJpa();
        p = new Produit();
    }

    /**
     * Permet de lire les donées de la Table Produit dans notre Bdd
     */
    @Test
    public void testExtraire() {
        List<Produit> lectureProduit = produitDaoJpa.extraire();
        LOG.info(lectureProduit.toString());
        assertNotNull(lectureProduit);
    }

    /**
     * Permet d'insérer un Produit dans notre Bdd
     */
    @Test
    public void testInserer() {
        p.setNom("Aromatisation pour yaourtière arôme vanille");
        produitDaoJpa.inserer(p);
    }

    /**
     * Permet de mettre à jour le nom d'un Produit dans notre Bdd
     */
    @Test
    public void testMettreAJourNom() {
        int modif = produitDaoJpa.mettreAJourNom("Aromatisation pour yaourtière arôme vanille", "Coulis Tomate de Provence");
        LOG.info("Ligne(s) modifiée(s) : " + modif);
        assertTrue(modif > 0);
    }

    /**
     * Permet de supprimer un Produit dans notre Bdd
     */
    @Test
    public void testSupprimer() {
        p.setNom("Coulis Tomate de Provence");
        int supprimer = produitDaoJpa.supprimer(p);
        LOG.info("Suppression : " + supprimer);
        assertTrue(supprimer > 0);
    }

    /**
     * Code éxécuté après chaque Test
     * Permet de fermer la connexion avec EntityManagerFactory
     */
    @After
    public void tearDown(){
        DaoManager.FermerConnexion();
    }
}
