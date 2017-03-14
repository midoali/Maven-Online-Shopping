/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iti.servlets.admin;

import com.iti.dtos.Product;
import com.iti.facadeservices.ProductService;
import java.io.IOException;
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
@WebServlet(name = "UpdateProductServlet", urlPatterns = {"/admin/updateproduct"})
public class UpdateProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id=request.getParameter("productID");
        ProductService productService=new ProductService();
        Product p=productService.getSingleProduct(Integer.parseInt(id));
        request.setAttribute("productInfo", p);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/updateproduct.html");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Product product = new Product();
        product.setId(Integer.parseInt(request.getParameter("id")));
        product.setType(request.getParameter("type"));
        product.setDescription(request.getParameter("desc"));
        product.setBrand(request.getParameter("brand"));
        product.setPrice(Double.parseDouble(request.getParameter("price")));
        product.setQuantity(Integer.parseInt(request.getParameter("quan")));
        product.setColor(request.getParameter("color"));
        product.setImagePath(request.getParameter("imgname"));
        new ProductService().updateProduct(product);
        response.sendRedirect("/home");
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
