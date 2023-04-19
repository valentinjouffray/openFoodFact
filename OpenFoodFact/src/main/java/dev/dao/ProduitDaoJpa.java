package dev.dao;

import dev.entites.Produit;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

/** ProduitDaoJpa permet d'intéragir avec la Table Produit de notre Bdd
  * @author Clement
  * @version 1.00
  * Date de mise à jour : 18/04/2023
  */
public class ProduitDaoJpa extends DaoManager implements ProduitDao{

    /**
     * Permet de lire les données de la Table Produit
     * @return une liste de produit représentant les données de la Table Produit
     */
    @Override
    public List<Produit> extraire() {
        TypedQuery<Produit> query;
        List<Produit> resultList;
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {

            query = entityManager.createQuery("SELECT p from Produit p", Produit.class);
            resultList = query.getResultList();
        }
        return resultList;
    }

    /**
     * Permet d'insérer des données dans la Table Produit
     * @param produit notre produit à insérer
     */
    @Override
    public void inserer(Produit produit) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {

            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();

            entityManager.persist(produit);

            tx.commit();
        }
    }

    /**
     * Permet de mettre à jour les données d'un produit dans la Table Produit
     * @param ancienProduit le nom du produit à modifier
     * @param nouveauProduit le nom du produit à modifier
     * @return le nombre de lignes affectées
     */
    @Override
    public int mettreAJourNom(String ancienProduit, String nouveauProduit) {
        Query query;
        int ligne;
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {

            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();

            query = entityManager.createQuery("UPDATE Produit p SET p.nom=:nouveauProduit WHERE p.nom=:ancienProduit");
            query.setParameter("nouveauProduit", nouveauProduit);
            query.setParameter("ancienProduit", ancienProduit);

            ligne = query.executeUpdate();

            tx.commit();
        }
        return ligne;
    }

    /**
     * Permet de supprimer un produit dans la Table Produit
     * @param produit le nom du produit à supprimer
     * @return le nombre de lignes affectées
     */
    @Override
    public int supprimer(Produit produit) {
        Query query;
        int verif;
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {

            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();

            query = entityManager.createQuery("DELETE FROM Produit p WHERE p.nom = :nom");
            query.setParameter("nom", produit.getNom());
            verif = query.executeUpdate();

            tx.commit();
        }

        return verif;
    }
}
