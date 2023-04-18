package dev.dao;

import dev.entites.Additif;
import dev.entites.Ingredient;
import junit.framework.TestCase;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class IngredientDaoJpaTest extends TestCase {

    private static final Logger LOG = LoggerFactory.getLogger(IngredientDaoJpaTest.class);
    private static IngredientDaoJpa ingredientDaoJpa;
    private static Ingredient i;

    @Before
    public void setUp(){
        DaoManager.OuvrirConnexion();
        ingredientDaoJpa = new IngredientDaoJpa();
        i = new Ingredient();
    }

    @Test
    public void testExtraire() {
        List<Ingredient> lectureIngredient = ingredientDaoJpa.extraire();
        LOG.info(lectureIngredient.toString());
        assertNotNull(lectureIngredient);
    }

    @Test
    public void testInserer() {
        i.setNom("Sirop de glucose");
        ingredientDaoJpa.inserer(i);
    }

    @Test
    public void testMettreAJourNom() {
        int modif = ingredientDaoJpa.mettreAJourNom("Sirop de glucose", "Bicarbonate de Sodium");
        LOG.info("Ligne(s) modifiée(s) : " + modif);
        assertTrue(modif > 0);
    }

    @Test
    public void testSupprimer() {
        i.setNom("Bicarbonate de Sodium");
        int supprimer = ingredientDaoJpa.supprimer(i);
        LOG.info("Suppression : " + supprimer);
        assertTrue(supprimer > 0);
    }

    @After
    public void tearDown(){
        DaoManager.FermerConnexion();
    }
}