package dev.dao;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DaoManager {
    protected static EntityManagerFactory managerFactory;

    public static void OuvrirConnexion(){
        managerFactory = Persistence.createEntityManagerFactory("formation-pu");
    }

    public static void FermerConnexion(){
        managerFactory.close();
    }
}
