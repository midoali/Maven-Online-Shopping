/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iti.facadeservices;


import com.iti.daos.CustomerDAO;
import com.iti.dtos.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 *
 * @author fatma
 */
public class LoginFacade {
    boolean flag = false;
    public boolean checkValidate(String name, String pass) {

        Customer userObj = new Customer(name, pass);
        CustomerDAO userDAO = new CustomerDAO();
        System.out.println("checkValidate : " + userObj.getName() + userObj.getPassword());

        flag = userDAO.checkExistance(userObj);
        System.out.println("checkExistance " + flag);

        return flag;
    }
}
