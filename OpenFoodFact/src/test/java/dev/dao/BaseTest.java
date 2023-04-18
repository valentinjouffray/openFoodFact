package dev.dao;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class BaseTest {
    protected static EntityManagerFactory entityManagerFactory;

    @BeforeClass
    public static void beforeClass() {
        entityManagerFactory = Persistence.createEntityManagerFactory("formation-pu");
    }

    @AfterClass
    public static void afterClass() {
        entityManagerFactory.close();
    }
}
