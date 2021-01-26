/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.CouponDAO;
import entity.CouponEntity;
import entity.ProductEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class CouponDaoImpl implements CouponDAO<CouponEntity, String> {

    private Connection con;

    ProductDaoImpl dpro = null;

    public CouponDaoImpl(Connection con) {
        this.con = con;
        dpro = new ProductDaoImpl(con);
    }

    public CouponDaoImpl() {
    }

    @Override
    public List<CouponEntity> getAll() {
        List<CouponEntity> list = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from coupon");
            while (rs.next()) {
                CouponEntity c = new CouponEntity(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getDouble(4), rs.getDate(5));
                list.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public CouponEntity getById(String id) {
        try {
            PreparedStatement pst = con.prepareStatement("select * from coupon where id = ?");
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new CouponEntity(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getDouble(4), rs.getDate(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void insert(CouponEntity t, List<ProductEntity> listPro) {
        try {
            PreparedStatement pst = con.prepareStatement("insert into coupon values(?,?,?,?,?)");
            pst.setString(1, t.getId());
            pst.setInt(2, t.getEm_id());
            pst.setString(3, t.getSupplier_name());
            pst.setDouble(4, t.getTotal_price());
            pst.setDate(5, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
            pst.executeUpdate();
            for (ProductEntity p : listPro) {
                p.setCou_id(t.getId());
                dpro.insert(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CouponDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(CouponEntity t, List<ProductEntity> listPro) {
        try {
            PreparedStatement pst = con.prepareStatement("update coupon set em_id=?, supplier_name=?, total_price=? where id = ?");
            pst.setInt(1, t.getEm_id());
            pst.setString(2, t.getSupplier_name());
            pst.setDouble(3, t.getTotal_price());
            pst.setString(4, t.getId());
            pst.executeUpdate();
            for (ProductEntity p : listPro) {
                if (p.getId() == 0) {
                    p.setCou_id(t.getId());
                    dpro.insert(p);
                } else {
                    dpro.update(p);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CouponDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteById(String id) {
        try {
            PreparedStatement pst = con.prepareStatement("delete from coupon where id = ?");
            pst.setString(1, id);
            PreparedStatement prost = con.prepareStatement("delete from product where cou_id = ?");
            prost.setString(1, id);
            prost.executeUpdate();
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<CouponEntity> search(String name) {
        List<CouponEntity> list = new ArrayList<>();
        try {
            PreparedStatement pst = con.prepareStatement("select * from coupon where supplier_name like ?");
            pst.setString(1, "%" + name + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new CouponEntity(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getDouble(4), rs.getDate(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public int totalCoupon() {
        PreparedStatement pst;
        int tong = 0;
        try {
            pst = con.prepareStatement("SELECT COUNT(*) FROM coupon");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                tong = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tong;
    }

    public int totalProCoupon() {
        PreparedStatement pst;
        int tong = 0;
        try {
            pst = con.prepareStatement("SELECT * FROM product");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                tong = rs.getInt(4);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tong;
    }

    public int totalMoneyCoupon() {
        PreparedStatement pst;
        int tong = 0;
        try {
            pst = con.prepareStatement("SELECT * FROM coupon");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                tong = rs.getInt(4);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tong;
    }

    public int totalCateCoupon() {
        Boolean check = false;
        ArrayList<Integer> arrcate = new ArrayList<>();
        ProductDaoImpl productDaoImpl = new ProductDaoImpl(con);
        PreparedStatement pst;
        try {
            pst = con.prepareStatement("SELECT * FROM product");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                for (Integer i : arrcate) {
                    if (i == rs.getInt("cate_id")) {
                        check = true;
                        break;
                    }
                }
                if (!check) {
                    arrcate.add(rs.getInt("cate_id"));
                } else {
                    check = false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrcate.size();
    }

    public ArrayList<Float> totalMoneyCouponWeek() {
        ArrayList<Float> arr = new ArrayList<>();
        PreparedStatement pst;
        PreparedStatement pst1;
        PreparedStatement pst2;
        PreparedStatement pst3;
        float tong = 0;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
            Calendar calendar = Calendar.getInstance();
            //
            pst = con.prepareStatement("SELECT * FROM coupon"
                    + " where date_create = ? or  date_create = ? or  date_create = ?  or  date_create = ? or  date_create = ? or  date_create = ? or  date_create = ? ");
            pst.setString(1, simpleDateFormat.format(calendar.getTime()) + "-01");
            pst.setString(2, simpleDateFormat.format(calendar.getTime()) + "-02");
            pst.setString(3, simpleDateFormat.format(calendar.getTime()) + "-03");
            pst.setString(4, simpleDateFormat.format(calendar.getTime()) + "-04");
            pst.setString(5, simpleDateFormat.format(calendar.getTime()) + "-05");
            pst.setString(6, simpleDateFormat.format(calendar.getTime()) + "-06");
            pst.setString(7, simpleDateFormat.format(calendar.getTime()) + "-07");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                tong += rs.getInt(4);
            }
            arr.add(tong);
            tong = 0;
            //
            pst1 = con.prepareStatement("SELECT * FROM coupon"
                    + " where date_create = ? or  date_create = ? or  date_create = ?  or  date_create = ? or  date_create = ? or  date_create = ? or  date_create = ? or  date_create = ? ");
            pst1.setString(1, simpleDateFormat.format(calendar.getTime()) + "-08");
            pst1.setString(2, simpleDateFormat.format(calendar.getTime()) + "-09");
            pst1.setString(3, simpleDateFormat.format(calendar.getTime()) + "-10");
            pst1.setString(4, simpleDateFormat.format(calendar.getTime()) + "-11");
            pst1.setString(5, simpleDateFormat.format(calendar.getTime()) + "-12");
            pst1.setString(6, simpleDateFormat.format(calendar.getTime()) + "-13");
            pst1.setString(7, simpleDateFormat.format(calendar.getTime()) + "-14");
            pst1.setString(8, simpleDateFormat.format(calendar.getTime()) + "-15");
            ResultSet rs1 = pst1.executeQuery();
            while (rs1.next()) {
                tong += rs1.getInt(4);
            }
            arr.add(tong);
            tong = 0;
            //
            pst2 = con.prepareStatement("SELECT * FROM coupon"
                    + " where date_create = ? or  date_create = ? or  date_create = ?  or  date_create = ? or  date_create = ? or  date_create = ? or  date_create = ?or  date_create = ? ");
            pst2.setString(1, simpleDateFormat.format(calendar.getTime()) + "-16");
            pst2.setString(2, simpleDateFormat.format(calendar.getTime()) + "-17");
            pst2.setString(3, simpleDateFormat.format(calendar.getTime()) + "-18");
            pst2.setString(4, simpleDateFormat.format(calendar.getTime()) + "-19");
            pst2.setString(5, simpleDateFormat.format(calendar.getTime()) + "-20");
            pst2.setString(6, simpleDateFormat.format(calendar.getTime()) + "-21");
            pst2.setString(7, simpleDateFormat.format(calendar.getTime()) + "-22");
            pst2.setString(8, simpleDateFormat.format(calendar.getTime()) + "-23");
            ResultSet rs2 = pst2.executeQuery();
            while (rs2.next()) {
                tong += rs2.getInt(4);
            }
            arr.add(tong);
            tong = 0;
            //
            pst3 = con.prepareStatement("SELECT * FROM coupon"
                    + " where date_create = ? or  date_create = ? or  date_create = ?  or  date_create = ? or  date_create = ? or  date_create = ? or  date_create = ? or  date_create = ? ");
            pst3.setString(1, simpleDateFormat.format(calendar.getTime()) + "-24");
            pst3.setString(2, simpleDateFormat.format(calendar.getTime()) + "-25");
            pst3.setString(3, simpleDateFormat.format(calendar.getTime()) + "-26");
            pst3.setString(4, simpleDateFormat.format(calendar.getTime()) + "-27");
            pst3.setString(5, simpleDateFormat.format(calendar.getTime()) + "-28");
            pst3.setString(6, simpleDateFormat.format(calendar.getTime()) + "-29");
            pst3.setString(7, simpleDateFormat.format(calendar.getTime()) + "-30");
            pst3.setString(8, simpleDateFormat.format(calendar.getTime()) + "-31");
            ResultSet rs3 = pst3.executeQuery();
            while (rs3.next()) {
                tong += rs3.getInt(4);
            }
            arr.add(tong);
            tong = 0;
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public ArrayList<Float> totalMoneyBillMonth() {
        ArrayList<Float> arr = new ArrayList<>();
        PreparedStatement pst;
        PreparedStatement pst1;
        PreparedStatement pst2;
        PreparedStatement pst3;
        PreparedStatement pst4;
        PreparedStatement pst5;
        PreparedStatement pst6;
        PreparedStatement pst7;
        PreparedStatement pst8;
        PreparedStatement pst9;
        PreparedStatement pst10;
        PreparedStatement pst11;

        float tong = 0;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
            Calendar calendar = Calendar.getInstance();
            //
            pst = con.prepareStatement("SELECT * FROM coupon"
                    + " where date_create LIKE ?");
            pst.setString(1, simpleDateFormat.format(calendar.getTime()) + "-01" + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                tong += rs.getInt(4);
            }
            arr.add(tong);
            tong = 0;
            //
            pst1 = con.prepareStatement("SELECT * FROM coupon"
                    + " where date_create  LIKE ?");
            pst1.setString(1, simpleDateFormat.format(calendar.getTime()) + "-02" + "%");
            ResultSet rs1 = pst1.executeQuery();
            while (rs1.next()) {
                tong += rs1.getInt(4);
            }
            arr.add(tong);
            tong = 0;
            //
            pst2 = con.prepareStatement("SELECT * FROM coupon"
                    + " where date_create LIKE ?");
            pst2.setString(1, simpleDateFormat.format(calendar.getTime()) + "-03" + "%");
            ResultSet rs2 = pst2.executeQuery();
            while (rs2.next()) {
                tong += rs2.getInt(4);
            }
            arr.add(tong);
            tong = 0;
            //
            pst3 = con.prepareStatement("SELECT * FROM coupon"
                    + " where date_create LIKE ? ");
            pst3.setString(1, simpleDateFormat.format(calendar.getTime()) + "-04" + "%");
            ResultSet rs3 = pst3.executeQuery();
            while (rs3.next()) {
                tong += rs3.getInt(4);
            }
            arr.add(tong);
            tong = 0;
            //
            pst4 = con.prepareStatement("SELECT * FROM coupon"
                    + " where date_create LIKE ? ");
            pst4.setString(1, simpleDateFormat.format(calendar.getTime()) + "-05" + "%");
            ResultSet rs4 = pst4.executeQuery();
            while (rs4.next()) {
                tong += rs4.getInt(4);
            }
            arr.add(tong);
            tong = 0;
            //
            pst5 = con.prepareStatement("SELECT * FROM coupon"
                    + " where date_create LIKE ? ");
            pst5.setString(1, simpleDateFormat.format(calendar.getTime()) + "-06" + "%");
            ResultSet rs5 = pst5.executeQuery();
            while (rs5.next()) {
                tong += rs5.getInt(4);
            }
            arr.add(tong);
            tong = 0;
            //
            pst6 = con.prepareStatement("SELECT * FROM coupon"
                    + " where date_create LIKE ? ");
            pst6.setString(1, simpleDateFormat.format(calendar.getTime()) + "-07" + "%");
            ResultSet rs6 = pst6.executeQuery();
            while (rs6.next()) {
                tong += rs6.getInt(4);
            }
            arr.add(tong);
            tong = 0;
            //
            pst7 = con.prepareStatement("SELECT * FROM coupon"
                    + " where date_create LIKE ? ");
            pst7.setString(1, simpleDateFormat.format(calendar.getTime()) + "-08" + "%");
            ResultSet rs7 = pst7.executeQuery();
            while (rs7.next()) {
                tong += rs7.getInt(4);
            }
            arr.add(tong);
            tong = 0;
            //
            pst8 = con.prepareStatement("SELECT * FROM coupon"
                    + " where date_create LIKE ? ");
            pst8.setString(1, simpleDateFormat.format(calendar.getTime()) + "-09" + "%");
            ResultSet rs8 = pst8.executeQuery();
            while (rs8.next()) {
                tong += (rs8.getInt(4));
            }
            arr.add(tong);
            tong = 0;
            //
            pst9 = con.prepareStatement("SELECT * FROM coupon"
                    + " where date_create LIKE ? ");
            pst9.setString(1, simpleDateFormat.format(calendar.getTime()) + "-10" + "%");
            ResultSet rs9 = pst9.executeQuery();
            while (rs9.next()) {
                tong += rs9.getInt(4);
            }
            arr.add(tong);
            tong = 0;
            //
            pst10 = con.prepareStatement("SELECT * FROM coupon"
                    + " where date_create LIKE ? ");
            pst10.setString(1, simpleDateFormat.format(calendar.getTime()) + "-11" + "%");
            ResultSet rs10 = pst10.executeQuery();
            while (rs10.next()) {
                tong += rs10.getInt(4);
            }
            arr.add(tong);
            tong = 0;
            //
            pst11 = con.prepareStatement("SELECT * FROM coupon"
                    + " where date_create LIKE ? ");
            pst11.setString(1, simpleDateFormat.format(calendar.getTime()) + "-12" + "%");
            ResultSet rs11 = pst11.executeQuery();
            while (rs11.next()) {
                tong += rs11.getInt(4);
            }
            arr.add(tong);
            tong = 0;
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
}
