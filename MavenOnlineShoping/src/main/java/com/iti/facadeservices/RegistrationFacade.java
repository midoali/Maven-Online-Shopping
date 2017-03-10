/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iti.facadeservices;

import com.iti.daos.UserDAO;
import com.iti.dtos.User;

/**
 *
 * @author fatma
 */
public class RegistrationFacade {

    boolean regFlag = false;

    public boolean register(User userObj) {

        UserDAO userDAO = new UserDAO();

        regFlag = userDAO.addUser(userObj);
        System.out.println("RegistrationFacade " + regFlag);
        return regFlag;
    }
}
