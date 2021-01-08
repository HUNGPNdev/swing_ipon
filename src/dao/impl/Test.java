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
        EmployeeDaoImpl em = new EmployeeDaoImpl(con);
        Em_RoleDaoImpl er = new Em_RoleDaoImpl(con);
//        List<Em_RoleEntity> list = new ArrayList<>();
//        list.add(new Em_RoleEntity(2, 2));
//        list.add(new Em_RoleEntity(2, 3));
//        er.update(list);
        System.out.println(em.findByUsername("vana"));
//        System.out.println(er.getByUser_id(2));
    }
    
}
