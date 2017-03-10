/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iti.facadeservices;

import com.iti.daos.ProductDAO;
import com.iti.dtos.Product;

/**
 *
 * @author MIDO
 */
public class ProductFacade {
    public Product getSingleProduct(String id){
         ProductDAO pDao=new ProductDAO();
      return  pDao.getSingleProduct(id);
        
    }
}
