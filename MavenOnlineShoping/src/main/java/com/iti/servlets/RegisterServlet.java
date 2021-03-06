/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iti.servlets;

import com.iti.dtos.Customer;
import com.iti.facadeservices.CartService;
import com.iti.facadeservices.CustomerService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fatma
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/registration"})
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
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("registration.jsp");
        requestDispatcher.forward(request, response);
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
        Date d = Date.valueOf(regBirthday);
        String regJob = request.getParameter("regJob");
        String regAdd = request.getParameter("regAdd");

        Customer userObj = new Customer(regName, d, regPass, regJob, regMail, regCredit, regPhone, regAdd);

        CustomerService regCustomerService = new CustomerService();
        CartService cartService = new CartService();
        if (regCustomerService.register(userObj)) {
            try {
                int userId = regCustomerService.getCustomerID(userObj);
                cartService.addCart(userId);
            } catch (Exception e) {
                e.printStackTrace();
            }
//            request.getRequestDispatcher("home").forward(request, response);
            String absPath = request.getServletContext().getContextPath();
            response.sendRedirect(absPath+"/login");
        } else {
            String absPath = request.getServletContext().getContextPath();
            response.sendRedirect(absPath+"/registration");
//            request.getRequestDispatcher("registration").forward(request, response);
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
