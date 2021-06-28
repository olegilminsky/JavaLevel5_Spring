package com.olegilminsky;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ProductRepository productRepository = context.getBean("productRepository", ProductRepository.class);
        for (int i = 0; i < 5; i++) {
            productRepository.save(new Product("Product " + i + 1, (i + 1) * 10));
        }

        Cart cart1 = context.getBean("cart", Cart.class);
        Cart cart2 = context.getBean("cart", Cart.class);
        Cart cart3 = context.getBean("cart", Cart.class);

        cart1.addProduct(1L);
        cart1.addProduct(2L);
        cart1.addProduct(3L);
        cart1.addProduct(4L);
        cart2.addProduct(1L);
        cart2.addProduct(2L);
        cart3.addProduct(3L);
        cart3.addProduct(4L);

        cart1.deleteProduct(2L);
        cart2.deleteProduct(1L);
        cart3.deleteProduct(4L);
    }
}
