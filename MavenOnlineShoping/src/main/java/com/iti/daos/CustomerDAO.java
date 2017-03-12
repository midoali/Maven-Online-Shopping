package com.iti.daos;

import com.iti.dtos.Customer;
import com.iti.dtos.Product;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author fatma
 */
public class CustomerDAO extends DBHandler {

    private PreparedStatement pst;
    private ResultSet rs;

    public CustomerDAO() {
        new DBHandler();
    }

    public boolean addCustomer(Customer customerObj) {
        boolean addFlag = false;
        int nextRowId = 0;
        String nextId = "select customer_id_seq.nextval from dual";
        try {
            pst = connection.prepareStatement(nextId);
            rs = pst.executeQuery();
            if (rs.next()) {
                nextRowId = rs.getInt(1);
            }
            System.out.println("nextId " + nextId + " " + rs.getInt(1));
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        String addQuery = "INSERT INTO Customer (name, birthday, password,job, email,credit, phone, address) values(?,?,?,?,?,?,?,?)";

        try {

            pst = connection.prepareStatement(addQuery);

            pst.setString(1, customerObj.getName());
            pst.setDate(2, Date.valueOf(customerObj.getBirthday()));
            pst.setString(3, customerObj.getPassword());
            pst.setString(4, customerObj.getJob());
            pst.setString(5, customerObj.getEmail());
            pst.setInt(6, customerObj.getCredit());
            pst.setInt(7, customerObj.getPhone());
            pst.setString(8, customerObj.getAddress());

            int rowNo = pst.executeUpdate();
            addFlag = true;
            System.out.println("Insertion Done!" + rowNo + " row");
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return addFlag;
    }
    
     public boolean updateCustomer(Customer customer) {
        try {
            pst=connection.prepareStatement("update CUSTOMER set NAME=? ,BIRTHDAY=? ,PASSWORD=? ,JOB=? ,EMAIL=? ,CREDIT=? ,PHONE=?,ADDRESS=? where ID=?");
            pst.setString(0,customer.getName());
            pst.setDate(1,Date.valueOf(customer.getBirthday()));
            pst.setString(2,customer.getPassword());
            pst.setString(3,customer.getJob());
            pst.setString(4,customer.getEmail());
            pst.setInt(5,customer.getCredit());
            pst.setInt(6,customer.getPhone());
            pst.setString(7,customer.getAddress());
            pst.setInt(8,customer.getId());
            int addedRows=pst.executeUpdate();
            return addedRows>0;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public Customer getCustomer() {
        Customer customerObj = new Customer();
        String selectQuery = "SELECT NAME, Birthday, password,job, email,credit, phone from CUSTOMER";
        try {
            pst = connection.prepareStatement(selectQuery);
            rs = pst.executeQuery();
            
            while (rs.next()) {
                String uName = rs.getString(1);
                customerObj.setName(uName);
                String uBirthday = rs.getString(2);
                String uPassword = rs.getString(3);
                String uJob = rs.getString(4);
                String uEmail = rs.getString(5);
                String uCredit = rs.getString(6);
                String uPhone = rs.getString(7);

            }
        } catch (SQLException ex) {
            System.out.println("Selection Successed");
        }
        return customerObj;
    }

    public void deleteCustomer(Customer customerObj) {
        try {

            pst = connection.prepareStatement("DELETE FROM customer where id='" + customerObj.getId() + "' ");
            pst.executeUpdate();
            System.out.println("row Deleted Successfully!");

        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean checkExistance(Customer customerObj) {
        boolean flag = false;

        String selectQuery = "SELECT NAME, PASSWORD FROM CUSTOMER WHERE NAME=? AND PASSWORD=? ";
        try {
            pst = connection.prepareStatement(selectQuery);
            pst.setString(1, customerObj.getName());
            pst.setString(2, customerObj.getPassword());

            rs = pst.executeQuery();
            while (rs.next()) {
                flag = true;
                System.out.println("name " + rs.getString(1) + "pass: " + (rs.getString(2)));
            }
        } catch (SQLException ex) {
            System.out.println("Connection Started");
        }

        return flag;
    }

}
