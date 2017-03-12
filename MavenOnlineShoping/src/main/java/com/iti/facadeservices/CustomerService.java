/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iti.facadeservices;

import com.iti.daos.CustomerDAO;
import com.iti.dtos.Customer;

/**
 *
 * @author Nour
 */
public class CustomerService {
    /**
     * ******************Nour Start**************
     * @param c
     * @return 
     */
    public boolean updateCustomer(Customer c)
    {
        CustomerDAO customerDAO=new CustomerDAO();
        boolean result=customerDAO.updateCustomer(c);
        customerDAO.disConnect();
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
