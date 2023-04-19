package dev.dao;

import dev.entites.Additif;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

/** AdditifDaoJpa permet d'interagir avec la Table Additif de notre Bdd
 * @author Clement
 * @version 1.00
 * Date de mise à jour : 18/04/2023
 */
public class AdditifDaoJpa extends DaoManager implements AdditifDao {

    /**
     * Permet de lire les données de la Table Additif
     * @return une liste d'additifs représentant les données de la Table Additif
     */
    @Override
    public List<Additif> extraire() {
        TypedQuery<Additif> query;
        List<Additif> resultList;
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {

            query = entityManager.createQuery("SELECT a from Additif a", Additif.class);
            resultList = query.getResultList();
        }
        return resultList;
    }

    /**
     * Permet d'insérer des données dans la Table Additif
     * @param additif notre additif à insérer
     */
    @Override
    public void inserer(Additif additif) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {

            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();

            entityManager.persist(additif);

            tx.commit();
        }
    }

    /**
     * Permet de mettre à jour les données de l'additif dans la Table Additif
     * @param ancienAdditif le nom de l'additif à modifier
     * @param nouvelAdditif le nouveau nom de l'additif à modifier
     * @return le nombre de lignes affectées
     */
    @Override
    public int mettreAJourNom(String ancienAdditif, String nouvelAdditif) {
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

    /**
     * Permet de supprimer un additif dans la Table Additif
     * @param additif le nom de l'additif à supprimer
     * @return le nombre de lignes affectées
     */
    @Override
    public int supprimer(Additif additif) {
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
