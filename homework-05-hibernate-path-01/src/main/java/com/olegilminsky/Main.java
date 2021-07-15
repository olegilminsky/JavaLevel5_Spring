package com.olegilminsky;

import com.olegilminsky.entity.Product;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;


// Helper class for creating a database
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        EntityManager em = emFactory.createEntityManager();

        em.getTransaction().begin();

//        List.of(
//                new Product(null, "product1", 10),
//                new Product(null, "product2", 20),
//                new Product(null, "product3", 30),
//                new Product(null, "product4", 40),
//                new Product(null, "product5", 50),
//                new Product(null, "product6", 60),
//                new Product(null, "product7", 70)
//        ).forEach(em::persist);

        em.getTransaction().commit();
        em.close();
    }
}
