package dev.dao;

import dev.entites.Categorie;
import jakarta.persistence.*;

import java.util.List;

public class CategorieDaoJpa extends DaoManager implements CategorieDao{

    @Override
    public List<Categorie> extraire() {
        EntityManager entityManager = managerFactory.createEntityManager();
        TypedQuery<Categorie> categorieTypedQuery = entityManager.createQuery("select a from Categorie a", Categorie.class);
        List<Categorie> resultList = categorieTypedQuery.getResultList();
        entityManager.close();
        return resultList;
    }

    @Override
    public void inserer(Categorie categorie) {
        EntityManager entityManager = managerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(categorie);
        transaction.commit();
        entityManager.close();
    }

    @Override
    public int mettreAJourNom(String ancienNom, String nouveauNom) {
        EntityManager entityManager = managerFactory.createEntityManager();
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

    @Override
    public int supprimer(Categorie categorie) {
        EntityManager entityManager = managerFactory.createEntityManager();
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
