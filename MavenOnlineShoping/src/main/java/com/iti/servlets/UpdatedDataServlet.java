/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iti.servlets;

import com.iti.dtos.Customer;
import com.iti.facadeservices.CustomerFacade;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fatma
 */
@WebServlet(name = "UpdatedDataServlet", urlPatterns = {"/UpdatedDataServlet"})
public class UpdatedDataServlet extends HttpServlet {

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
            out.println("<title>Servlet UpdatedDataServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdatedDataServlet at " + request.getContextPath() + "</h1>");
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
        // processRequest(request, response);

        Customer cSession = (Customer) request.getSession().getAttribute("myCustomerInfo");

        cSession.getId();

        String updatedName = request.getParameter("updatedName");
        String updatedMail = request.getParameter("updatedMail");
        int updatedPhone = Integer.parseInt(request.getParameter("updatedPhone"));
        int updatedCredit = Integer.parseInt(request.getParameter("updatedCredit"));
        String updatedAdd = request.getParameter("updatedAdd");
        String updatedBirthday = request.getParameter("updatedBirthday");
        String updatedJob = request.getParameter("updatedJob");

        Customer cObj = new Customer(cSession.getId(), updatedName, java.sql.Date.valueOf(updatedBirthday), updatedJob, updatedMail, updatedCredit, updatedPhone, updatedAdd);

//        UpdateCustomerFacade updateCustomer = new UpdateCustomerFacade();
//        updateCustomer.updateInfo(cObj);
        CustomerFacade customerFacadeObj = new CustomerFacade();
        customerFacadeObj.updateInfo(cObj);

        request.getRequestDispatcher("homePage.html").forward(request, response);
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
