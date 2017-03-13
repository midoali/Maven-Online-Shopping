/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iti.daos;

import com.iti.dtos.Customer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author fatma
 */
public class AdminDAO extends DBHandler {

    private PreparedStatement pst;
    private ResultSet rs;
    Vector<Customer> customerList = new Vector<Customer>();

    public AdminDAO() {
        new DBHandler();
    }

    public Vector<Customer> getCustomerData() {

        
        String selectQuery = "SELECT NAME, BIRTHDAY, PASSWORD,JOB, EMAIL, CREDIT, PHONE, ID FROM CUSTOMER";
        try {
//            pst = connection.prepareStatement("SELECT NAME, Birthday, password,job, email,credit, phone, id from CUSTOMER", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            pst = connection.prepareStatement(selectQuery);
            rs = pst.executeQuery();

            while (rs.next()) {
                Customer customerObj = new Customer();
                customerObj.setName(rs.getString(1));
                customerObj.setBirthday(rs.getString(2));
                customerObj.setPassword(rs.getString(3));
                customerObj.setJob(rs.getString(4));
                customerObj.setEmail(rs.getString(5));
                customerObj.setCredit(rs.getInt(6));
                customerObj.setPhone(rs.getInt(7));
                customerObj.setId(rs.getInt(8));

                customerList.add(customerObj);
            }
            for (int i = 0; i < customerList.size(); i++) {
                System.out.println("customerList.get(i).getName()  " + i + "  " + customerList.get(i).getName());
            }
        } catch (SQLException ex) {
            System.out.println("Selection Failed");
        }

        return customerList;
    }
}
