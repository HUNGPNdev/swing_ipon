/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import entity.BillEntity;
import entity.Bill_proEntity;
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
        Pro_billDaoImpl dpb = new Pro_billDaoImpl(con);
        List<Bill_proEntity> pb = new ArrayList<>();
        pb.add(new Bill_proEntity(6, 1));
        dpb.update(pb);
        System.out.println(dpb.getByBill_Id(1));
    }
    
}
