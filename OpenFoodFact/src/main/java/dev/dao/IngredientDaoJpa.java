package dev.dao;

import dev.entites.Ingredient;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

/** IngredientDaoJpa permet d'interagir avec la Table Ingredient de notre Bdd
 * @author Clement
 * @version 1.00
 * Date de mise à jour : 18/04/2023
 */
public class IngredientDaoJpa extends DaoManager implements IngredientDao{

    /**
     * Permet de lire les données de la Table Ingredient
     * @return une liste d'ingrédients représentant les données de la Table Ingredient
     */
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

    /**
     * Permet d'insérer des données dans la Table Ingredient
     * @param ingredient notre ingredient à insérer
     */
    @Override
    public void inserer(Ingredient ingredient) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {

            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();

            entityManager.persist(ingredient);

            tx.commit();
        }
    }

    /**
     * Permet de mettre à jour les données d'un ingredient dans la Table Ingredient
     * @param ancienIngredient le nom de l'ingrédient à modifier
     * @param nouvelIngredient le nouveau nom de l'ingrédient à modifier
     * @return le nombre de lignes affectées
     */
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

    /**
     * Permet de supprimer un ingredient dans la Table Ingredient
     * @param ingredient le nom de l'ingrédient à supprimer
     * @return le nombre de lignes affectées
     */
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
