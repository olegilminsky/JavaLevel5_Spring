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

@WebServlet(urlPatterns = "/product/*")
public class ProductServlet extends HttpServlet {

    private ProductRepository productRepository;

    @Override
    public void init() throws ServletException {
        productRepository = (ProductRepository) getServletContext().getAttribute("productRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getPathInfo() == null) {
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
                        "<td><a href='" + req.getContextPath() + req.getServletPath() + "/"
                        + pr.getId() + "'>" + pr.getName() + "</a></td>" +
                        "</tr>");
            }
            resp.getWriter().println("</table>");
        } else {
            String idString = req.getPathInfo().substring(1);
            Long id = Long.parseLong(idString);
            Product product = productRepository.findById(id);
            resp.getWriter().println("<h1>Product name: "+ product.getName()+"</h1>");
            resp.getWriter().println("<h2>Product id: "+ product.getId()+"</h2>");
            resp.getWriter().println("<h6>Other info of product " + product.getName()+"</h6>");
            resp.getWriter().println("<h6>Other-other info of product " + product.getName()+"</h6>");
            resp.getWriter().println("<h6>Other-other-other info of product " + product.getName()+"</h6>");
            resp.getWriter().println("<h6>Other-other-other-other info of product " + product.getName()+"</h6>");
            resp.getWriter().println("<h6>Other-other-other-other-other info of product " + product.getName()+"</h6>");
        }
    }
}
