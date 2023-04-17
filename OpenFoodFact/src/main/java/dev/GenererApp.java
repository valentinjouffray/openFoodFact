package dev;

import jakarta.persistence.*;

public class GenererApp {

    public static void main(String[] args) {

        try(EntityManagerFactory ef = Persistence.createEntityManagerFactory("formation-pu"))
        {
            try (EntityManager em = ef.createEntityManager()){

            }
        }
    }
}
