package dev.dao;

import dev.entites.Allergene;
import jakarta.persistence.*;

import java.util.List;

public class AllergeneDaoJpa extends DaoManager implements AllergeneDao{

    @Override
    public List<Allergene> extraire() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Allergene> allergeneTypedQuery = entityManager.createQuery("select a from Allergene a",Allergene.class);
        List<Allergene> allergenes = allergeneTypedQuery.getResultList();
        entityManager.close();
        return allergenes;
    }

    @Override
    public void inserer(Allergene allergene) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(allergene);
        transaction.commit();
        entityManager.close();
    }

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
