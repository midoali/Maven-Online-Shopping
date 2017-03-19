/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iti.dtos;

import java.sql.Date;
import java.util.Vector;

/**
 *
 * @author Nour
 */
public class Receipt {

    private int id;
    private int customerId;
    private Date date;
    private double totalCost;
    private Vector<Item> items;

    public Receipt() {
        id = 0;
        customerId = 0;
        date = getDate();
        totalCost = 0.0;
        items = new Vector<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public Vector<Item> getItems() {
        return items;
    }

    public void setItems(Vector<Item> items) {
        this.items = items;
    }

    public void calculateTotalCost() {
        for (Item item : items) {
            this.totalCost += item.getPrice() * item.getQuantity();
        }
    }
}
