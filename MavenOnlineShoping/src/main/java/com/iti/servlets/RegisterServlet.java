/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iti.servlets;

import com.iti.dtos.Customer;
import com.iti.facadeservices.CustomerFacade;
//import com.iti.facadeservices.RegistrationFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fatma
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

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
            out.println("<title>Servlet RegisterServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterServlet at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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

        String regName = request.getParameter("regName");
        String regPass = request.getParameter("regPass");
        String regMail = request.getParameter("regMail");
        int regCredit = 0;//Integer.parseInt(request.getParameter("regCredit"));
        int regPhone = Integer.parseInt(request.getParameter("regPhone"));
        String regBirthday = request.getParameter("regBirthday");
        String regJob = request.getParameter("regJob");
        String regAdd = request.getParameter("regAdd");

        Customer customerObj = new Customer();
        customerObj.setName(regName);
        customerObj.setPassword(regPass);
        customerObj.setEmail(regMail);
        customerObj.setCredit(regCredit);
        customerObj.setPhone(regPhone);
        customerObj.setBirthday(java.sql.Date.valueOf(regBirthday));
        customerObj.setJob(regJob);
        customerObj.setAddress(regAdd);

//        Customer userObj = new Customer(regName, regBirthday, regPass, regJob, regMail, regCredit, regPhone, regAdd);

//        RegistrationFacade registrationFacadeObj = new RegistrationFacade();
        CustomerFacade customerFacadeObj = new CustomerFacade();

        if (customerFacadeObj.register(customerObj)) {
            request.getRequestDispatcher("index.html").forward(request, response);
        } else {
            request.getRequestDispatcher("registration.html").forward(request, response);
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
