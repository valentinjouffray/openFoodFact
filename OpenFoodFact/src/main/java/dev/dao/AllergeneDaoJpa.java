package dev.dao;

import dev.entites.Allergene;
import jakarta.persistence.*;

import java.util.List;

public class AllergeneDaoJpa extends DaoManager implements AllergeneDao{

    @Override
    public List<Allergene> extraire() {
        try(EntityManagerFactory ef = Persistence.createEntityManagerFactory("formation-pu")){
            EntityManager entityManager = ef.createEntityManager();
            TypedQuery<Allergene> allergeneTypedQuery = entityManager.createQuery("select a from Allergene a",Allergene.class);
            entityManager.close();
            return allergeneTypedQuery.getResultList();
        }
    }

    @Override
    public void inserer(Allergene allergene) {
        try(EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("formation-pu")){
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(allergene);
            transaction.commit();
            entityManager.close();
        }
    }

    @Override
    public int mettreAJourNom(String ancienNom, String nouveauNom) {
        EntityManager entityManager = managerFactory.createEntityManager();
        Query query = entityManager.createQuery("update Allergene set nom = :nouveauNom where nom = :ancienNom");
        query.setParameter("ancienNom",ancienNom);
        query.setParameter("nouveauNom",nouveauNom);
        return query.executeUpdate();
    }


    @Override
    public int supprimer(Allergene allergene) {
        EntityManager entityManager = managerFactory.createEntityManager();
        Query query = entityManager.createQuery("delete from Allergene a where a.id= :id");
        query.setParameter("id",allergene.getId());
        return query.executeUpdate();
    }
}
