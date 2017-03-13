/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iti.servlets.admin;

import com.iti.facadeservices.ProductService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Yousef
 */
@WebServlet(name = "ProductDeletionServlet", urlPatterns = {"/admin/deleteProduct"})
public class ProductDeletionServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String productIdStr = request.getParameter("productId");
        int productId = Integer.parseInt(productIdStr);
        
        ProductService productService = new ProductService();
        String myResponse = "";
        if(productService.deleteProduct(productId)){
            myResponse = "{\"status\":\"ok\",\"message\":\"Product deleted successfully\"}";
        }else{
            myResponse = "{\"status\":\"fail\",\"message\":\"Error didn't delete the product\"}";
        }
        response.getWriter().print(myResponse);
        response.getWriter().close();
    }

}
