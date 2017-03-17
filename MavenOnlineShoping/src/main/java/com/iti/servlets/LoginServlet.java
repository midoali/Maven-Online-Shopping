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
import com.iti.facadeservices.CustomerService;
import com.iti.facadeservices.ProductService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
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

    ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String absPath = null;
        String loginName = request.getParameter("loginName");
        String loginPass = request.getParameter("loginPass");

        System.out.println("doPost: " + loginName + " " + loginPass);

        if (checkloggedin(loginName, loginPass)) {
            System.out.println("you are already logged in");
            request.setAttribute("error", "you are already logged in");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
            requestDispatcher.forward(request, response);
        } else {
            CustomerService customerService = new CustomerService();
            String status = (String) request.getSession(false).getAttribute("loggedIn");
            System.out.println("status=" + status);
            if (!"true".equals(status)) {
                if (customerService.checkValidate(loginName, loginPass)) {

                    HttpSession session = request.getSession(true);
                    session.setAttribute("loggedIn", "true");
                    Customer custObj = new Customer(loginName, loginPass);
                    int id = customerService.getCustomerID(custObj);
                    Customer customerInfo = customerService.getCustomerInfo(id);
                    session.setAttribute("myCustomer", customerInfo);
                    
                    
                    ///////////////////

                    ///////////////
                    MyShoppingCart myCart = new MyShoppingCart();
                    session.setAttribute("myShoppingCart", myCart);
                    session.setAttribute("homeUrl", request.getServletContext().getContextPath());
                    System.out.println("logged in successfully");
                    Vector<Customer> onlineUsers = (Vector<Customer>) config.getServletContext().getAttribute("onlineUsers");
                    onlineUsers.add(customerInfo);
                    config.getServletContext().setAttribute("onlineUsers", onlineUsers);
                    if(request.getServletContext() != null  && request.getServletContext().getContextPath() != null)
                        absPath = request.getServletContext().getContextPath();
                    response.sendRedirect(absPath + "/home");

                } 
                else {
                    response.sendRedirect(absPath + "/login");

                }
            } else {
                System.out.println("you are already logged in");
                response.sendRedirect(request.getServletContext().getContextPath() + "/home");
            }
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

    private boolean checkloggedin(String loginName, String loginPass) {
        System.out.println("logging user:" + loginName + ",pass:" + loginPass);
        Vector<Customer> onlineUsers = (Vector<Customer>) config.getServletContext().getAttribute("onlineUsers");
        for (Customer onlineUser : onlineUsers) {
            System.out.println("Online users:" + onlineUser.toString());
            if (onlineUser.getName().equals(loginName) && onlineUser.getPassword().equals(loginPass)) {
                return true;
            }
        }
        return false;
    }

}
