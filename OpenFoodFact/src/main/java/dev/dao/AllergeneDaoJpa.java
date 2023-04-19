package dev.dao;

import dev.entites.Allergene;
import jakarta.persistence.*;

import java.util.List;

/** AdditifDaoJpa permet d'interagir avec la Table Additif de notre Bdd
 * @author Valentin
 * @version 1.00
 * Date de mise à jour : 18/04/2023
 */
public class AllergeneDaoJpa extends DaoManager implements AllergeneDao{

    /**
     * Permet de lire les données de la Table Allergene
     * @return une liste d'allergènes représentant les données de la Table Allergene
     */
    @Override
    public List<Allergene> extraire() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Allergene> allergeneTypedQuery = entityManager.createQuery("select a from Allergene a",Allergene.class);
        List<Allergene> allergenes = allergeneTypedQuery.getResultList();
        entityManager.close();
        return allergenes;
    }

    /**
     * Permet d'insérer des données dans la Table Allergene
     * @param allergene notre allergène à insérer
     */
    @Override
    public void inserer(Allergene allergene) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(allergene);
        transaction.commit();
        entityManager.close();
    }

    /**
     * Permet de mettre à jour les données de l'allergène dans la Table Allergene
     * @param ancienNom le nom de l'allergène à modifier
     * @param nouveauNom le nouveau nom de l'allergène à modifier
     * @return le nombre de lignes affectées
     */
    @Override
    public int mettreAJourNom(String ancienNom, String nouveauNom) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Query query = entityManager.createQuery("update Allergene set nom = :nouveauNom where nom = :ancienNom");
        query.setParameter("ancienNom",ancienNom);
        query.setParameter("nouveauNom",nouveauNom);
        int nbRow = query.executeUpdate();
        transaction.commit();
        entityManager.close();
        return nbRow;
    }

    /**
     * Permet de supprimer une allergène dans la Table Allergene
     * @param allergene le nom de l'allergène à supprimer
     * @return le nombre de lignes affectées
     */
    @Override
    public int supprimer(Allergene allergene) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Query query = entityManager.createQuery("delete from Allergene a where a.id= :id");
        query.setParameter("id",allergene.getId());
        int nbRow = query.executeUpdate();
        transaction.commit();
        entityManager.close();
        return nbRow;
    }
}
