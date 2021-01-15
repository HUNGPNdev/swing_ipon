/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.InterfaceDAO;
import entity.BillEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class BillDaoImpl implements InterfaceDAO<BillEntity, Integer> {

    private Connection con;

    public BillDaoImpl(Connection con) {
        this.con = con;
    }

    public BillDaoImpl() {
    }

    @Override
    public List<BillEntity> getAll() {
        List<BillEntity> list = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from bill");
            while (rs.next()) {
                list.add(new BillEntity(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDouble(4), rs.getDate(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public BillEntity getById(Integer id) {
        try {
            PreparedStatement pst = con.prepareStatement("select * from bill where id =?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new BillEntity(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDouble(4), rs.getDate(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
//int id, int em_id, String client_name, double total_price, Date date_create

    @Override
    public void insert(BillEntity t) {
        try {
            PreparedStatement pst = con.prepareStatement("insert into bill values(?,?,?,?,?)");
            pst.setInt(1, t.getId());
            pst.setInt(2, t.getEm_id());
            pst.setString(3, t.getClient_name());
            pst.setDouble(4, t.getTotal_price());
            pst.setDate(5, t.getDate_create());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BillDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(BillEntity t) {
        try {
            PreparedStatement pst = con.prepareStatement("update bill set em_id=?,client_name=?,total_price=?,date_create=? where id=?");
            pst.setInt(1, t.getEm_id());
            pst.setString(2, t.getClient_name());
            pst.setDouble(3, t.getTotal_price());
            pst.setDate(4, t.getDate_create());
            pst.setInt(5, t.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BillDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteById(Integer id) {
        try {
            PreparedStatement pst = con.prepareStatement("delete from bill where id = ?");
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BillDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<BillEntity> search(String name) {
        List<BillEntity> list = new ArrayList<>();
        try {
            PreparedStatement pst = con.prepareStatement("select * from bill where client_name like ?");
            pst.setString(1, "%" + name + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new BillEntity(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDouble(4), rs.getDate(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public int totalBill() {
        PreparedStatement pst;
        int tong = 0;
        try {
            pst = con.prepareStatement("SELECT COUNT(*) FROM bill");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                tong = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tong;
    }

    public int totalProBill() {
        PreparedStatement pst;
        PreparedStatement pstt;
        int tongOld = 0;
        int tongNow = 0;
        try {
            pst = con.prepareStatement("SELECT * FROM product");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                tongOld += rs.getInt(4);
                System.out.println(tongOld);
            }

            pstt = con.prepareStatement("SELECT * FROM product");
            ResultSet rss = pstt.executeQuery();
            while (rss.next()) {
                tongNow = rss.getInt(5);
                   System.out.println(tongNow);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tongOld - tongNow;
    }
    
        public int totalMoneyBill() {
        PreparedStatement pst;
        int tong = 0;
        try {
            pst = con.prepareStatement("SELECT * FROM bill");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                tong += rs.getInt(4);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tong;
    }
}
