package com.iti.daos;

import com.iti.daos.datasource.c3p0.DataSource;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
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
public class DBHandler implements DBHandlerInt{

    protected Connection connection;
    
    public DBHandler() {
        connect();
    }
    
    @Override
    public final void connect() {
        try {
            connection  = DataSource.getInstance().getConnection();
        } catch (IOException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void disConnect() {
//        try {
////            connection.close();
//            System.out.println("Connection Closed");
//        } catch (SQLException ex) {
//            System.out.println("Connection Failed!");
//        }
    }

    
}
