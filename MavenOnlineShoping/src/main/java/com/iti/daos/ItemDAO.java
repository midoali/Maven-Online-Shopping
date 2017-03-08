/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iti.daos;

import com.iti.dtos.Item;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nour
 */
public class ItemDAO extends DBHandler{

    private PreparedStatement preparedStatement;

    public ItemDAO() {
        new DBHandler();
    }

    public boolean addItem(Item item) {
        try {
            preparedStatement=connection.prepareStatement("insert into ITEM (RECEIPT_ID,PRODUCT_ID,PRICE,QUANTITY) values(?,?,?,?)");
            preparedStatement.setInt(0,item.getReceiptId());
            preparedStatement.setInt(1,item.getProductId());
            preparedStatement.setDouble(2,item.getPrice());
            preparedStatement.setInt(3,item.getQuantity());
            int addedRows=preparedStatement.executeUpdate();
            return addedRows>0;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public Vector<Item> getItemsOfReceipt(int receiptId) {
       try {
            ResultSet resultSet;
            Vector<Item> items=new Vector<>();
            preparedStatement=connection.prepareStatement("select * from ITEM where RECEIPT_ID="+receiptId,ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next())
            {
                Item item=new Item();
                item.setReceiptId(resultSet.getInt("RECEIPT_ID"));
                item.setProductId(resultSet.getInt("PRODUCT_ID"));
                item.setPrice(resultSet.getDouble("PRICE"));
                item.setQuantity(resultSet.getInt("QUANTITY"));
                items.addElement(item);
            }
            return items;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
