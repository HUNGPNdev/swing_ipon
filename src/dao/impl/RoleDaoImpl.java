/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.InterfaceDAO;
import entity.RoleEntity;
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
public class RoleDaoImpl implements InterfaceDAO<RoleEntity, Integer>{
    
    private Connection con;

    public RoleDaoImpl(Connection con) {
        this.con = con;
    }

    public RoleDaoImpl() {
    }
    
    

    @Override
    public List<RoleEntity> getAll() {
        List<RoleEntity> list = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from `role`");
            while(rs.next()) {
                list.add(new RoleEntity(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public RoleEntity getById(Integer id) {
        RoleEntity c = null;
        try {
            PreparedStatement pst = con.prepareStatement("select * from `role` where id = ?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if(rs.next()) {
                c = new RoleEntity(rs.getInt(1), rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    @Override
    public void insert(RoleEntity t) {
        try {
            PreparedStatement pst = con.prepareStatement("insert into `role` values(?,?)");
            pst.setInt(1, t.getId());
            pst.setString(2, t.getName());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(RoleEntity t) {
        try {
            PreparedStatement pst = con.prepareStatement("update `role` set name = ? where id = ?");
            pst.setString(1, t.getName());
            pst.setInt(2, t.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteById(Integer id) {
        try {
            PreparedStatement pst = con.prepareStatement("delete from `role` where id = ?");
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<RoleEntity> search(String name) {
        List<RoleEntity> list = new ArrayList<>();
        try {
            PreparedStatement pst = con.prepareStatement("select * from `role` where name like ?");
            pst.setString(1, "%"+name+"%");
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                list.add(new RoleEntity(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
}