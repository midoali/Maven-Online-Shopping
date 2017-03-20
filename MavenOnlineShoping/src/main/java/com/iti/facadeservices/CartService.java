/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iti.facadeservices;

import com.iti.classes.MyItem;
import com.iti.daos.CartDAO;
import com.iti.daos.CartItemDAO;
import com.iti.daos.ProductDAO;
import com.iti.dtos.Cart;
import com.iti.dtos.CartItem;
import com.iti.dtos.Product;
import java.util.Vector;

/**
 *
 * @author MIDO
 */
public class CartService {
     public void addCart(int c)
    {
        CartDAO cartDAO = new CartDAO();
        cartDAO.addCart(c);
        cartDAO.disConnect();
    }
  public int getCart(int c)
    {
        CartDAO cartDAO = new CartDAO();
        int id=cartDAO.geCarttId(c);
        cartDAO.disConnect();
        return id;
    }
  
  public Vector<MyItem> getCartItmes(int c_id)
    {
        Vector MyItems =new Vector<>();
        CartItemDAO cartItemDAO = new CartItemDAO();
        MyItems =cartItemDAO.getCartItems(c_id);
        cartItemDAO.disConnect();
        return MyItems;
    }
    public boolean addItem(CartItem cartItem) {
                CartItemDAO cartItemDAO = new CartItemDAO();
                boolean chceck=cartItemDAO.addItem(cartItem);
                cartItemDAO.disConnect();
                return  chceck;
    }
    public boolean deleteCartItem(int productId,int cartId){
                CartItemDAO cartItemDAO = new CartItemDAO();
                boolean chceck=cartItemDAO.deleteCartItem(productId,cartId);
                cartItemDAO.disConnect();
                return  chceck;
    }
     public boolean clearCart(int cartId){
                CartItemDAO cartItemDAO = new CartItemDAO();
                boolean chceck=cartItemDAO.clearCart(cartId);
                cartItemDAO.disConnect();
                return  chceck;
    }
}
