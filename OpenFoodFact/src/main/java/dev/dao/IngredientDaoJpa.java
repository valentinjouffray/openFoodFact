package dev.dao;

import dev.entites.Additif;
import dev.entites.Ingredient;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class IngredientDaoJpa extends DaoManager implements IngredientDao{

    @Override
    public List<Ingredient> extraire() {
        TypedQuery<Ingredient> query;
        List<Ingredient> resultList;
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {

            query = entityManager.createQuery("SELECT i from Ingredient i", Ingredient.class);
            resultList = query.getResultList();
        }
        return resultList;
    }

    @Override
    public void inserer(Ingredient ingredient) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {

            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();

            entityManager.persist(ingredient);

            tx.commit();
        }
    }

    @Override
    public int mettreAJourNom(String ancienIngredient, String nouvelIngredient) {
        Query query;
        int ligne;
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {

            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();

            query = entityManager.createQuery("UPDATE Ingredient i SET i.nom=:nouvelIngredient WHERE i.nom=:ancienIngredient");
            query.setParameter("nouvelIngredient", nouvelIngredient);
            query.setParameter("ancienIngredient", ancienIngredient);

            ligne = query.executeUpdate();

            tx.commit();
        }
        return ligne;
    }

    @Override
    public int supprimer(Ingredient ingredient) {
        Query query;
        int verif;
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {

            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();

            query = entityManager.createQuery("DELETE FROM Ingredient i WHERE i.nom = :nom");
            query.setParameter("nom", ingredient.getNom());
            verif = query.executeUpdate();

            tx.commit();
        }

        return verif;
    }
}
