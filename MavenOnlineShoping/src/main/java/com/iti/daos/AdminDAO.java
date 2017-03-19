/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iti.daos;

import com.iti.dtos.Customer;
import com.iti.dtos.Receipt;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
        String selectQuery = "SELECT NAME, BIRTHDAY,JOB, EMAIL, CREDIT, PHONE, ID, PASSWORD FROM CUSTOMER";
        try {
//            pst = connection.prepareStatement("SELECT NAME, Birthday, password,job, email,credit, phone, id from CUSTOMER", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            if (connection != null) {
                pst = connection.prepareStatement(selectQuery);
                rs = pst.executeQuery();

                while (rs.next()) {
                    Customer customerObj = new Customer();
                    customerObj.setName(rs.getString(1));
                    customerObj.setBirthday(rs.getDate(2));
                    customerObj.setJob(rs.getString(3));
                    customerObj.setEmail(rs.getString(4));
                    customerObj.setCredit(rs.getInt(5));
                    customerObj.setPhone(rs.getInt(6));
                    customerObj.setId(rs.getInt(7));
                    customerObj.setPassword(rs.getString(8));

                    customerList.add(customerObj);
                }
                for (int i = 0; i < customerList.size(); i++) {
                    System.out.println("customerList.get(i).getId()  " + i + "  " + customerList.get(i).getId());
                }
            }
        } catch (SQLException ex) {
            System.out.println("Selection Failed");
        }

        return customerList;
    }

    public Vector<Receipt> getCustomerReceipt(Receipt receiptObj) {
        String selectQuery = "SELECT ORDER_DATE, TOTAL_PRICE FROM RECEIPT WHERE CUSTOMER_ID='" + receiptObj.getCustomerId() + "' ";
        Vector<Receipt> receiptVector = new Vector<>();
        try {
            if (connection != null) {
                pst = connection.prepareStatement(selectQuery);
                rs = pst.executeQuery();

                while (rs.next()) {

                    Receipt receipt = new Receipt();
                    receipt.setDate(rs.getDate(1));
                    receipt.setTotalCost(rs.getInt(2));

                    receiptVector.add(receipt);
                }
                for (int i = 0; i < receiptVector.size(); i++) {
                    System.out.println("receiptVector.get(i).getId()  " + i + "  " + receiptVector.get(i).getTotalCost());
                }
            }
        } catch (SQLException ex) {
            System.out.println("Selection Failed");
        }
        return receiptVector;
    }

}
