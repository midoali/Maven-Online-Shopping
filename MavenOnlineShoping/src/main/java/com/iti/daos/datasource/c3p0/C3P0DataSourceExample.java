package com.iti.daos.datasource.c3p0;

import com.iti.daos.ProductDAO;
import com.iti.dtos.Product;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class C3P0DataSourceExample {

    public static void main(String[] args) throws PropertyVetoException, SQLException, IOException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        Vector<Product> products  = new ProductDAO().getAllProducts();
        System.out.println("length of products : "+products.size());
    }
}