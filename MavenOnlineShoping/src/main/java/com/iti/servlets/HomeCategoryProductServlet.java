/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iti.servlets;

import com.google.gson.Gson;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Yousef
 */
@WebServlet(name = "HomeCategoryProductServlet", urlPatterns = {"/getHomeProducts"})
public class HomeCategoryProductServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        int categoryId = Integer.parseInt(request.getParameter("cat_id"));
        int lastId = Integer.parseInt(request.getParameter("latest_id"));
        
        Vector<Product> products = null;
//        products = (Vector<Product>) session.getAttribute("products");
        if(categoryId != 0 )
            products = new ProductService().getProductsByCategory(categoryId,lastId);
        else
            products = new ProductService().getAllProducts(lastId);

        System.out.println("lenght is : "+products.size());
        Gson gson = new Gson();
        String data = gson.toJson(products);
        
        PrintWriter out = response.getWriter();
        out.print(data);
        out.close();
    }

}
