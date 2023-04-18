package dev.dao;

import dev.entites.Additif;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class AdditifDaoJpa extends DaoManager implements AdditifDao {
    @Override
    public List<Additif> extraire() throws SQLException, IOException, ClassNotFoundException {
        TypedQuery<Additif> query;
        List<Additif> resultList;
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {

            query = entityManager.createQuery("SELECT a from Additif a", Additif.class);
            resultList = query.getResultList();
        }
        return resultList;
    }

    @Override
    public void inserer(Additif additif) throws ClassNotFoundException, IOException, SQLException {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {

            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();

            entityManager.persist(additif);

            tx.commit();
        }
    }

    @Override
    public int mettreAJourNom(String ancienAdditif, String nouvelAdditif) throws ClassNotFoundException, IOException, SQLException {
        Query query;
        int ligne;
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {

            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();

            query = entityManager.createQuery("UPDATE Additif a SET a.nom=:nouvelAdditif WHERE a.nom=:ancienAdditif");
            query.setParameter("nouvelAdditif", nouvelAdditif);
            query.setParameter("ancienAdditif", ancienAdditif);

            ligne = query.executeUpdate();

            tx.commit();
        }
        return ligne;
    }

    @Override
    public int supprimer(Additif additif) throws ClassNotFoundException, IOException, SQLException {
        Query query;
        int verif;
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {

            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();

            query = entityManager.createQuery("DELETE FROM Additif a WHERE a.nom = :nom");
            query.setParameter("nom", additif.getNom());
            verif = query.executeUpdate();

            tx.commit();
        }

        return verif;
    }
}
