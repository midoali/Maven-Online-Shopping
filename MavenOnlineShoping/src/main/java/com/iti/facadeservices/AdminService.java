/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iti.facadeservices;

import com.iti.daos.AdminDAO;
import com.iti.dtos.Customer;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author fatma
 */
public class AdminService {
    
    Vector<Customer> custVector;
    
    public Vector<Customer> getCustomers() {
        
        AdminDAO adminDAO = new AdminDAO();
        custVector = adminDAO.getCustomerData();

        return custVector;
    }
}
