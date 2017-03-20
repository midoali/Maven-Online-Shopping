/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iti.facadeservices;

import com.iti.daos.AdminDAO;
import com.iti.dtos.Customer;
import com.iti.dtos.Receipt;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author fatma
 */
public class AdminService {

    Vector<Customer> custVector;
    Vector<Receipt> reeciptVector;

    public Vector<Customer> getCustomers() {

        AdminDAO adminDAO = new AdminDAO();
        custVector = adminDAO.getCustomerData();

        return custVector;
    }

    public Vector<Receipt> getReceipt(Receipt receiptObj) {

        AdminDAO adminDAO = new AdminDAO();
        reeciptVector = adminDAO.getCustomerReceipt(receiptObj);

        return reeciptVector;
    }
}
