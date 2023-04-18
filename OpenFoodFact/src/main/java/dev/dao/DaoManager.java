package dev.dao;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DaoManager {

    protected static EntityManagerFactory entityManagerFactory;

    public static void OuvrirConnexion() {
        entityManagerFactory = Persistence.createEntityManagerFactory("formation-pu");
    }

    public static void FermerConnexion() {
        entityManagerFactory.close();
    }
}
