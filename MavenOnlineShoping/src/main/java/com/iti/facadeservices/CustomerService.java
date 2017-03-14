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
     * ******************Nour Start
     *
     **************
     * @param c
     * @return
     */
    public boolean updateCustomer(Customer c) {
        CustomerDAO customerDAO = new CustomerDAO();
        boolean result = customerDAO.updateCustomer(c);
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
    boolean flag = false;

    public boolean checkValidate(String name, String pass) {

        Customer userObj = new Customer(name, pass);
        CustomerDAO userDAO = new CustomerDAO();
        System.out.println("checkValidate : " + userObj.getName() + userObj.getPassword());

        flag = userDAO.checkExistance(userObj);
        System.out.println("checkExistance " + flag);

        return flag;
    }

    public Customer getCustomer() {
        CustomerDAO customerDAO = new CustomerDAO();

        return customerDAO.getCustomer();
    }

    public int getCustomerID(Customer custObj) {

        CustomerDAO customerDao = new CustomerDAO();
        int id = customerDao.getId(custObj);
        return id;
    }

    public Customer getCustomerInfo(int id) {
        Customer customerObj = new Customer();

        CustomerDAO customerDao = new CustomerDAO();
        customerObj = customerDao.getInfo(id);

//        System.out.println("getCustomerInfo " + customerObj.getName() + " id: " + customerObj.getId());
        return customerObj;
    }

    //
    boolean regFlag = false;

    public boolean register(Customer customerObj) {

        CustomerDAO customerDAO = new CustomerDAO();

        regFlag = customerDAO.addCustomer(customerObj);
        System.out.println("RegistrationFacade " + regFlag);
        return regFlag;
    }
    //

    public void updateInfo(Customer cObj) {

        CustomerDAO customerDAO = new CustomerDAO();

        customerDAO.updateCustomer(cObj);
    }

    public boolean checkCustomerName(String name) {
        boolean flag = false;
        
        CustomerDAO customerDao= new CustomerDAO();
        flag=customerDao.checkName(name);
        
        return flag;

    }

    /**
     * *****************fatma end****************
     */
}
