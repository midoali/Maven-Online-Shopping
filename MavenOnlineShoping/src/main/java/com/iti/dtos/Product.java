/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iti.dtos;

/**
 *
 * @author Nour
 */
public class Product {
    private int id;
    private int categoryId;
    private String type;
    private String brand;
    private double price;
    private int quantity;
    private String description;
    private String imagePath;
    private String color;

    public Product() {
        id=0;
        type=new String();
        brand=new String();
        price=0.0;
        quantity=0;
        categoryId=0;
        description=new String();
        imagePath=new String();
        color=new String();
    }
    
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", categoryId=" + categoryId + ", type=" + type + ", brand=" + brand + ", price=" + price + ", quantity=" + quantity + ", description=" + description + ", imagePath=" + imagePath + ", color=" + color + '}';
    }
    
}
