/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iti.servlets.admin;

import com.iti.dtos.Product;
import com.iti.facadeservices.ProductService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author fatma
 */
@WebServlet(name = "UpdateProductServlet", urlPatterns = {"/admin/updateproduct"})
public class UpdateProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        ProductService productService = new ProductService();
        Product p = productService.getSingleProduct(Integer.parseInt(id));
        request.setAttribute("productInfo", p);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin/updateproduct.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Product product = new Product();

            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List<FileItem> items = upload.parseRequest(request);
            Iterator<FileItem> iter = items.iterator();
            String url = "D:\\0-Nour\\0-iti\\9-month courses\\NetBeans\\gitprojects\\Maven-Online-Shopping\\MavenOnlineShoping\\src\\main\\webapp\\Resources\\images\\products\\";
            System.out.println(url);
            while (iter.hasNext()) {
                FileItem item = iter.next();
                if (!item.isFormField() && !item.getName().isEmpty()) {
                    item.write(new File(url + item.getName()));
                    product.setImagePath(item.getName());
                } else {
                    switch (item.getFieldName()) {
                        case "id":
                            product.setId(Integer.parseInt(item.getString()));
                        case "type":
                            product.setType(item.getString());
                            break;
                        case "desc":
                            product.setDescription(item.getString());
                            break;
                        case "brand":
                            product.setBrand(item.getString());
                            break;
                        case "category":
                            product.setCategoryId(Integer.parseInt(item.getString()));
                            break;
                        case "price":
                            product.setPrice(Double.parseDouble(item.getString()));
                            break;
                        case "quan":
                            product.setQuantity(Integer.parseInt(item.getString()));
                            break;
                        case "color":
                            product.setColor(item.getString());
                            break;
                        case "imgname":
                            product.setImagePath(item.getString());
                        default:
                            break;
                    }
                }
            }
            System.out.println(product.toString());
            new ProductService().updateProduct(product);
            response.sendRedirect("viewProducts");
        } catch (Exception ex) {
            Logger.getLogger(AddProductServlet.class.getName()).log(Level.SEVERE, null, ex);
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
