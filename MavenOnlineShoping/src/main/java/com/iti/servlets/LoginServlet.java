/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iti.servlets;

import com.iti.classes.MyItem;
import com.iti.classes.MyShoppingCart;
import com.iti.dtos.Customer;
import com.iti.dtos.Product;
import com.iti.facadeservices.CustomerFacade;
import com.iti.facadeservices.LoginFacade;
import com.iti.facadeservices.ProductService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fatma
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String loginName = request.getParameter("loginName");
        String loginPass = request.getParameter("loginPass");

        System.out.println("doPost: " + loginName + " " + loginPass);

        LoginFacade loginFacadeObj = new LoginFacade();
        String status=(String) request.getSession(false).getAttribute("loggedIn");
        System.out.println("status="+status);
        if (!"true".equals(status)) {
            if (loginFacadeObj.checkValidate(loginName, loginPass)) {
                HttpSession session = request.getSession(true);
                session.setAttribute("loggedIn", "true");
                session.setAttribute("myCustomer", loginFacadeObj.getCustomer());
                MyShoppingCart myCart = new MyShoppingCart();
                ProductService productService = new ProductService();
                Vector<Product> products = productService.getProductsTestData();
                MyItem item = new MyItem(products.elementAt(0), 2);
                MyItem item2 = new MyItem(products.elementAt(1), 3);
                myCart.getItems().add(item);
                myCart.getItems().add(item2);
                session.setAttribute("myShoppingCart", myCart);
                session.setAttribute("homeUrl", request.getServletContext().getContextPath());
                System.out.println("logged in successfully");
                response.sendRedirect(request.getServletContext().getContextPath() + "/home");

            } else {
                request.getRequestDispatcher("login").forward(request, response);
            }
        }
        else
        {
            System.out.println("you are already logged in");
            response.sendRedirect(request.getServletContext().getContextPath() + "/home");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
