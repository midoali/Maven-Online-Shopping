package com.iti.daos.datasource.c3p0;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import oracle.jdbc.pool.OracleDataSource;

public class DataSource {
    private static DataSource instance;
    private static javax.sql.DataSource datasource;
    private final String dbUser = "mydbuser";
    private final String dbPass = "mydbuser";
    private static OracleDataSource ds;

    private DataSource() throws IOException, SQLException, PropertyVetoException {
        ds = new OracleDataSource();
        ds.setURL("jdbc:oracle:thin:@127.0.0.1:1521:xe");
    }
    
//
    public static DataSource getInstance() throws IOException, SQLException, PropertyVetoException {
        if (instance == null) {
            instance = new DataSource();
            return instance;
        } else {
            return instance;
        }
    }

    public Connection getConnection() throws SQLException, NamingException {
        Connection conn = ds.getConnection(dbUser, dbPass);
        return conn;
    }

}
