package com.olegilminsky.persist;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProductRepository {

    private final List<Product> productList = new ArrayList<>();

    private AtomicLong identity = new AtomicLong(0);

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
}
