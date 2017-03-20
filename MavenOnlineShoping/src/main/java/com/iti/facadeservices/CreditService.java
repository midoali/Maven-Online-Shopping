/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iti.facadeservices;

import com.iti.daos.CreditDAO;
import com.iti.dtos.Customer;

/**
 *
 * @author Nour
 */
public class CreditService {

    public String checkCode(int code) {
        CreditDAO creditDAO = new CreditDAO();
        boolean result = creditDAO.checkCode(code);
        creditDAO.disConnect();
        if (result) {
            return "valid";
        } else {
            return "invalid";
        }
    }

    public int getCredit(int code) {
        CreditDAO creditDAO = new CreditDAO();
        int credit = creditDAO.getCredit(code);
        creditDAO.setUnavailable(code);
        creditDAO.disConnect();
        return credit;
    }
}
