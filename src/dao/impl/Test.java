/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import entity.BillEntity;
import entity.Bill_proEntity;
import entity.CouponEntity;
import entity.Em_RoleEntity;
import entity.RoleEntity;
import java.util.Calendar;
import java.util.List;
import java.sql.Connection;
import java.util.ArrayList;


/**
 *
 * @author Lenovo
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection con = DbConnection.getConnect();
        BillDaoImpl bill = new BillDaoImpl(con);
        Pro_billDaoImpl dpro = new Pro_billDaoImpl(con);
        System.out.println(dpro.getByPro_id(15));
    }
    
}
