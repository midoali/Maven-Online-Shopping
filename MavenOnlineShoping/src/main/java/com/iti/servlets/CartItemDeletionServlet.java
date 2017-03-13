/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iti.servlets;

import com.iti.classes.MyShoppingCart;
import java.io.IOException;
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
@WebServlet(name = "CartItemDeletionServlet", urlPatterns = {"/users/deleteCartItem"})
public class CartItemDeletionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        response.setContentType("application/json");
       int itemId = Integer.parseInt(request.getParameter("itemIndex"));
       HttpSession mySession = request.getSession(false);
       MyShoppingCart myCart = (MyShoppingCart)mySession.getAttribute("myShoppingCart");
       
       myCart.getItems().remove(itemId);
       
       String myResponse = "{\"status\":\"ok\",\"message\":\"Item deleted successfully\"}";
       response.getWriter().print(myResponse);
       response.getWriter().close();
    }

}
