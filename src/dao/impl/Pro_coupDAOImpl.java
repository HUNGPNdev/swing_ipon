/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import entity.Bill_proEntity;
import entity.ProductEntity;
import entity.Pro_id_count;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */

public final class Pro_coupDAOImpl{
    
    public static List<ProductEntity> listPro = new ArrayList<>();
    
    public static List<Bill_proEntity> allBill_Pro = new ArrayList<>();
    
    public static List<Pro_id_count> pro_id_count = new ArrayList<>();
    
    public List<ProductEntity> getListPro() {
        return listPro;
    }

    public void setListPro(List<ProductEntity> listPro) {
        this.listPro = listPro;
    }
    
    public void setListProByBill_id(List<Bill_proEntity> listPro) {
        this.allBill_Pro = listPro;
    }
}
