package com.olegilminsky;

import com.olegilminsky.persisit.Product;
import com.olegilminsky.persisit.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/product")
public class ProductServlet extends HttpServlet {

    private ProductRepository productRepository;

    @Override
    public void init() throws ServletException {
        productRepository = (ProductRepository) getServletContext().getAttribute("productRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productRepository.findAll();

        resp.getWriter().println("<table>");
        resp.getWriter().println("<caption>Product table</caption>");
        resp.getWriter().println("<tr>");
        resp.getWriter().println("<th>ID</th>");
        resp.getWriter().println("<th>NAME</th>");
        resp.getWriter().println("</tr>");
        for (Product pr : products) {
            resp.getWriter().println("<tr>" +
                    "<td>" + pr.getId() + "</td>" +
                    "<td>" + pr.getName() + "</td>" +
                    "</tr>");
        }
        resp.getWriter().println("</table>");
    }
}
