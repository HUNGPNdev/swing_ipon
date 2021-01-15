/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.InterfaceDAO;
import entity.CategoryEntity;
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
import static org.eclipse.persistence.platform.database.oracle.plsql.OraclePLSQLTypes.Int;

/**
 *
 * @author Lenovo
 */
public class CategoryDaoImpl implements InterfaceDAO<CategoryEntity, Integer> {

    private Connection con;

    public CategoryDaoImpl(Connection con) {
        this.con = con;
    }

    public CategoryDaoImpl() {
    }

    @Override
    public List<CategoryEntity> getAll() {
        List<CategoryEntity> list = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from category");
            while (rs.next()) {
                CategoryEntity c = new CategoryEntity(rs.getInt(1), rs.getString(2));
                list.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public CategoryEntity getById(Integer id) {
        CategoryEntity c = null;
        try {
            PreparedStatement pst = con.prepareStatement("select * from category where id = ?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                c = new CategoryEntity(rs.getInt(1), rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    @Override
    public void insert(CategoryEntity t) {
        try {
            PreparedStatement pst = con.prepareStatement("insert into category values(?,?)");
            pst.setInt(1, t.getId());
            pst.setString(2, t.getName());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(CategoryEntity t) {
        try {
            PreparedStatement pst = con.prepareStatement("update category set name=? where id = ?");
            pst.setString(1, t.getName());
            pst.setInt(2, t.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteById(Integer id) {
        try {
            PreparedStatement pst = con.prepareStatement("delete from category where id = ?");
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<CategoryEntity> search(String name) {
        List<CategoryEntity> list = new ArrayList<>();
        try {
            PreparedStatement pst = con.prepareStatement("select * from category where name like ?");
            pst.setString(1, "%" + name + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new CategoryEntity(rs.getInt("id"), rs.getString("name")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public int totalCategoryBill() {
        Boolean check  =  false ;
        ArrayList<Integer> arrcate = new ArrayList<>();
        ProductDaoImpl productDaoImpl = new ProductDaoImpl(con);
        PreparedStatement pst;
        try {
            pst = con.prepareStatement("SELECT * FROM pro_bill");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                for (Integer i : arrcate) {
                    if (i == productDaoImpl.getById(rs.getInt(1)).getCate_id()) {
                        check  = true;
                        break;
                    }
                }
                if(!check){
                    arrcate.add(productDaoImpl.getById(rs.getInt(1)).getCate_id());
                }else {
                    check = false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrcate.size();
    }
}
