package com.olegilminsky;

import com.olegilminsky.entity.Contact;
import com.olegilminsky.entity.User;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Main06 {

    public static void main(String[] args) {
        EntityManagerFactory emFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        EntityManager em = emFactory.createEntityManager();

        // INSERT for one to many
//        em.getTransaction().begin();
//
//        User user = new User(null, "user_with_contacts", 25);
//        user.addContact(new Contact(null, "phone", "12345", user));
//        user.addContact(new Contact(null, "email", "user@mail.co", user));
//        user.addContact(new Contact(null, "address", "Land, City, Street", user));
//
//        em.persist(user);
//
//        em.getTransaction().commit();

        // SELECT

        User user = em.find(User.class, 9L);
        System.out.println(user);
        user.getContacts().forEach(System.out::println);

        em.close();
    }
}
