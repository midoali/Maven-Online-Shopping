/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iti.servlets;

import com.iti.classes.MyItem;
import com.iti.classes.MyShoppingCart;
import com.iti.dtos.Customer;
import com.iti.dtos.Item;
import com.iti.dtos.Product;
import com.iti.dtos.Receipt;
import com.iti.facadeservices.CustomerService;
import com.iti.facadeservices.ProductService;
import com.iti.facadeservices.ReceiptService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Map;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "BuyServlet", urlPatterns = {"/users/BuyServlet"})
public class BuyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession(false);
        MyShoppingCart myCart = (MyShoppingCart) session.getAttribute("myShoppingCart");
        Customer customer = (Customer) session.getAttribute("myCustomer");
        double total = myCart.getTotalCost() + 100;
        PrintWriter out = response.getWriter();
        if (!myCart.getItems().isEmpty()) {
            if (total <= customer.getCredit()) {
                if (checkQuantities(myCart)) {
                    int currentCredit = updateUserCredit(customer, total);
                    updateProductsQuantity(myCart);
                    makeReceipt(myCart, customer);
                    clearCart(session, myCart);
                    out.print(currentCredit);
                } else {
                    out.print("-1");
                }
            } else {
                out.print("-10");
            }
        } else {
            out.print("-100");
        }
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

    private boolean checkQuantities(MyShoppingCart myCart) {
        ProductService productService = new ProductService();
        for (Map.Entry<String, MyItem> entry : myCart.getItems().entrySet()) {
//        for (MyItem item : myCart.getItems()) {
            Product product = productService.getSingleProduct(entry.getValue().getProduct().getId());
            if (product.getQuantity() < entry.getValue().getQuantity()) {
                return false;
            }
        }
        return true;
    }

    private int updateUserCredit(Customer customer, double total) {
        int currentcredit = (int) (customer.getCredit() - total);
        customer.setCredit(currentcredit);
        new CustomerService().updateCustomer(customer);
        return currentcredit;
    }

    private void updateProductsQuantity(MyShoppingCart myCart) {
        ProductService productService = new ProductService();
        for (Map.Entry<String, MyItem> entry : myCart.getItems().entrySet()) {
//        for (MyItem item : myCart.getItems()) {
            Product product = entry.getValue().getProduct();
            product.setQuantity(product.getQuantity() - entry.getValue().getQuantity());
            productService.updateProduct(product);
        }
    }

    private void makeReceipt(MyShoppingCart myCart, Customer customer) {
        Receipt receipt = new Receipt();
        receipt.setCustomerId(customer.getId());
        receipt.setDate(Date.valueOf(LocalDate.now()));
        receipt.setTotalCost(myCart.getTotalCost());

        Vector<Item> items = new Vector<>();
        for (Map.Entry<String, MyItem> entry : myCart.getItems().entrySet()) {
//        for (MyItem item : myCart.getItems()) {
            Item i = new Item();
            i.setPrice(entry.getValue().getPrice());
            i.setProductId(entry.getValue().getProduct().getId());
            i.setQuantity(entry.getValue().getQuantity());
            items.addElement(i);
        }
        receipt.setItems(items);
        ReceiptService receiptService = new ReceiptService();
        receiptService.addReceipt(receipt);

    }

    private void clearCart(HttpSession session, MyShoppingCart myCart) {
        myCart.getItems().clear();
        session.setAttribute("myShoppingCart", myCart);
    }
}
