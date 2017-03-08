/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iti.daos;

import com.iti.dtos.Item;
import com.iti.dtos.Receipt;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nour
 */
public class ReceiptDAO extends DBHandler{

    private PreparedStatement preparedStatement;

    public ReceiptDAO() {
        new DBHandler();
    }

    public boolean addReceipt(Receipt receipt) {
        
        try {
            preparedStatement=connection.prepareStatement("insert into RECEIPT (ORDER_DATE,CUSTOMER_ID,TOTAL_COST) values(?,?,?)");
            preparedStatement.setDate(0,receipt.getDate());
            preparedStatement.setInt(1,receipt.getCustomerId());
            preparedStatement.setDouble(2,receipt.getTotalCost());
            int addedRows=preparedStatement.executeUpdate();
            addItems(receipt);
            return addedRows>0;
        } catch (SQLException ex) {
            Logger.getLogger(ReceiptDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public Vector<Receipt> getAllReceipts() {
        try {
            ResultSet resultSet;
            Vector<Receipt> receipts=new Vector<>();
            preparedStatement=connection.prepareStatement("select * from RECEIPT",ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next())
            {
                Receipt receipt=new Receipt();
                receipt.setId(resultSet.getInt("ID"));
                receipt.setCustomerId(resultSet.getInt("CUSTOMER_ID"));
                receipt.setDate(resultSet.getDate("ORDER_DATE"));
                receipt.setTotalCost(resultSet.getDouble("TOTAL_COST"));
                receipts.addElement(receipt);
            }
            return receipts;
        } catch (SQLException ex) {
            Logger.getLogger(ReceiptDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private void addItems(Receipt receipt) {
        int receiptId=getID(receipt);
        ItemDAO idao=new ItemDAO();
        for(Item item :receipt.getItems())
        {
            item.setReceiptId(receiptId);
            idao.addItem(item);
        }
    }

    private int getID(Receipt receipt) {
        try {
            ResultSet resultSet;
            preparedStatement=connection.prepareStatement("select ID from RECEIPT where CUSTOMER_ID=? and ORDER_DATE=?",ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setInt(0, receipt.getCustomerId());
            preparedStatement.setDate(1, receipt.getDate());
            resultSet=preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt("ID");
        } catch (SQLException ex) {
            Logger.getLogger(ReceiptDAO.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
}
