package com.olegilminsky;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Cart {
    private final List<Product> cartProductList = new ArrayList<>();
    private final ProductRepository productRepository;

    public Cart(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(Long id) {
        cartProductList.add(productRepository.findById(id));
    }

    public void  deleteProduct(Long id){
        cartProductList.remove(productRepository.findById(id));
    }
}
