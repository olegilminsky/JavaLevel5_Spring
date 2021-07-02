package com.olegilminsky.persist;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProductRepository {

    private final List<Product> productList = new ArrayList<>();

    private AtomicLong identity = new AtomicLong(0);

    @PostConstruct
    public void init() {
        this.insert(new Product("product1", 10));
        this.insert(new Product("product2", 20));
        this.insert(new Product("product3", 30));
        this.insert(new Product("product4", 40));
        this.insert(new Product("product5", 50));
    }

    public List<Product> findAll() {
        return productList;
    }

    public Product findById(long id) {
        for (Product product : productList) {
            if (product.getId().equals(id)){
                return product;
            }
        }
        return null;
    }

    public void insert(Product product) {
        long id = identity.incrementAndGet();
        product.setId(id);
        productList.add(product);
    }

    public void update(Product product) {
        productList.add(product);
    }

    public void delete(Product product) {
        productList.remove(product);
    }

}
