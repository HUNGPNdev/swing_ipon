/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import entity.Bill_proEntity;
import entity.Em_RoleEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class Pro_billDaoImpl {
    private Connection con;

    public Pro_billDaoImpl(Connection con) {
        this.con = con;
    }

    public Pro_billDaoImpl() {
    }
    
    public void insert(List<Bill_proEntity> list) {
        try {
            for (Bill_proEntity t : list) {
                PreparedStatement pst = con.prepareStatement("insert into pro_bill(pro_id, bill_id) values(?,?)");
                pst.setInt(1, t.getPro_id());
                pst.setInt(2, t.getBill_id());
                pst.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Em_RoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Bill_proEntity> getByBill_Id(int bill_id) {
        List<Bill_proEntity> list = new ArrayList<>();
        try {
            PreparedStatement pst = con.prepareStatement("select * from pro_bill where bill_id=?");
            pst.setInt(1, bill_id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Bill_proEntity(rs.getInt(1), rs.getInt(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Em_RoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public void delete(Bill_proEntity t) {
        try {
            PreparedStatement pst = con.prepareStatement("delete from pro_bill where pro_id=? and bill_id=?");
            pst.setInt(1, t.getPro_id());
            pst.setInt(2, t.getBill_id());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Em_RoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(List<Bill_proEntity> list) {
        int id = list.get(0).getBill_id();
        try {
            PreparedStatement pst = con.prepareStatement("delete from pro_bill where bill_id=?");
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Em_RoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Bill_proEntity t: list) {
            try {
                PreparedStatement pst = con.prepareStatement("insert into pro_bill(pro_id, bill_id) values(?,?)");
                if(t.getPro_id() != 0) {
                    pst.setInt(1, t.getPro_id());
                    pst.setInt(2, t.getBill_id());
                    pst.executeUpdate();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Em_RoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
