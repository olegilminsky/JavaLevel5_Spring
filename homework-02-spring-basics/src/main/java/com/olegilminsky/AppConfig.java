package com.olegilminsky;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean(name = "productRepository")
    public ProductRepository productRepository(){
        return new ProductRepository();
    }

    @Bean(name = "cart")
    @Scope("prototype")
    public Cart cart(){
        return new Cart(productRepository());
    }
}
