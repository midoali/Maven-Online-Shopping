/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iti.facadeservices;

import com.iti.daos.ProductDAO;
import com.iti.dtos.Product;
import java.util.Vector;

/**
 *
 * @author MIDO
 */
public class ProductService {

    /**
     * ******************Nour Start
     *
     **************
     * @return
     */
    public Vector<Product> getAllProducts() {
        ProductDAO productDAO = new ProductDAO();
        Vector<Product> result = productDAO.getAllProducts();
        productDAO.disConnect();
        return result;
    }

    public boolean updateProduct(Product product) {
        ProductDAO productDAO = new ProductDAO();
        boolean result = productDAO.updateProduct(product);
        productDAO.disConnect();
        return result;
    }
    
    public void addProduct(Product product)
    {
        ProductDAO productDAO = new ProductDAO();
        productDAO.updateProduct(product);
        productDAO.disConnect();
    }

    /**
     * *****************nour end****************
     */
    /**
     * ******************ahmed Start**************
     */
    public Product getSingleProduct(int id) {
        ProductDAO pDao = new ProductDAO();
        Product p= pDao.getSingleProduct(id);
        pDao.disConnect();
        return p;
    }

    /**
     * *****************ahmed end****************
     */
    /**
     * ******************youssef Start**************
     */
    public Vector<Product> getProductsTestData() {
        ProductDAO productDAO = new ProductDAO();
        Vector<Product> result = productDAO.getProductsTest();
        productDAO.disConnect();
        return result;
    }
    /**
     * *****************youssef end****************
     */
    /**
     * ******************fatma Start**************
     */
    /**
     * *****************fatma end****************
     */
}
