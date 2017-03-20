/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iti.daos;

import com.iti.dtos.Category;
import com.iti.dtos.Item;
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
public class CategoryDAO extends DBHandler{

    private PreparedStatement preparedStatement;

    public CategoryDAO() {
        new DBHandler();
    }

    public boolean addCategory(String CategoryName) {
        try {
            preparedStatement=connection.prepareStatement("insert into Categories (NAME) values('"+CategoryName+"')");
           
            int addedRows=preparedStatement.executeUpdate();
            return addedRows>0;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public Vector<Category> getAllCategories() {
       try {
            ResultSet resultSet;
            Vector<Category> categories = new Vector<>();
            preparedStatement=connection.prepareStatement("select * from CATEGORIES",ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next())
            {
                Category category=new Category();
                category.setId(resultSet.getInt("ID"));
                category.setName(resultSet.getString("NAME"));
                categories.add(category);
            }
            return categories;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
