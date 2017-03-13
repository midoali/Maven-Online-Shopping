/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iti.servlets;

import com.iti.dtos.Customer;
//import com.iti.facadeservices.LoginFacade;
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
 * @author fatma
 */
@WebServlet(name = "CustHomeServlet", urlPatterns = {"/CustHomeServlet"})
public class CustHomeServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CustHomeServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CustHomeServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // processRequest(request, response);

//        HttpSession session = request.getSession();
//
//        String name = (String) session.getAttribute("name");
//        String pass = (String) session.getAttribute("pass");

      //  Customer custObj = new Customer(name, pass);
//
//        LoginFacade loginFacade = new LoginFacade();
//        int id = loginFacade.getCustomerID(custObj);
//
//        System.out.println("id ... "+ id);
//        
//        Customer customerInfo = loginFacade.getCustomerInfo(id);
//
//        System.out.println("customerInfo.getName()  " + customerInfo.getName());
//        
//        HttpSession sessionProfile = request.getSession(false);
//        
//        sessionProfile.setAttribute("name", customerInfo.getName());
//        sessionProfile.setAttribute("mail", customerInfo.getEmail());
//        sessionProfile.setAttribute("phone", customerInfo.getPhone());
//        sessionProfile.setAttribute("add", customerInfo.getAddress());
//        sessionProfile.setAttribute("job", customerInfo.getJob());
//        sessionProfile.setAttribute("credit", customerInfo.getCredit());
//        sessionProfile.setAttribute("birthday", customerInfo.getBirthday());
//        
//        
//        System.out.println("Name "+  sessionProfile.getAttribute("name")+ " Mail " + sessionProfile.getAttribute("mail") );
//     


//          sessionProfile.setAttribute("password", customerInfo.getPassword()); 

//         custObj = (Customer) session.getAttribute("myCustomer");
//
//        custObj.setEmail((String) session.getAttribute("mail"));
//        custObj.setAddress((String) session.getAttribute("add"));
//        custObj.setBirthday((String) session.getAttribute("birthday"));
//        custObj.setCredit((int) session.getAttribute("credit"));
//        custObj.setPhone((int) session.getAttribute("phone"));
        request.getRequestDispatcher("editProfile.jsp").forward(request, response);
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
        //  processRequest(request, response);

        HttpSession session = request.getSession();
        Customer custObj = (Customer) session.getAttribute("myCustomer");

        custObj.getEmail();
        custObj.getAddress();
        custObj.getBirthday();
        custObj.getCredit();
        custObj.getId();
        custObj.getPhone();

        request.getRequestDispatcher("editProfile.jsp").forward(request, response);

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
