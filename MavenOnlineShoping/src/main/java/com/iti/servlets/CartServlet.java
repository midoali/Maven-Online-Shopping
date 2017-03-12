/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iti.servlets;

import com.iti.classes.MyShoppingCart;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "CartServlet", urlPatterns = {"/users/cart"})
public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sess = request.getSession(false);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/users/cart.jsp");
        
        MyShoppingCart myCart =(MyShoppingCart) sess.getAttribute("myShoppingCart");
        
        
        
        requestDispatcher.forward(request, response);
    }

}
