/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import entity.RoleEntity;
import java.util.Calendar;
import java.util.List;
import java.sql.Connection;


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
        RoleDaoImpl drole = new RoleDaoImpl(con);
        EmployeeDaoImpl demp = new EmployeeDaoImpl(con);
        
        
        
        System.out.println(drole.getAll());
    }
    
}
