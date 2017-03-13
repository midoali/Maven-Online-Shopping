/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iti.servlets;

import com.iti.dtos.Customer;
import com.iti.dtos.Product;
import com.iti.facadeservices.CustomerFacade;
//import com.iti.facadeservices.LoginFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
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
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String loginName = request.getParameter("loginName");
        String loginPass = request.getParameter("loginPass");

        System.out.println("doPost: " + loginName + " " + loginPass);

//        LoginFacade loginFacadeObj = new LoginFacade();

        CustomerFacade customerFacadeObj= new CustomerFacade();
        
        if (customerFacadeObj.checkValidate(loginName, loginPass)) {

            HttpSession session = request.getSession(true);
            session.setAttribute("loggedIn", "true");
            session.setAttribute("myCustomer", customerFacadeObj.getCustomer());

            Customer custObj = new Customer(loginName, loginPass);

            CustomerFacade loginFacade = new CustomerFacade();

            int id = loginFacade.getCustomerID(custObj);

            System.out.println("id ... " + id);

            Customer customerInfo = loginFacade.getCustomerInfo(id);

            session.setAttribute("myCustomerInfo", customerInfo);

            System.out.println("customerInfo.getName()  " + customerInfo.getName());

//            session.setAttribute("name", loginName);
//            session.setAttribute("pass", loginPass);
            ////////////
//            session.setAttribute("mail", loginFacadeObj.getCustomer().getEmail());
//            session.setAttribute("birthday", loginFacadeObj.getCustomer().getBirthday());
//            session.setAttribute("add", loginFacadeObj.getCustomer().getAddress());
//            session.setAttribute("credit", loginFacadeObj.getCustomer().getCredit());
//            session.setAttribute("job", loginFacadeObj.getCustomer().getJob());
//            session.setAttribute("phone", loginFacadeObj.getCustomer().getPhone());
//////////////////////////////////////////////////////////////////////////////////////////////////
//            MyShoppingCart myCart = new MyShoppingCart();
//            ProductService productService = new ProductService();
//
//            Vector<Product> products = productService.getProductsTestData();
//            MyItem item = new MyItem(products.elementAt(0), 2);
//            MyItem item2 = new MyItem(products.elementAt(1), 3);
//
//            myCart.getItems().add(item);
//            myCart.getItems().add(item2);
//            session.setAttribute("myShoppingCart", myCart);
            session.setAttribute("homeUrl", request.getServletContext().getContextPath());

//            response.sendRedirect(request.getServletContext().getContextPath()+"/home");
            request.getRequestDispatcher("homePage.html").forward(request, response);

        } else {
            request.getRequestDispatcher("loginFailed.html").forward(request, response);
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
