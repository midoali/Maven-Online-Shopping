package com.iti.daos;

import com.iti.dtos.User;
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
public class UserDAO extends DBHandler {

    private PreparedStatement pst;
    private ResultSet rs;

    public UserDAO() {
        new DBHandler();
    }

    public boolean addUser(User userObj) {
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
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        String addQuery = "INSERT INTO Customer (id,name, birthday, password,job, email,credit, phone, address) values('" + nextRowId + "', ?,?,?,?,?,?,?,?)";

        try {

            pst = connection.prepareStatement(addQuery);

            pst.setString(1, userObj.getName());
            pst.setDate(2, Date.valueOf(userObj.getBirthday()));
            pst.setString(3, userObj.getPassword());
            pst.setString(4, userObj.getJob());
            pst.setString(5, userObj.getEmail());
            pst.setInt(6, userObj.getCredit());
            pst.setInt(7, userObj.getPhone());
            pst.setString(8, userObj.getAddress());

            int rowNo = pst.executeUpdate();
            addFlag = true;
            System.out.println("Insertion Done!" + rowNo + " row");
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return addFlag;
    }

    public User getUser(User userObj) {

        String selectQuery = "SELECT USERNAME, Birthday, password,job, email,credit, phone from USER";
        try {
            pst = connection.prepareStatement(selectQuery);
            rs = pst.executeQuery();
            while (rs.next()) {
                String uName = rs.getString(1);
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
        return userObj;
    }

    public void deleteUser(User userObj) {
        try {

            pst = connection.prepareStatement("DELETE FROM EMP where EMPNO='" + userObj.getId() + "' ");
            pst.executeUpdate();
            System.out.println("row Deleted Successfully!");

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean checkExistance(User userObj) {
        boolean flag = false;

        String selectQuery = "SELECT NAME, PASSWORD FROM CUSTOMER WHERE NAME=? AND PASSWORD=? ";
        try {
            pst = connection.prepareStatement(selectQuery);
            pst.setString(1, userObj.getName());
            pst.setString(2, userObj.getPassword());

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
