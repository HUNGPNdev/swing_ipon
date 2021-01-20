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

    public void insert(Bill_proEntity t) {
        try {
            PreparedStatement pst = con.prepareStatement("insert into pro_bill(pro_id, bill_id, count) values(?,?,?)");
            pst.setInt(1, t.getPro_id());
            pst.setInt(2, t.getBill_id());
            pst.setInt(3, t.getCount());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Em_RoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Bill_proEntity getByBillPro(Bill_proEntity bp) {
        try {
            PreparedStatement pst = con.prepareStatement("select * from pro_bill where bill_id=? and pro_id=?");
            pst.setInt(1, bp.getBill_id());
            pst.setInt(2, bp.getPro_id());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new Bill_proEntity(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pro_billDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean getByPro_id(int pro_id) {
        try {
            PreparedStatement pst = con.prepareStatement("select * from pro_bill where pro_id=?");
            pst.setInt(1, pro_id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Em_RoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<Bill_proEntity> getByBill_Id(int bill_id) {
        List<Bill_proEntity> list = new ArrayList<>();
        try {
            PreparedStatement pst = con.prepareStatement("select * from pro_bill where bill_id=?");
            pst.setInt(1, bill_id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Bill_proEntity(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4)));
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

    public void delete(int bill_id) {
        try {
            PreparedStatement pst = con.prepareStatement("delete from pro_bill where bill_id=?");
            pst.setInt(1, bill_id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Em_RoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteByBill_Id(int bill_id, int pro_id) {
        try {
            PreparedStatement pst = con.prepareStatement("delete from pro_bill where bill_id=? and pro_id=?");
            pst.setInt(1, bill_id);
            pst.setInt(2, pro_id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Em_RoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Bill_proEntity t) {
        try {
            Bill_proEntity bp = this.getByBillPro(t);
            bp.setCount(bp.getCount() + t.getCount());
            PreparedStatement pst = con.prepareStatement("update pro_bill set count=? where pro_id=? and bill_id=?");
            pst.setInt(1, bp.getCount());
            pst.setInt(2, t.getPro_id());
            pst.setInt(3, t.getBill_id());
            pst.executeUpdate();
            Bill_proEntity bp2 = this.getByBillPro(t);
            if (bp2.getCount() == 0) {
                this.delete(bp2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Em_RoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
