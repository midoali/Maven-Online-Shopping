/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iti.classes;

import com.iti.classes.MyItem;
import java.util.ArrayList;

/**
 *
 * @author Yousef
 */
public class MyShoppingCart {
    private ArrayList<MyItem> items = new ArrayList<>();
    
    public double getTotalCost(){
        double totalPrice = 0;
        for(MyItem item : items){
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }
    public ArrayList<MyItem> getItems() {
        return items;
    }
    
    public void buy(){
        
    }
    
}
