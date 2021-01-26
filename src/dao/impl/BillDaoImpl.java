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
public class BillDaoImpl {

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
            while (rs.next()) {
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
            if (rs.next()) {
                return new BillEntity(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDouble(4), rs.getDate(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insert(BillEntity t, List<Pro_id_count> pro_id_count) {
        try {
            ProductDaoImpl dpro = new ProductDaoImpl(con);
            double price = 0;
            if (pro_id_count.size() > 0) {
                for (Pro_id_count p : pro_id_count) {
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
            if (rs.next()) {
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
            for (Bill_proEntity bpe : dpb.getByBill_Id(t.getId())) {
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
            }

            pstt = con.prepareStatement("SELECT * FROM product");
            ResultSet rss = pstt.executeQuery();
            while (rss.next()) {
                tongNow = rss.getInt(5);
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

    public ArrayList<Float> totalMoneyBillWeek() {
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
            pst = con.prepareStatement("SELECT * FROM bill"
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
                tong += (rs.getInt(4) * 0.05f);
            }
            arr.add(tong);
            tong = 0;
            //
            pst1 = con.prepareStatement("SELECT * FROM bill"
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
                tong += (rs1.getInt(4) * 0.05f);
            }
            arr.add(tong);
            tong = 0;
            //
            pst2 = con.prepareStatement("SELECT * FROM bill"
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
                tong += (rs2.getInt(4) * 0.05f);
            }
            arr.add(tong);
            tong = 0;
            //
            pst3 = con.prepareStatement("SELECT * FROM bill"
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
                tong += (rs3.getInt(4) * 0.05f);
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
            pst = con.prepareStatement("SELECT * FROM bill"
                    + " where date_create LIKE ?");
            pst.setString(1, simpleDateFormat.format(calendar.getTime()) + "-01" + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                tong += (rs.getInt(4) * 0.05f);
            }
            arr.add(tong);
            tong = 0;
            //
            pst1 = con.prepareStatement("SELECT * FROM bill"
                    + " where date_create  LIKE ?");
            pst1.setString(1, simpleDateFormat.format(calendar.getTime()) + "-02" + "%");
            ResultSet rs1 = pst1.executeQuery();
            while (rs1.next()) {
                tong += (rs1.getInt(4) * 0.05f);
            }
            arr.add(tong);
            tong = 0;
            //
            pst2 = con.prepareStatement("SELECT * FROM bill"
                    + " where date_create LIKE ?");
            pst2.setString(1, simpleDateFormat.format(calendar.getTime()) + "-03" + "%");
            ResultSet rs2 = pst2.executeQuery();
            while (rs2.next()) {
                tong += (rs2.getInt(4) * 0.05f);
            }
            arr.add(tong);
            tong = 0;
            //
            pst3 = con.prepareStatement("SELECT * FROM bill"
                    + " where date_create LIKE ? ");
            pst3.setString(1, simpleDateFormat.format(calendar.getTime()) + "-04" + "%");
            ResultSet rs3 = pst3.executeQuery();
            while (rs3.next()) {
             tong += (rs3.getInt(4) * 0.05f);
            }
            arr.add(tong);
            tong = 0;
            //
            pst4 = con.prepareStatement("SELECT * FROM bill"
                    + " where date_create LIKE ? ");
            pst4.setString(1, simpleDateFormat.format(calendar.getTime()) + "-05" + "%");
            ResultSet rs4 = pst4.executeQuery();
            while (rs4.next()) {
             tong += (rs4.getInt(4) * 0.05f);
            }
            arr.add(tong);
            tong = 0;
            //
            pst5 = con.prepareStatement("SELECT * FROM bill"
                    + " where date_create LIKE ? ");
            pst5.setString(1, simpleDateFormat.format(calendar.getTime()) + "-06" + "%");
            ResultSet rs5 = pst5.executeQuery();
            while (rs5.next()) {
               tong += (rs5.getInt(4) * 0.05f);
            }
            arr.add(tong);
            tong = 0;
            //
            pst6 = con.prepareStatement("SELECT * FROM bill"
                    + " where date_create LIKE ? ");
            pst6.setString(1, simpleDateFormat.format(calendar.getTime()) + "-07" + "%");
            ResultSet rs6 = pst6.executeQuery();
            while (rs6.next()) {
               tong += (rs6.getInt(4) * 0.05f);
            }
            arr.add(tong);
            tong = 0;
            //
            pst7 = con.prepareStatement("SELECT * FROM bill"
                    + " where date_create LIKE ? ");
            pst7.setString(1, simpleDateFormat.format(calendar.getTime()) + "-08" + "%");
            ResultSet rs7 = pst7.executeQuery();
            while (rs7.next()) {
               tong += (rs7.getInt(4) * 0.05f);
            }
            arr.add(tong);
            tong = 0;
            //
            pst8 = con.prepareStatement("SELECT * FROM bill"
                    + " where date_create LIKE ? ");
            pst8.setString(1, simpleDateFormat.format(calendar.getTime()) + "-09" + "%");
            ResultSet rs8 = pst8.executeQuery();
            while (rs8.next()) {
              tong += (rs8.getInt(4) * 0.05f);
            }
            arr.add(tong);
            tong = 0;
            //
            pst9 = con.prepareStatement("SELECT * FROM bill"
                    + " where date_create LIKE ? ");
            pst9.setString(1, simpleDateFormat.format(calendar.getTime()) + "-10" + "%");
            ResultSet rs9 = pst9.executeQuery();
            while (rs9.next()) {
               tong += (rs9.getInt(4) * 0.05f);
            }
            arr.add(tong);
            tong = 0;
            //
            pst10 = con.prepareStatement("SELECT * FROM bill"
                    + " where date_create LIKE ? ");
            pst10.setString(1, simpleDateFormat.format(calendar.getTime()) + "-11" + "%");
            ResultSet rs10 = pst10.executeQuery();
            while (rs10.next()) {
               tong += (rs10.getInt(4) * 0.05f);
            }
            arr.add(tong);
            tong = 0;
            //
            pst11 = con.prepareStatement("SELECT * FROM bill"
                    + " where date_create LIKE ? ");
            pst11.setString(1, simpleDateFormat.format(calendar.getTime()) + "-12" + "%");
            ResultSet rs11 = pst11.executeQuery();
            while (rs11.next()) {
                tong += (rs11.getInt(4) * 0.05f);
                
            }
            arr.add(tong);
            tong = 0;
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
}
