package com.olegilminsky;

import com.olegilminsky.entity.Customer;
import com.olegilminsky.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public class CustomerDao {
    private final EntityManagerFactory emFactory;

    public CustomerDao(EntityManagerFactory emFactory) {
        this.emFactory = emFactory;
    }

    public Optional<Customer> findById(long id) {
        return executeForEntityManager(
                em -> Optional.ofNullable(em.find(Customer.class, id))
        );
    }

    private <R> R executeForEntityManager(Function<EntityManager, R> function) {
        EntityManager em = emFactory.createEntityManager();
        try {
            return function.apply(em);
        } finally {
            em.close();
        }
    }

    private void executeInTransaction(Consumer<EntityManager> consumer) {
        EntityManager em = emFactory.createEntityManager();
        try {
            em.getTransaction().begin();
            consumer.accept(em);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
