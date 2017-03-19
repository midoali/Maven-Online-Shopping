/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iti.daos;

import com.iti.classes.MyItem;
import com.iti.dtos.CartItem;
import com.iti.dtos.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MIDO
 */
public class CartItemDAO extends DBHandler{
     private PreparedStatement preparedStatement;
     ProductDAO pdao=new ProductDAO();

    public CartItemDAO() {
        new DBHandler();
    }
    public Vector<MyItem> getCartItems(int cartId) {
        try {
            ResultSet resultSet;
            Vector<MyItem> myItems = new Vector<>();

//            connection  = DataSource.getInstance().getConnection();
            if (connection != null) {
                preparedStatement = connection.prepareStatement("select * from CART_ITEM where CART_ID="+cartId);
              //  System.out.println("get all function  ");
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int pId=resultSet.getInt("PRODUCT_ID");
                    int quantity=resultSet.getInt("QUANTITY");
                    Product product =new Product();
                    product=pdao.getSingleProduct(pId);
                    
                    MyItem item = new MyItem(product, quantity);
                   
                    myItems.addElement(item);
                }
                pdao.disConnect();
                return myItems;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return null;
    }
  public boolean addItem(CartItem p) {

        try {
            preparedStatement = connection.prepareStatement("insert into CART_ITEM (CART_ID,PRODUCT_ID,QUANTITY) values(?,?,?)");
            preparedStatement.setInt(1, p.getCartId());
            preparedStatement.setInt(2, p.getProductId());
            preparedStatement.setInt(3, p.getQuantity());
              int addedRows = preparedStatement.executeUpdate();
            return addedRows > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean deleteCartItem(int productId,int cartId) {
        try {
            preparedStatement = connection.prepareStatement("delete from CART_ITEM where CART_ID =? and PRODUCT_ID=?");
            preparedStatement.setInt(1, cartId);
            preparedStatement.setInt(2, productId);

            int addedRows = preparedStatement.executeUpdate();
            return addedRows > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
     public boolean clearCart(int cartId) {
        try {
            preparedStatement = connection.prepareStatement("delete from CART_ITEM where CART_ID =? ");
            preparedStatement.setInt(1, cartId);

            int addedRows = preparedStatement.executeUpdate();
            return addedRows > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

//    public boolean deleteProduct(int id) {
//        try {
//            preparedStatement = connection.prepareStatement("delete from PRODUCT where ID =" + id);
//            int addedRows = preparedStatement.executeUpdate();
//            return addedRows > 0;
//        } catch (SQLException ex) {
//            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
//            return false;
//        }
//    }
    
}
