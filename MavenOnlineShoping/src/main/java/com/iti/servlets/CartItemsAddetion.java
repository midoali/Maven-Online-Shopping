/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iti.servlets;

import com.iti.classes.MyItem;
import com.iti.classes.MyShoppingCart;
import com.iti.dtos.Product;
import com.iti.facadeservices.ProductService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author MIDO
 */
public class CartItemsAddetion extends HttpServlet {

   
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            HttpSession session=request.getSession();
                 int quantity = Integer.parseInt( request.getParameter("quantity"));
             int proId = Integer.parseInt(request.getParameter("productId"));
              //  Product product=(Product)session.getAttribute("cartProduct");
              Product product=new ProductService().getSingleProduct(proId);
              System.out.println(quantity );
                            System.out.println(proId );

              MyItem item=new MyItem(product, quantity);
              
              MyShoppingCart myShoppingCart=(MyShoppingCart) session.getAttribute("myShoppingCart");
            String url=(String)  session.getAttribute("homeUrl");
             myShoppingCart.getItems().add(item);
            response.sendRedirect(url+"/users/cart");
    }

   
}
