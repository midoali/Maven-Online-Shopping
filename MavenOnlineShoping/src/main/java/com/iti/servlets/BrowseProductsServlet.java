/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iti.servlets;

import com.google.gson.Gson;
import com.iti.dtos.Category;
import com.iti.dtos.Product;
import com.iti.facadeservices.ProductService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Yousef
 */
@WebServlet(name = "BrowseProductsServlet", urlPatterns = {"/browseProducts"})
public class BrowseProductsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Vector<Product> products = new ProductService().getAllProducts();
        Vector<Category> categories = new ProductService().getAllCategories();
        request.setAttribute("products", products);
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("/browseProducts.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        int categoryId = Integer.parseInt(request.getParameter("catFields"));
        String[] brands = request.getParameterValues("brandChecks");
        int lowerBoundPrice = Integer.parseInt(request.getParameter("amount1"));
        int upperBoundPrice = Integer.parseInt(request.getParameter("amount2"));
        String keyword = request.getParameter("keyword");
        Vector<Product>  products = new ProductService().searchProducts(categoryId,brands,lowerBoundPrice,upperBoundPrice,keyword);

        Gson gson = new Gson();
        String data = gson.toJson(products);
        
        PrintWriter out = response.getWriter();
        out.print(data);
        out.close();
    }

    

}
