package com.olegilminsky;

import com.olegilminsky.entity.User;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Main05 {
    public static void main(String[] args) {
        EntityManagerFactory emFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        EntityManager em = emFactory.createEntityManager();

        // INSERT

        em.getTransaction().begin();

        User user = new User(null, "user1", 25);
        em.persist(user);

        em.getTransaction().commit();

        em.close();
    }
}
