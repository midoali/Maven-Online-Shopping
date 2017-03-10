/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iti.servlets;

import com.iti.daos.ProductDAO;
import com.iti.dtos.Product;
import com.iti.facadeservices.ProductFacade;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author MIDO
 */
@WebServlet(name = "SingleProductServlet", urlPatterns = {"/SingleProductServlet"})
public class SingleProductServlet extends HttpServlet {

  

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String ProductId = "1";

              Product product=new ProductFacade().getSingleProduct(ProductId);
              
              	request.setAttribute("product", product);
              RequestDispatcher rd = getServletContext().getRequestDispatcher("/single.jsp");
              rd.forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
		
       // String ProductId = request.getParameter("ProductId");
            
            
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
