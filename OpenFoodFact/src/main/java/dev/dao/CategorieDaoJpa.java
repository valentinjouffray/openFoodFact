package dev.dao;

import dev.entites.Categorie;
import dev.entites.Produit;
import jakarta.persistence.*;

import java.util.List;

public class CategorieDaoJpa extends DaoManager implements CategorieDao{

    @Override
    public List<Categorie> extraire() {
        try(EntityManagerFactory ef = Persistence.createEntityManagerFactory("formation-pu")){
            EntityManager entityManager = ef.createEntityManager();
            TypedQuery<Categorie> categorieTypedQuery = entityManager.createQuery("select a from Categorie a", Categorie.class);
            entityManager.close();
            return categorieTypedQuery.getResultList();
        }
    }

    @Override
    public void inserer(Categorie categorie) {
        try(EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("formation-pu")){
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(categorie);
            transaction.commit();
            entityManager.close();
        }
    }

    @Override
    public int mettreAJourNom(String ancienNom, String nouveauNom) {
        EntityManager entityManager = managerFactory.createEntityManager();
        Query query = entityManager.createQuery("update Categorie set nom = :nouveauNom where nom = :ancienNom");
        query.setParameter("ancienNom",ancienNom);
        query.setParameter("nouveauNom",nouveauNom);
        return query.executeUpdate();
    }

    @Override
    public int mettreAJourProduits(List<Produit> nouveauProduit) {
        return 0;
    }

    @Override
    public int supprimer(Categorie categorie) {
        EntityManager entityManager = managerFactory.createEntityManager();
        Query query = entityManager.createQuery("delete from Categorie a where a.id= :id");
        query.setParameter("id",categorie.getId());
        return query.executeUpdate();
    }
}
