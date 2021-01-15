/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.InterfaceDAO;
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
public class Em_RoleDaoImpl {

    private Connection con;

    public Em_RoleDaoImpl(Connection con) {
        this.con = con;
    }

    private Em_RoleDaoImpl() {
    }

    ;
    
    public void insert(List<Em_RoleEntity> list) {
        try {
            for (Em_RoleEntity t : list) {
                PreparedStatement pst = con.prepareStatement("insert into em_role(em_id, role_id) values(?,?)");
                pst.setInt(1, t.getEm_id());
                pst.setInt(2, t.getRole_id());
                pst.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Em_RoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Em_RoleEntity> getByUser_id(int user_id) {
        List<Em_RoleEntity> list = new ArrayList<>();
        try {
            PreparedStatement pst = con.prepareStatement("select * from em_role where em_id=?");
            pst.setInt(1, user_id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Em_RoleEntity(rs.getInt(1), rs.getInt(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Em_RoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public void deleteAll(int em_id) {
        try {
            PreparedStatement pst = con.prepareStatement("delete from em_role where em_id = ?");
            pst.setInt(1, em_id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Em_RoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       public void deleteAllRole(int role_id) {
        try {
            PreparedStatement pst = con.prepareStatement("delete from em_role where role_id = ?");
            pst.setInt(1, role_id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Em_RoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Em_RoleEntity t) {
        try {
            PreparedStatement pst = con.prepareStatement("delete from em_role where em_id=? and role_id=?");
            pst.setInt(1, t.getEm_id());
            pst.setInt(2, t.getRole_id());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Em_RoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(List<Em_RoleEntity> list) {
        int id = list.get(0).getEm_id();
        try {
            PreparedStatement pst = con.prepareStatement("delete from em_role where em_id=?");
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Em_RoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Em_RoleEntity t: list) {
            try {
                PreparedStatement pst = con.prepareStatement("insert into em_role(em_id, role_id) values(?,?)");
                if(t.getRole_id() != 0) {
                    pst.setInt(1, t.getEm_id());
                    pst.setInt(2, t.getRole_id());
                    pst.executeUpdate();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Em_RoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
