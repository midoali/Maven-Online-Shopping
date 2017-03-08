/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iti.facadeservices;


import com.iti.daos.UserDAO;
import com.iti.dtos.User;
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

    protected Connection connection;
    protected Statement stm;
    protected String dbUser = "fatma";
    protected String dbPass = "fatma28";
    private PreparedStatement pst;
    private ResultSet rs;

    public boolean checkValidate(String name, String pass) {

        User userObj = new User(name, pass);
        UserDAO userDAO = new UserDAO();
        System.out.println("checkValidate : " + userObj.getName() + userObj.getPassword());

        flag = userDAO.checkExistance(userObj);
        System.out.println("checkExistance " + flag);

        return flag;
    }
}
