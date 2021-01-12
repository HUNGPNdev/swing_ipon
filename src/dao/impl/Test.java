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
        CouponDaoImpl coup = new CouponDaoImpl(con);
//        CouponEntity c = coup.getById("1");
//        c.setTotal_price(2222);
//        System.out.println(c);
System.out.println(coup.getAll());
    }
    
}
