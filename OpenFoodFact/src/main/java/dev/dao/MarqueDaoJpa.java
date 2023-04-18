package dev.dao;

import dev.entites.Marque;
import jakarta.persistence.*;

import java.util.List;

public class MarqueDaoJpa extends DaoManager implements MarqueDao{

    @Override
    public List<Marque> extraire() {
        try(EntityManagerFactory ef = Persistence.createEntityManagerFactory("formation-pu")){
            EntityManager entityManager = ef.createEntityManager();
            TypedQuery<Marque> marqueTypedQuery = entityManager.createQuery("select a from Marque a",Marque.class);
            entityManager.close();
            return marqueTypedQuery.getResultList();
        }
    }

    @Override
    public void inserer(Marque marque) {
        try(EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("formation-pu")){
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(marque);
            transaction.commit();
            entityManager.close();
        }
    }

    @Override
    public int mettreAJourNom(String ancienNom, String nouveauNom) {
        EntityManager entityManager = managerFactory.createEntityManager();
        Query query = entityManager.createQuery("update Marque set nom = :nouveauNom where nom = :ancienNom");
        query.setParameter("ancienNom",ancienNom);
        query.setParameter("nouveauNom",nouveauNom);
        return query.executeUpdate();
    }

    @Override
    public int supprimer(Marque marque) {
        EntityManager entityManager = managerFactory.createEntityManager();
        Query query = entityManager.createQuery("delete from Marque a where a.id= :id");
        query.setParameter("id",marque.getId());
        return query.executeUpdate();
    }
}
