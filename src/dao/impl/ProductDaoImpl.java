/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.InterfaceDAO;
import entity.ProductEntity;
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
public class ProductDaoImpl implements InterfaceDAO<ProductEntity, Integer> {

    private Connection con;

    public ProductDaoImpl(Connection con) {
        this.con = con;
    }

    public ProductDaoImpl() {
    }

    @Override
    public List<ProductEntity> getAll() {
        List<ProductEntity> list = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from product");
            while (rs.next()) {
                ProductEntity c = new ProductEntity(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getDouble(6), rs.getString(7));
                list.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public ProductEntity getById(Integer id) {
        try {
            PreparedStatement pst = con.prepareStatement("select * from product where id = ?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new ProductEntity(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getDouble(6), rs.getString(7));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<ProductEntity> getProByCoupon_id(String id) {
        List<ProductEntity> listPro = new ArrayList<>();
        try {
            PreparedStatement pst = con.prepareStatement("select * from product where cou_id = ?");
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                listPro.add(new ProductEntity(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getDouble(6), rs.getString(7)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listPro;
    }

    @Override
    public void insert(ProductEntity t) {
        try {
            PreparedStatement pst = con.prepareStatement("insert into product(name, cate_id, old_count, now_count, price, cou_id) values(?,?,?,?,?,?)");
            pst.setString(1, t.getName());
            pst.setInt(2, t.getCate_id());
            pst.setInt(3, t.getOld_count());
            pst.setInt(4, t.getOld_count());
            pst.setDouble(5, t.getPrice());
            pst.setString(6, t.getCou_id());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(ProductEntity t) {
        try {
            PreparedStatement pst = con.prepareStatement("update product set name=?, cate_id=?, old_count=?, now_count=?, price=?, cou_id=? where id=?");
            pst.setString(1, t.getName());
            pst.setInt(2, t.getCate_id());
            pst.setInt(3, t.getOld_count());
            pst.setInt(4, t.getNow_count());
            pst.setDouble(5, t.getPrice());
            pst.setString(6, t.getCou_id());
            pst.setInt(7, t.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateCount(int pro_id, int count) {
        try {
            ProductEntity p = this.getById(pro_id);
            p.setNow_count(p.getNow_count() - count);
            PreparedStatement pst =  con.prepareStatement("update product set now_count=? where id=?");
            pst.setInt(2, pro_id);
            pst.setInt(1, p.getNow_count());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteById(Integer id) {
        try {
            PreparedStatement pst = con.prepareStatement("delete from product where id = ?");
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteByCate_id(Integer id) {
        try {
            PreparedStatement pst = con.prepareStatement("delete from product where cate_id = ?");
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//int id, String name, int cate_id, int old_count, int now_count, double price, String cou_id

    @Override
    public List<ProductEntity> search(String name) {
        List<ProductEntity> list = new ArrayList<>();
        try {
            PreparedStatement pst = con.prepareStatement("select * from product where name like ?");
            pst.setString(1, "%"+name+"%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new ProductEntity(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getDouble(6), rs.getString(7)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public int totalPro() {
        int tong = 0;
        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM product");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                tong += rs.getInt(5);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tong;
    }
}
