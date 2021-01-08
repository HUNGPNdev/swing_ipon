/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.InterfaceDAO;
import entity.EmployeeEntity;
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
public class EmployeeDaoImpl implements InterfaceDAO<EmployeeEntity, Integer>{
    private Connection con;

    public EmployeeDaoImpl() {
    }

    public EmployeeDaoImpl(Connection con) {
        this.con = con;
    }

    @Override
    public List<EmployeeEntity> getAll() {
        List<EmployeeEntity> list = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from employee");
            while(rs.next()) {
                EmployeeEntity c = new EmployeeEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5));
                list.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public EmployeeEntity checkLogin(String username, String password) {
        try {
            PreparedStatement pst = con.prepareStatement("select * from employee where username = ? and password = ?");
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new EmployeeEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public EmployeeEntity getById(Integer id) {
        EmployeeEntity c = null;
        try {
            PreparedStatement pst = con.prepareStatement("select * from employee where id = ?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if(rs.next()) {
                c = new EmployeeEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    @Override
    public void insert(EmployeeEntity t) {
        try {
            PreparedStatement pst = con.prepareStatement("insert into employee values(?,?,?,?,?)");
            pst.setInt(1, t.getId());
            pst.setString(2, t.getFullname());
            pst.setString(3, t.getUsername());
            pst.setString(4, t.getPassword());
            pst.setBoolean(5, t.isStatus());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(EmployeeEntity t) {
        try {
            PreparedStatement pst = con.prepareStatement("update employee set fullname=?, username=?,password=?,status=? where id = ?");
            pst.setString(1, t.getFullname());
            pst.setString(2, t.getUsername());
            pst.setString(3, t.getPassword());
            pst.setBoolean(4, t.isStatus());
            pst.setInt(5, t.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteById(Integer id) {
        try {
            PreparedStatement pst = con.prepareStatement("delete from employee where id = ?");
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public EmployeeEntity findByUsername(String username) {
        for(EmployeeEntity e: getAll()) {
            if(e.getUsername().equals(username)) {
                return e;
            }
        }
        return null;
    } 

    @Override
    public List<EmployeeEntity> search(String name) {
        List<EmployeeEntity> list = new ArrayList<>();
        try {
            PreparedStatement pst = con.prepareStatement("select * from employee where fullname like ?");
            pst.setString(1, "%"+name+"%");
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                list.add(new EmployeeEntity(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getBoolean(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    
}
