/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iti.facadeservices;

import com.iti.daos.ReceiptDAO;
import com.iti.dtos.Receipt;

/**
 *
 * @author Nour
 */
public class ReceiptService {
    /**
     * ******************Nour Start**************
     * @param receipt
     * @return 
     */
    public boolean addReceipt(Receipt receipt)
    {
        ReceiptDAO receiptDAO=new ReceiptDAO();
        boolean result=receiptDAO.addReceipt(receipt);
        receiptDAO.disConnect();
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
    /**
     * *****************fatma end****************
     */
}
