package com.iti.daos.datasource.c3p0;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSource {

    private static DataSource datasource;
    private final ComboPooledDataSource cpds;
    private final String dbUser = "mydbuser";
    private final String dbPass = "mydbuser";

    private DataSource() throws IOException, SQLException, PropertyVetoException {
        cpds = new ComboPooledDataSource();
        cpds.setDriverClass("oracle.jdbc.driver.OracleDriver"); //loads the jdbc driver
        cpds.setJdbcUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
        cpds.setUser(dbUser);
        cpds.setPassword(dbPass);

        // the settings below are optional -- c3p0 can work with defaults
        cpds.setMinPoolSize(5);
        cpds.setAcquireIncrement(5);
        cpds.setMaxPoolSize(20);
        cpds.setMaxStatements(180);

    }

    public static DataSource getInstance() throws IOException, SQLException, PropertyVetoException {
        if (datasource == null) {
            datasource = new DataSource();
            return datasource;
        } else {
            return datasource;
        }
    }

    public Connection getConnection() throws SQLException {
        return this.cpds.getConnection();
    }

}