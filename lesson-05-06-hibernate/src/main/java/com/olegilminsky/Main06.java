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

        em.getTransaction().begin();

        User user = new User(null, "user_with_contacts", 25);
        Contact contact1 = new Contact(null, "phone", "12345", user);
        Contact contact2 = new Contact(null, "email", "user@mail.co", user);
        Contact contact3 = new Contact(null, "address", "Land, City, Street", user);
        user.getContacts().add(contact1);
        user.getContacts().add(contact2);
        user.getContacts().add(contact3);

        em.persist(user);
    }
}
