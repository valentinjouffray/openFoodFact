package dev.dao;

import dev.entites.Additif;
import junit.framework.TestCase;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AdditifDaoJpaTest extends TestCase {

    private static final Logger LOG = LoggerFactory.getLogger(AdditifDaoJpaTest.class);
    private static AdditifDaoJpa additifDaoJpa;
    private static Additif a;

    @Before
    public void setUp(){
        DaoManager.OuvrirConnexion();
        additifDaoJpa = new AdditifDaoJpa();
        a = new Additif();
    }

    @Test
    public void testExtraire() {
        List<Additif> lectureAdditif = additifDaoJpa.extraire();
        LOG.info(lectureAdditif.toString());
        assertNotNull(lectureAdditif);
    }

    @Test
    public void testInserer() {
        a.setNom("Additif01");
        additifDaoJpa.inserer(a);
    }

    @Test
    public void testMettreAJourNom() {
        int modif = additifDaoJpa.mettreAJourNom("Additif01", "Additif01a");
        LOG.info("Ligne(s) modifiée(s) : " + modif);
        assertTrue(modif > 0);
    }

    @Test
    public void testSupprimer() {
        a.setNom("Additif01a");
        int supprimer = additifDaoJpa.supprimer(a);
        LOG.info("Suppression : " + supprimer);
        assertTrue(supprimer > 0);
    }

    @After
    public void tearDown(){
        DaoManager.FermerConnexion();
    }
}
