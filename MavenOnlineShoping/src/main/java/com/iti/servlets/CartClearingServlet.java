/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iti.servlets;

import com.iti.classes.MyShoppingCart;
import com.iti.facadeservices.CartService;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "CartClearingService", urlPatterns = {"/users/clearCart"})
public class CartClearingServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
       HttpSession mySession = request.getSession(false);
       MyShoppingCart myCart = (MyShoppingCart)mySession.getAttribute("myShoppingCart");
       int cartId=(int)mySession.getAttribute("cartId");
       CartService cs=new CartService();
       
       myCart.getItems().clear();
        try {
            cs.clearCart(cartId);
        } catch (Exception e) {
        }
       
       String myResponse = "{\"status\":\"ok\",\"message\":\"cart cleared successfully\"}";
       response.getWriter().print(myResponse);
       response.getWriter().close();
    }
}
