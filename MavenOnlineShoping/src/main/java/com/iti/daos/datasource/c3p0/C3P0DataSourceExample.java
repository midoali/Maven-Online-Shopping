package com.iti.daos.datasource.c3p0;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class C3P0DataSourceExample {

    public static void main(String[] args) throws PropertyVetoException, SQLException, IOException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DataSource.getInstance().getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from emp3");
              while (resultSet.next()) {
                  System.out.println("employeeid: " + resultSet.getString("first_name"));
                  System.out.println("employeename: " + resultSet.getString("last_name"));
              }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) try { resultSet.close(); } catch (SQLException e) {e.printStackTrace();}
            if (statement != null) try { statement.close(); } catch (SQLException e) {e.printStackTrace();}
            if (connection != null) try { connection.close(); } catch (SQLException e) {e.printStackTrace();}
        }
    }
}