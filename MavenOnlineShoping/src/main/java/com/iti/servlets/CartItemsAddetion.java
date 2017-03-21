/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iti.servlets;

import com.iti.classes.MyItem;
import com.iti.classes.MyShoppingCart;
import com.iti.dtos.CartItem;
import com.iti.dtos.Product;
import com.iti.facadeservices.CartService;
import com.iti.facadeservices.ProductService;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author MIDO
 */
public class CartItemsAddetion extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int proId = Integer.parseInt(request.getParameter("productId"));
        int cartId=(int)session.getAttribute("cartId");
        String isHome = request.getParameter("home");
        //  Product product=(Product)session.getAttribute("cartProduct");
        Product product = new ProductService().getSingleProduct(proId);
        System.out.println(quantity);
        System.out.println(proId);

        MyItem item = new MyItem(product, quantity);
        CartItem cartItem=new CartItem();
        cartItem.setProductId(proId);
        cartItem.setQuantity(quantity);
        cartItem.setCartId(cartId);
        
        MyShoppingCart myShoppingCart = (MyShoppingCart) session.getAttribute("myShoppingCart");
        DateFormat df = new SimpleDateFormat("ddMMyyyyHHmmss");

// Get the date today using Calendar object.
        Date currDateTime = Calendar.getInstance().getTime();
        String uId = df.format(currDateTime);
        System.out.println(uId);
        
        Boolean duplicatedItem = false;
        for(Map.Entry<String,MyItem> entry : myShoppingCart.getItems().entrySet()){
            if(item.getProduct().getId() == entry.getValue().getProduct().getId()){
                int newQty = item.getQuantity() + entry.getValue().getQuantity();
                entry.getValue().setQuantity(newQty);
                duplicatedItem = true;
                break;
            }
        }
        
        if(!duplicatedItem){
            myShoppingCart.getItems().put(uId,item);
        }
        try {
            CartService  cs=new CartService();
            cs.addItem(cartItem);
        } catch (Exception e) {
            e.printStackTrace();
        }
// Using DateFormat format method we can create a string 
// representation of a date with the defined format.
        
        String url = (String) session.getAttribute("homeUrl");
        if(isHome != null && isHome.equals("true")){
            String myResponse = "{\"status\":\"ok\",\"message\":\"Item deleted successfully\",\"finalCost\":\""+String.valueOf(myShoppingCart.getTotalCost()+100)+"\",\"totalCost\":\""+String.valueOf(myShoppingCart.getTotalCost())+"\",\"numItems\":\""+myShoppingCart.getItems().size()+"\"}";
            response.getWriter().print(myResponse);
            response.getWriter().close();
        }else{
            response.sendRedirect(url + "/users/cart");
        }
    }

}
