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
     * ******************Nour Start**************
     * @return 
     */
    public Vector<Product> getAllProducts()
    {
        ProductDAO productDAO=new ProductDAO();
        Vector<Product> result=productDAO.getAllProducts();
        productDAO.disConnect();
        return result;
    }
    /**
     * *****************nour end****************
     */
    /**
     * ******************ahmed Start**************
     */
    /**
     * *****************ahmed end****************
     */
    /**
     * ******************youssef Start**************
     */
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