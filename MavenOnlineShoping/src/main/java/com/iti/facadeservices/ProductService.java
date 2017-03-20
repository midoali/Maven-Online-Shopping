/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iti.facadeservices;

import com.iti.daos.CategoryDAO;
import com.iti.daos.ProductDAO;
import com.iti.dtos.Category;
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
        productDAO.addProduct(product);
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
    
    public Vector<Product> getProductsByKeyword(String keyWord) {
        ProductDAO productDAO = new ProductDAO();
        Vector<Product> result = productDAO.getProductsByKeyword(keyWord);
        productDAO.disConnect();
        return result;
    }
    
    public Vector<Product> getProductsByCategory(int categoryId) {
        ProductDAO productDAO = new ProductDAO();
        Vector<Product> result = productDAO.getProductsByCategory(categoryId);
        productDAO.disConnect();
        return result;
    }
    
    public Boolean deleteProduct(int id) {
        ProductDAO pDao = new ProductDAO();
        return pDao.deleteProduct(id);
    }
    public Vector<Product> getProductsTestData() {
        ProductDAO productDAO = new ProductDAO();
        Vector<Product> result = productDAO.getProductsTest();
        productDAO.disConnect();
        return result;
    }

    public Vector<Product> getProductsByCategory(int categoryId, int lastId) {
        ProductDAO productDAO = new ProductDAO();
        Vector<Product> result = productDAO.getProductsByCategory(categoryId,lastId);
        productDAO.disConnect();
        return result;
    }

    public Vector<Product> getAllProducts(int lastId) {
        ProductDAO productDAO = new ProductDAO();
        Vector<Product> result = productDAO.getAllProducts(lastId);
        productDAO.disConnect();
        return result;
    }
    
    public Vector<Category> getAllCategories(){
        CategoryDAO categoryDAO = new CategoryDAO();
        Vector<Category> result = categoryDAO.getAllCategories();
        categoryDAO.disConnect();
        return result;
    }

    public Vector<Product> searchProducts(int categoryId, String[] brands, int lowerBoundPrice, int upperBoundPrice,String keyword) {
        ProductDAO productDAO = new ProductDAO();
        Vector<Product> result = productDAO.searchProducts(categoryId,brands,lowerBoundPrice,upperBoundPrice,keyword);
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
