/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iti.daos;

import com.iti.dtos.Cart;
import com.iti.dtos.Customer;
import com.iti.dtos.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MIDO
 */
public class CartDAO extends DBHandler {
    private PreparedStatement preparedStatement;

    public CartDAO() {
        new DBHandler();
    }
    
     public boolean addCart(int c) {

        try {
            preparedStatement = connection.prepareStatement("insert into CART (CUSTOMER_ID) values(?)");
           
            preparedStatement.setInt(1, c);
            int addedRows = preparedStatement.executeUpdate();
            return addedRows > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
     
     public int geCarttId(int custId) {
        int id = 0;
        String selectQuery = "SELECT id FROM CART WHERE CUSTOMER_ID=?";
        try {
            preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setInt(1, custId);
            ResultSet rs;

            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
              //  System.out.println("id " + id + " name " + custObj.getName() + "pass: " + custObj.getPassword());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("getIdMethod Exception:");
        }
        return id;
    }

    }


