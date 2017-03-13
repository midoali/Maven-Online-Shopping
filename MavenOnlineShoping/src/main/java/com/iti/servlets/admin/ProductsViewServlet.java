/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iti.servlets.admin;

import com.google.gson.Gson;
import com.iti.dtos.Product;
import com.iti.facadeservices.ProductService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Yousef
 */
@WebServlet(name = "ProductsViewServlet", urlPatterns = {"/admin/viewProducts"})
public class ProductsViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Vector<Product> products = new ProductService().getAllProducts();
        System.out.println(products.size());
        request.setAttribute("products", products);
        
        
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin/productsView.jsp");
        requestDispatcher.forward(request, response);
    }

    private String buildGsonString(Vector<Product> products){
        Gson gson = new Gson();
        String str = gson.toJson(products);
        System.out.println(str);
        return str;
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        String keyword = request.getParameter("keyword");
        Vector<Product> products = null;
        if(keyword.length() > 0 )
            products = new ProductService().getProductsByKeyword(request.getParameter("keyword"));
        else
            products = new ProductService().getAllProducts();
       
        PrintWriter out = response.getWriter();
        out.print(buildGsonString(products));
        
    }

}
