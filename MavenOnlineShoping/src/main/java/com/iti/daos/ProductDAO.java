/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iti.daos;

import com.iti.daos.datasource.c3p0.DataSource;
import com.iti.dtos.Product;
import java.beans.PropertyVetoException;
import java.io.IOException;
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
public class ProductDAO extends DBHandler {

    private PreparedStatement preparedStatement;

    public ProductDAO() {
        new DBHandler();
    }

    public Vector<Product> getProductsTest() {
        try {
            ResultSet resultSet;
            Vector<Product> products = new Vector<>();
            preparedStatement = connection.prepareStatement("select * from PRODUCT where quantity < 9", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("ID"));
                product.setType(resultSet.getString("TYPE"));
                product.setPrice(resultSet.getDouble("PRICE"));
                product.setBrand(resultSet.getString("BRAND"));
                product.setCategoryId(resultSet.getInt("CATEGORY_ID"));
                product.setQuantity(resultSet.getInt("QUANTITY"));
                product.setColor(resultSet.getString("COLOR"));
                product.setDescription(resultSet.getString("DESCRIPTION"));
                product.setImagePath(resultSet.getString("iMAGE"));
                products.addElement(product);
            }
            resultSet.close();
            return products;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean addProduct(Product p) {

        try {
            preparedStatement = connection.prepareStatement("insert into PRODUCT (TYPE,BRAND,PRICE,QUANTITY,DESCRIPTION,IMAGE,COLOR,CATEGORY_ID) values(?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1, p.getType());
            preparedStatement.setString(2, p.getBrand());
            preparedStatement.setDouble(3, p.getPrice());
            preparedStatement.setInt(4, p.getQuantity());
            preparedStatement.setString(5, p.getDescription());
            preparedStatement.setString(6, p.getImagePath());
            preparedStatement.setString(7, p.getColor());
            preparedStatement.setInt(8, p.getCategoryId());
            int addedRows = preparedStatement.executeUpdate();
            return addedRows > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean deleteProduct(Product p) {
        try {
            preparedStatement = connection.prepareStatement("delete from PRODUCT where ID =?");
            preparedStatement.setInt(1, p.getId());
            int addedRows = preparedStatement.executeUpdate();
            return addedRows > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean deleteProduct(int id) {
        try {
            preparedStatement = connection.prepareStatement("delete from PRODUCT where ID =" + id);
            int addedRows = preparedStatement.executeUpdate();
            return addedRows > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean updateProduct(Product p) {
        try {
            preparedStatement = connection.prepareStatement("update PRODUCT set TYPE=? ,BRAND=? ,PRICE=? ,QUANTITY=? ,DESCRIPTION=? ,IMAGE=? ,COLOR=? ,CATEGORY_ID=? where ID=?");
            preparedStatement.setString(1, p.getType());
            preparedStatement.setString(2, p.getBrand());
            preparedStatement.setDouble(3, p.getPrice());
            preparedStatement.setInt(4, p.getQuantity());
            preparedStatement.setString(5, p.getDescription());
            preparedStatement.setString(6, p.getImagePath());
            preparedStatement.setString(7, p.getColor());
            preparedStatement.setInt(8, p.getCategoryId());
            preparedStatement.setInt(9, p.getId());
            int addedRows = preparedStatement.executeUpdate();
            return addedRows > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public Vector<Product> getProductsByKeyword(String keyword) {
        try {
            ResultSet resultSet;
            Vector<Product> products = new Vector<>();

            preparedStatement = connection.prepareStatement("Select * from PRODUCT where brand like '%" + keyword + "%' or price like '%" + keyword + "%' or quantity like '%" + keyword + "%' or description like '%" + keyword + "%' or color like '%" + keyword + "%' or type like '%" + keyword + "%' order by id");
//            preparedStatement.setString(0,keyword);
//            preparedStatement.setString(1,keyword);
//            preparedStatement.setString(2,keyword);
//            preparedStatement.setString(3,keyword);
//            preparedStatement.setString(4,keyword);
//            preparedStatement.setString(5,keyword);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("ID"));
                product.setType(resultSet.getString("TYPE"));
                product.setCategoryId(resultSet.getInt("CATEGORY_ID"));
                product.setPrice(resultSet.getDouble("PRICE"));
                product.setBrand(resultSet.getString("BRAND"));
                product.setQuantity(resultSet.getInt("QUANTITY"));
                product.setColor(resultSet.getString("COLOR"));
                product.setDescription(resultSet.getString("DESCRIPTION"));
                product.setImagePath(resultSet.getString("iMAGE"));
                products.addElement(product);
//            }
            }
            return products;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return null;
    }

    public Vector<Product> getAllProducts() {
        try {
            ResultSet resultSet;
            Vector<Product> products = new Vector<>();

//            connection  = DataSource.getInstance().getConnection();
            if (connection != null) {
                preparedStatement = connection.prepareStatement("select * from PRODUCT");
                System.out.println("get all function ");
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Product product = new Product();
                    product.setId(resultSet.getInt("ID"));
                    product.setType(resultSet.getString("TYPE"));
                    product.setCategoryId(resultSet.getInt("CATEGORY_ID"));
                    product.setPrice(resultSet.getDouble("PRICE"));
                    product.setBrand(resultSet.getString("BRAND"));
                    product.setQuantity(resultSet.getInt("QUANTITY"));
                    product.setColor(resultSet.getString("COLOR"));
                    product.setDescription(resultSet.getString("DESCRIPTION"));
                    product.setImagePath(resultSet.getString("iMAGE"));
                    products.addElement(product);
                }

                return products;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return null;
    }

    public Product getSingleProduct(int productId) {
        try {
            Product product = new Product();
            ResultSet resultSet;
            preparedStatement = connection.prepareStatement("select * from \"PRODUCT\" where ID=" + productId + "", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                product.setId(resultSet.getInt("ID"));
                product.setType(resultSet.getString("TYPE"));
                product.setPrice(resultSet.getDouble("PRICE"));
                product.setCategoryId(resultSet.getInt("CATEGORY_ID"));
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

    public Vector<Product> getProductsByCategory(int categoryId) {
        try {
            ResultSet resultSet;
            Vector<Product> products = new Vector<>();
            String sqlQuery = "Select * from PRODUCT where category_id = " + categoryId + " order by id desc";
            preparedStatement = connection.prepareStatement(sqlQuery);
            System.out.println(sqlQuery);
//
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("ID"));
                product.setType(resultSet.getString("TYPE"));
                product.setPrice(resultSet.getDouble("PRICE"));
                product.setBrand(resultSet.getString("BRAND"));
                product.setQuantity(resultSet.getInt("QUANTITY"));
                product.setColor(resultSet.getString("COLOR"));
                product.setDescription(resultSet.getString("DESCRIPTION"));
                product.setImagePath(resultSet.getString("iMAGE"));
                products.addElement(product);
//            }
            }
            return products;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return null;
    }
}
