/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iti.servlets;

import com.iti.dtos.Customer;
import com.iti.facadeservices.CreditService;
import com.iti.facadeservices.CustomerService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nour
 */
@WebServlet(name = "CreditServlet", urlPatterns = {"/credit"})
public class CreditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        int code = Integer.parseInt(request.getParameter("code"));
        CreditService creditService = new CreditService();
        response.getWriter().print(creditService.checkCode(code));
        response.getWriter().close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        int code = Integer.parseInt(request.getParameter("code"));
        Customer customer = (Customer) request.getSession().getAttribute("myCustomer");
        int credit = new CreditService().getCredit(code);
        switch (credit) {
            case -1://not found
                response.getWriter().print("-1");
                break;
            case 0://not available
                response.getWriter().print("0");
                break;
            default:
                CustomerService customerService = new CustomerService();
                customer = customerService.getCustomerInfo(customer.getId());
                customer.setCredit(customer.getCredit() + credit);
                customerService.updateCustomer(customer);
                response.getWriter().print(customer.getCredit());
                request.getSession().setAttribute("myCustomer",customer);
                break;
        }
        response.getWriter().close();
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
