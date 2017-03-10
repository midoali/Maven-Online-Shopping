/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iti.daos;

import com.iti.dtos.Product;
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
public class ProductDAO extends DBHandler{

    private PreparedStatement preparedStatement;

    public ProductDAO() {
        new DBHandler();
    }

    public boolean addProduct(Product p) {
        
        try {
            preparedStatement=connection.prepareStatement("insert into PRODUCT (TYPE,BRAND,PRICE,QUANTITY,DESCRIPTION,IMAGE,COLOR) values(?,?,?,?,?,?,?)");
            preparedStatement.setString(0,p.getType());
            preparedStatement.setString(1,p.getBrand());
            preparedStatement.setDouble(2,p.getPrice());
            preparedStatement.setInt(3,p.getQuantity());
            preparedStatement.setString(4,p.getDescription());
            preparedStatement.setString(5,p.getImagePath());
            preparedStatement.setString(6,p.getColor());
            int addedRows=preparedStatement.executeUpdate();
            return addedRows>0;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean deleteProduct(Product p) {
        try {
            preparedStatement=connection.prepareStatement("delete from PRODUCT where ID =?");
            preparedStatement.setInt(0, p.getId());
            int addedRows=preparedStatement.executeUpdate();
            return addedRows>0;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean updateProduct(Product p) {
        try {
            preparedStatement=connection.prepareStatement("update PRODUCT set TYPE=? ,BRAND=? ,PRICE=? ,QUANTITY=? ,DESCRIPTION=? ,IMAGE=? ,COLOR=? where ID=?");
            preparedStatement.setString(0,p.getType());
            preparedStatement.setString(1,p.getBrand());
            preparedStatement.setDouble(2,p.getPrice());
            preparedStatement.setInt(3,p.getQuantity());
            preparedStatement.setString(4,p.getDescription());
            preparedStatement.setString(5,p.getImagePath());
            preparedStatement.setString(6,p.getColor());
            preparedStatement.setInt(7,p.getId());
            int addedRows=preparedStatement.executeUpdate();
            return addedRows>0;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public Vector<Product> getAllProducts() {
        try {
            ResultSet resultSet;
            Vector<Product> products=new Vector<>();
            preparedStatement=connection.prepareStatement("select * from PRODUCT",ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next())
            {
                Product product=new Product();
                product.setId(resultSet.getInt("ID"));
                product.setType(resultSet.getString("TYPE"));
                product.setPrice(resultSet.getDouble("PRICE"));
                product.setBrand(resultSet.getString("BRAND"));
                product.setQuantity(resultSet.getInt("QUANTITY"));
                product.setColor(resultSet.getString("COLOR"));
                product.setDescription(resultSet.getString("DESCRIPTION"));
                product.setImagePath(resultSet.getString("iMAGE"));
                products.addElement(product);
            }
            return products;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public Product getSingleProduct(String id){
        int productId=Integer.parseInt(id);
        
     try {
         Product product=new Product();
            ResultSet resultSet;
            preparedStatement=connection.prepareStatement("select * from \"PRODUCT\" where ID=" + productId + "",ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next())
            {
                product.setId(resultSet.getInt("ID"));
                product.setType(resultSet.getString("TYPE"));
                product.setPrice(resultSet.getDouble("PRICE"));
                product.setBrand(resultSet.getString("BRAND"));
                product.setQuantity(resultSet.getInt("QUANTITY"));
                product.setColor(resultSet.getString("COLOR"));
                product.setDescription(resultSet.getString("DESCRIPTION"));
                product.setImagePath(resultSet.getString("iMAGE"));
            }
            return product;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
