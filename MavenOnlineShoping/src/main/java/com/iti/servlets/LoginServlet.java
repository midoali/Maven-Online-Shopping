/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iti.servlets;

import com.iti.classes.MyItem;
import com.iti.classes.MyShoppingCart;
import com.iti.dtos.Customer;
import com.iti.facadeservices.CartService;
import com.iti.facadeservices.CustomerService;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
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

    public void fillCart(Vector<MyItem> myItems, MyShoppingCart myShoppingCart) {
        DateFormat df = new SimpleDateFormat("ddMMyyyyHHmmss");
           boolean duplicatedItem=false;
// Get the date today using Calendar object.
   //     System.out.println(uId);
        for (int i = 0; i < myItems.size(); i++) {
            duplicatedItem=false;
             Date currDateTime = Calendar.getInstance().getTime();
            String uId = df.format(currDateTime);
              for(Map.Entry<String,MyItem> entry : myShoppingCart.getItems().entrySet()){
            if(myItems.get(i).getProduct().getId() == entry.getValue().getProduct().getId()){
                int newQty = myItems.get(i).getQuantity() + entry.getValue().getQuantity();
                entry.getValue().setQuantity(newQty);
                duplicatedItem = true;
                break;
            }
        }
        
        if(!duplicatedItem){
            myShoppingCart.getItems().put(uId+i,myItems.get(i));
        }
           
           

        }

    }
    ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String absPath = request.getServletContext().getContextPath();
        HttpSession sess = request.getSession(false);
        String loggedIn = (String) sess.getAttribute("loggedIn");
        if(loggedIn != null && loggedIn == "true"){
            response.sendRedirect(absPath+"/home");
            return;
        }
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
                    CartService cs = new CartService();

                    ///////////////////
                    ///////////////////
                    ///////////////
                    int cartId = cs.getCart(id);
                    session.setAttribute("cartId",cartId);
                    Vector<MyItem> items = cs.getCartItmes(id);
                    MyShoppingCart myCart = new MyShoppingCart();
                    fillCart(items, myCart);
                    session.setAttribute("myShoppingCart", myCart);
                    session.setAttribute("homeUrl", request.getServletContext().getContextPath());
                    System.out.println("logged in successfully");
                    Vector<Customer> onlineUsers = (Vector<Customer>) config.getServletContext().getAttribute("onlineUsers");
                    onlineUsers.add(customerInfo);
                    config.getServletContext().setAttribute("onlineUsers", onlineUsers);
                    absPath = request.getServletContext().getContextPath();
                    response.sendRedirect(absPath + "/home");

                } else {
                    request.setAttribute("error", "Invalid username or password");
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
                    requestDispatcher.forward(request, response);
                }
            } else {
                request.setAttribute("error", "you are already logged in");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
                requestDispatcher.forward(request, response);
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
