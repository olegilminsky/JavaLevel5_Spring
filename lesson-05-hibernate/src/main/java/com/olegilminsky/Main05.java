package com.olegilminsky;

import com.olegilminsky.entity.User;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class Main05 {
    public static void main(String[] args) {
        EntityManagerFactory emFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        EntityManager em = emFactory.createEntityManager();

        // INSERT

        em.getTransaction().begin();

        List.of(
                new User(null, "user2", 18),
                new User(null, "alex", 24),
                new User(null, "ivan", 57),
                new User(null, "petr", 34),
                new User(null, "julia", 27),
                new User(null, "max", 33)
        ).forEach(em::persist);

        em.getTransaction().commit();

        // SELECT

        User user = em.find(User.class, 1L);

        System.out.println(user);



        em.close();
    }
}
