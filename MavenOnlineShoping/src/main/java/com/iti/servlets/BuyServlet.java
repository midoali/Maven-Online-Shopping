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
import java.sql.Date;
import java.time.LocalDate;
import java.util.Vector;
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
@WebServlet(name = "BuyServlet", urlPatterns = {"/BuyServlet"})
public class BuyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        MyShoppingCart myCart = (MyShoppingCart) session.getAttribute("myShoppingCart");
        Customer customer = (Customer) session.getAttribute("myCustomer");
        double total = myCart.getTotalCost();
        int currentCredit=-1;
        if (total <= customer.getCredit()) {
            if (checkQuantities(myCart)) {
                currentCredit=updateUserCredit(customer, total);
                updateProductsQuantity(myCart);
                makeReceipt(myCart,customer);
                clearCart(session, myCart);
            }
        }
        
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
        for (MyItem item : myCart.getItems()) {
            Product product = productService.getSingleProduct(item.getProduct().getId());
            if (product.getQuantity() < item.getQuantity()) {
                return false;
            }
        }
        return true;
    }

    private int updateUserCredit(Customer customer, double total) {
        int currentcredit=(int) (customer.getCredit() - total);
        customer.setCredit(currentcredit);
        new CustomerService().updateCustomer(customer);
        return currentcredit;
    }

    private void updateProductsQuantity(MyShoppingCart myCart) {
        ProductService productService = new ProductService();
        for (MyItem item : myCart.getItems()) {
            Product product = item.getProduct();
            product.setQuantity(product.getQuantity()-item.getQuantity());
            productService.updateProduct(product);
        }
    }

    private void clearCart(HttpSession session, MyShoppingCart myCart) {
        myCart.getItems().clear();
        session.setAttribute("myShoppingCart", myCart);
    }

    private void makeReceipt(MyShoppingCart myCart, Customer customer) {
        Receipt receipt=new Receipt();
        receipt.setCustomerId(customer.getId());
        receipt.setDate(Date.valueOf(LocalDate.now()));
        receipt.setTotalCost(myCart.getTotalCost());
        Vector<Item> items=new Vector<>();
        for(MyItem item:myCart.getItems())
        {
            Item i=new Item();
            i.setPrice(item.getPrice());
            i.setProductId(item.getProduct().getId());
            i.setQuantity(item.getQuantity());
            items.addElement(i);
        }
        receipt.setItems(items);
        ReceiptService receiptService=new ReceiptService();
        receiptService.addReceipt(receipt);
        
    }

}
