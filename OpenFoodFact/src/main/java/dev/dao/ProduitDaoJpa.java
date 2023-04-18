package dev.dao;

import dev.entites.Produit;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ProduitDaoJpa extends DaoManager implements ProduitDao{

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

    @Override
    public void inserer(Produit produit) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {

            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();

            entityManager.persist(produit);

            tx.commit();
        }
    }

    @Override
    public int mettreAJourNom(String ancienProduit, String nouvelProduit) {
        Query query;
        int ligne;
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {

            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();

            query = entityManager.createQuery("UPDATE Produit p SET p.nom=:nouvelProduit WHERE p.nom=:ancienProduit");
            query.setParameter("nouvelProduit", nouvelProduit);
            query.setParameter("ancienProduit", ancienProduit);

            ligne = query.executeUpdate();

            tx.commit();
        }
        return ligne;
    }

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
