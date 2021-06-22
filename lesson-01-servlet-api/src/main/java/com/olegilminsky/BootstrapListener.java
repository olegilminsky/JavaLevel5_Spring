package com.olegilminsky;

import com.olegilminsky.persisit.Product;
import com.olegilminsky.persisit.ProductRepository;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class BootstrapListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();

        ProductRepository productRepository = new ProductRepository();
        productRepository.save(new Product(1L, "Product 1"));
        productRepository.save(new Product(2L, "Product 2"));
        productRepository.save(new Product(3L, "Product 3"));
        productRepository.save(new Product(4L, "Product 4"));

        sc.setAttribute("productRepository", productRepository);
    }
}
