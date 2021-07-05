package com.olegilminsky.persist;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProductRepository {

    private Map<Long, Product> productMap = new ConcurrentHashMap<>();

    private List<Product> productList;

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
        return productList = new ArrayList<>(productMap.values());
    }

    public Product findById(long id) {
        return productMap.get(id);
    }

    public void insert(Product product) {
        long id = identity.incrementAndGet();
        product.setId(id);
        productMap.put(id, product);
    }

    public void update(Product product) {
        productMap.put(product.getId(), product);
    }

    public void delete(long id) {
        productMap.remove(id);
    }
}
