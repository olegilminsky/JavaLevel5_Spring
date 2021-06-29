package com.olegilminsky;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class ProductRepository {
    private final List<Product> productList = new ArrayList<>();

    private final AtomicLong identity = new AtomicLong(0);

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

    public void save(Product product){
        if (product.getId() == null){
            product.setId(identity.incrementAndGet());
        }
        productList.add(product);
    }
}
