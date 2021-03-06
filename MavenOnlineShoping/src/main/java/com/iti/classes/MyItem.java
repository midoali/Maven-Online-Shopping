/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iti.classes;

import com.iti.dtos.Product;
import com.iti.dtos.Receipt;

/**
 *
 * @author Yousef
 */
public class MyItem {
    private Product product;
    private int quantity;
    private double price;

    public MyItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.price = quantity*product.getPrice();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.price = this.quantity*product.getPrice();
    }

    public double getPrice() {
        return price;
    }

    
    
    
}
