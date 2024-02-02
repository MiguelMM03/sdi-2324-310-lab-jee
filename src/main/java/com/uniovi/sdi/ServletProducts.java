package com.uniovi.sdi;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletProducts", value="/products")
public class ServletProducts extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductsService productsService=new ProductsService();
        List<Product> storeProducts=productsService.getProducts();
        req.setAttribute("storeProducts", storeProducts);
        getServletContext().getRequestDispatcher("/products-view.jsp").forward(req,resp);
    }
}
