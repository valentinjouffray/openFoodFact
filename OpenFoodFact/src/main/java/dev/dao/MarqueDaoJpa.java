package dev.dao;

import dev.entites.Marque;
import jakarta.persistence.*;

import java.util.List;

public class MarqueDaoJpa extends DaoManager implements MarqueDao{

    @Override
    public List<Marque> extraire() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Marque> marqueTypedQuery = entityManager.createQuery("select a from Marque a",Marque.class);
        List<Marque> resultList = marqueTypedQuery.getResultList();
        entityManager.close();
        return resultList;
    }

    @Override
    public void inserer(Marque marque) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(marque);
        transaction.commit();
        entityManager.close();
    }

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
