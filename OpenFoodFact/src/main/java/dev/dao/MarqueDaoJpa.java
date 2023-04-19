package dev.dao;

import dev.entites.Marque;
import jakarta.persistence.*;

import java.util.List;

/** MarqueDaoJpa permet d'interagir avec la Table Marque de notre Bdd
 * @author Valentin
 * @version 1.00
 * Date de mise à jour : 18/04/2023
 */
public class MarqueDaoJpa extends DaoManager implements MarqueDao{

    /**
     * Permet de lire les données de la Table Marque
     * @return une liste de marques représentant les données de la Table Marque
     */
    @Override
    public List<Marque> extraire() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Marque> marqueTypedQuery = entityManager.createQuery("select a from Marque a",Marque.class);
        List<Marque> resultList = marqueTypedQuery.getResultList();
        entityManager.close();
        return resultList;
    }

    /**
     * Permet d'insérer des données dans la Table Marque
     * @param marque notre marque à insérer
     */
    @Override
    public void inserer(Marque marque) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(marque);
        transaction.commit();
        entityManager.close();
    }

    /**
     * Permet de mettre à jour les données de la marque dans la Table Marque
     * @param ancienNom le nom de la marque à modifier
     * @param nouveauNom le nouveau nom de la marque à modifier
     * @return le nombre de lignes affectées
     */
    @Override
    public int mettreAJourNom(String ancienNom, String nouveauNom) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Query query = entityManager.createQuery("update Marque set nom = :nouveauNom where nom = :ancienNom");
        query.setParameter("ancienNom",ancienNom);
        query.setParameter("nouveauNom",nouveauNom);
        int nbRow = query.executeUpdate();
        transaction.commit();
        return nbRow;
    }

    /**
     * Permet de supprimer une marque dans la Table Marque
     * @param marque le nom de la marque à supprimer
     * @return le nombre de lignes affectées
     */
    @Override
    public int supprimer(Marque marque) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Query query = entityManager.createQuery("delete from Marque a where a.id= :id");
        query.setParameter("id",marque.getId());
        int nbRow = query.executeUpdate();
        transaction.commit();
        return nbRow;
    }
}
