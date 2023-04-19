package dev.dao;

import dev.entites.Categorie;
import jakarta.persistence.*;

import java.util.List;

/** CategorieDaoJpa permet d'interagir avec la Table Categorie de notre Bdd
 * @author Valentin
 * @version 1.00
 * Date de mise à jour : 18/04/2023
 */
public class CategorieDaoJpa extends DaoManager implements CategorieDao{

    /**
     * Permet de lire les données de la Table Categorie
     * @return une liste de categories représentant les données de la Table Categorie
     */
    @Override
    public List<Categorie> extraire() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Categorie> categorieTypedQuery = entityManager.createQuery("select a from Categorie a", Categorie.class);
        List<Categorie> resultList = categorieTypedQuery.getResultList();
        entityManager.close();
        return resultList;
    }

    /**
     * Permet d'insérer des données dans la Table Categorie
     * @param categorie notre catégorie à insérer
     */
    @Override
    public void inserer(Categorie categorie) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(categorie);
        transaction.commit();
        entityManager.close();
    }

    /**
     * Permet de mettre à jour les données d'une catégorie dans la Table Categorie
     * @param ancienNom le nom de la catégorie à modifier
     * @param nouveauNom le nouveau nom de la catégorie à modifier
     * @return le nombre de lignes affectées
     */
    @Override
    public int mettreAJourNom(String ancienNom, String nouveauNom) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Query query = entityManager.createQuery("update Categorie set nom = :nouveauNom where nom = :ancienNom");
        query.setParameter("ancienNom",ancienNom);
        query.setParameter("nouveauNom",nouveauNom);
        int nbRow = query.executeUpdate();
        transaction.commit();
        entityManager.close();
        return nbRow;
    }

    /**
     * Permet de supprimer une catégorie dans la Table Categorie
     * @param categorie le nom de la catégorie à supprimer
     * @return le nombre de lignes affectées
     */
    @Override
    public int supprimer(Categorie categorie) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Query query = entityManager.createQuery("delete from Categorie a where a.id= :id");
        query.setParameter("id",categorie.getId());
        int nbRow = query.executeUpdate();
        transaction.commit();
        entityManager.close();
        return nbRow;
    }
}
