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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nour
 */
public class CreditDAO extends DBHandler {

    private PreparedStatement preparedStatement;

    public CreditDAO() {
        new DBHandler();
    }

    public boolean checkCode(int code) {
        try {
            ResultSet resultSet;
            preparedStatement = connection.prepareStatement("SELECT * FROM CREDIT WHERE CODE=?");
            preparedStatement.setInt(1, code);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreditDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public int getCredit(int code) {
        try {
            ResultSet resultSet;
            preparedStatement = connection.prepareStatement("SELECT * FROM CREDIT WHERE CODE=?");
            preparedStatement.setInt(1, code);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int available = resultSet.getInt("AVAILABLE");
                if (available == 1) {
                    int credit = resultSet.getInt("VALUE");
                    return credit;
                } else {
                    return 0;
                }
            } else {
                return -1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreditDAO.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    public void setUnavailable(int code) {
        try {
            preparedStatement = connection.prepareStatement("UPDATE CREDIT SET AVAILABLE=? WHERE CODE=?");
            preparedStatement.setInt(1, 0);
            preparedStatement.setInt(2, code);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CreditDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
