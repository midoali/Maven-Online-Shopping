///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.iti.facadeservices;
//
//
//import com.iti.daos.CustomerDAO;
//import com.iti.dtos.Customer;
//
//
///**
// *
// * @author fatma
// */
//public class LoginFacade {
//    boolean flag = false;
//    public boolean checkValidate(String name, String pass) {
//
//        Customer customerObj = new Customer(name, pass);
//        CustomerDAO customerDAO = new CustomerDAO();
//        System.out.println("checkValidate : " + customerObj.getName() + customerObj.getPassword());
//
//        flag = customerDAO.checkExistance(customerObj);
//        
//        System.out.println("checkExistance " + flag);
//
//        return flag;
//    }
//   
//    public Customer getCustomer(){
//        CustomerDAO customerDAO = new CustomerDAO();
//        return customerDAO.getCustomer();
//    }
//}
