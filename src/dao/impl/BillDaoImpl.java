/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.InterfaceDAO;
import entity.BillEntity;
import entity.Bill_proEntity;
import entity.Pro_id_count;
import entity.ProductEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class BillDaoImpl{
    
    private Connection con;

    public BillDaoImpl(Connection con) {
        this.con = con;
    }

    public BillDaoImpl() {
    }
    
    public List<BillEntity> getAll() {
        List<BillEntity> list = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from bill");
            while(rs.next()) {
                list.add(new BillEntity(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDouble(4), rs.getDate(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public BillEntity getById(Integer id) {
        try {
            PreparedStatement pst = con.prepareStatement("select * from bill where id =?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if(rs.next()) {
                return new BillEntity(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDouble(4), rs.getDate(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
//int id, int em_id, String client_name, double total_price, Date date_create
    public void insert(BillEntity t, List<Pro_id_count> pro_id_count) {
        try {
            ProductDaoImpl dpro = new ProductDaoImpl(con);
            double price = 0;
            if(pro_id_count.size() > 0) {
                for(Pro_id_count p: pro_id_count) {
                    price += dpro.getById(p.getPro_id()).getPrice() * p.getCount();
                }
            }
            PreparedStatement pst = con.prepareStatement("insert into bill values(?,?,?,?,?)");
            pst.setInt(1, t.getId());
            pst.setInt(2, t.getEm_id());
            pst.setString(3, t.getClient_name());
            pst.setDouble(4, price);
            pst.setDate(5, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(BillDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Integer getMaxId() {
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(ID) FROM bill");
            if(rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public void update(BillEntity t) {
        try {
            ProductDaoImpl dpro = new ProductDaoImpl(con);
            double price = 0;
            Pro_billDaoImpl dpb = new Pro_billDaoImpl(con);
            for(Bill_proEntity bpe: dpb.getByBill_Id(t.getId())) {
                price += dpro.getById(bpe.getPro_id()).getPrice() * bpe.getCount();
            }
            PreparedStatement pst = con.prepareStatement("update bill set em_id=?,client_name=?,total_price=?,date_create=? where id=?");
            pst.setInt(1, t.getEm_id());
            pst.setString(2, t.getClient_name());
            pst.setDouble(3, price);
            pst.setDate(4, t.getDate_create());
            pst.setInt(5, t.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BillDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteById(Integer id) {
        try {
            PreparedStatement pst = con.prepareStatement("delete from bill where id = ?");
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BillDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<BillEntity> search(String name) {
        List<BillEntity> list = new ArrayList<>();
        try {
            PreparedStatement pst = con.prepareStatement("select * from bill where client_name like ?");
            pst.setString(1, "%"+name+"%");
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                list.add(new BillEntity(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDouble(4), rs.getDate(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
}
