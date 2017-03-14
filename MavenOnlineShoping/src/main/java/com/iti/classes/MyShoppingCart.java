/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iti.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Yousef
 */
public class MyShoppingCart {
    private HashMap<String,MyItem> items = new HashMap<>();
    
    public double getTotalCost(){
        double totalPrice = 0;
        for(Map.Entry<String,MyItem> entry : items.entrySet()){
            totalPrice += entry.getValue().getPrice();
        }
        return totalPrice;
    }
    public HashMap<String,MyItem> getItems() {
        return items;
    }
    
    public void buy(){
        
    }
    
}
