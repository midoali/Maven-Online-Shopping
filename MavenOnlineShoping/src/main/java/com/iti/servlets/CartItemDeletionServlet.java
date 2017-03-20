/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iti.servlets;

import com.iti.classes.MyShoppingCart;
import com.iti.facadeservices.CartService;
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        response.setContentType("application/json");
       String itemId = request.getParameter("itemIndex");
//             int productId = Integer.parseInt(request.getParameter("productId"));
             
       HttpSession mySession = request.getSession(false);
       MyShoppingCart myCart = (MyShoppingCart)mySession.getAttribute("myShoppingCart");
       int cartId=(int)mySession.getAttribute("cartId");
              int productId = myCart.getItems().get(itemId).getProduct().getId();

       myCart.getItems().remove(itemId);
       CartService cs=new CartService();
       
        try {
            cs.deleteCartItem(productId, cartId);
        } catch (Exception e) {
        }
        System.out.println("deleteing item");
       String myResponse = "{\"status\":\"ok\",\"message\":\"Item deleted successfully\",\"finalCost\":\""+String.valueOf(myCart.getTotalCost()+100)+"\",\"totalCost\":\""+String.valueOf(myCart.getTotalCost())+"\",\"numItems\":\""+myCart.getItems().size()+"\"}";
       response.getWriter().print(myResponse);
       response.getWriter().close();
    }

}
