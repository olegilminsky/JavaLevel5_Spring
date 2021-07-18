package com.olegilminsky;

import com.olegilminsky.entity.Contact;
import com.olegilminsky.entity.User;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

public class Main06 {

    public static void main(String[] args) {
        EntityManagerFactory emFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        EntityManager em = emFactory.createEntityManager();

        // INSERT for one to many
//        em.getTransaction().begin();
//
//        User user = new User(null, "user_with_contacts_2", 25);
//        user.addContact(new Contact(null, "phone", "1245333", user));
//        user.addContact(new Contact(null, "email", "user2@mail.co", user));
//        user.addContact(new Contact(null, "address", "Land1, City2, Street", user));
//
//        em.persist(user);
//
//        em.getTransaction().commit();

        // SELECT

//        User user = em.find(User.class, 9L);
//        User user = em.createQuery("select u from User u join fetch u.contacts where u.id = :id", User.class)
//                .setParameter("id", 9L)
//                .getSingleResult();
//        System.out.println(user);
//        user.getContacts().forEach(System.out::println);

        // N + 1
        em.createQuery("select c from Contact c join fetch c.user", Contact.class).getResultList();

        em.close();
    }
}
