/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iti.servlets;

import com.iti.classes.MyItem;
import com.iti.classes.MyShoppingCart;
import com.iti.dtos.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nour
 */
@WebServlet(name = "PrintServlet", urlPatterns = {"/users/receipt.doc"})
public class PrintServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        MyShoppingCart myCart = (MyShoppingCart) session.getAttribute("myShoppingCart");
        Customer customer = (Customer) session.getAttribute("myCustomer");

        System.out.println("printing receipt");
        response.setContentType("application/msword");
        PrintWriter out = response.getWriter();
        out.println("RECEIPT");
        out.println("--------");
        out.println("date :" + LocalDateTime.now());
        out.println("Customer Info :-");
        out.println("Name = " + customer.getName());
        out.println("Address = " + customer.getAddress());
        out.println("Phone = " + customer.getPhone());
        out.println("Current credit = " + customer.getCredit()+"$");
        out.println("----------------------------------------------------------------");
        out.println("Items :-");
        out.println("(code : quantity x price)");
        for (HashMap.Entry<String, MyItem> entry : myCart.getItems().entrySet()) {
            System.out.printf("Key : %s and Value: %s %n", entry.getKey(), entry.getValue());
            out.println("- product " + entry.getValue().getProduct().getId() + " : " + entry.getValue().getQuantity() + " x " + entry.getValue().getPrice() + "$");
        }
        out.println("\n+ Delivery = 100$");
        double total=myCart.getTotalCost()+100;
        out.println("\nTOTAL = " + total + "$");
        out.println("----------------------------------------------------------------");
        out.println("Thanks for coming to SPORTS SHOP.\nplease come again soon.");
        out.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
