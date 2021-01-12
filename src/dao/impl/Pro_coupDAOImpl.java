/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import entity.ProductEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */

public final class Pro_coupDAOImpl{
    
    public static List<ProductEntity> listPro = new ArrayList<>();

    public List<ProductEntity> getListPro() {
        return listPro;
    }

    public void setListPro(List<ProductEntity> listPro) {
        this.listPro = listPro;
    }
    
}
