/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author Lenovo
 */
public class CouponEntity {
    private String id;
    private int em_id;
    private String supplier_name;
    private double total_price;
    private Date date_creat;

    public CouponEntity() {
    }

    public CouponEntity(String id, int em_id, String supplier_name, double total_price, Date date_creat) {
        this.id = id;
        this.em_id = em_id;
        this.supplier_name = supplier_name;
        this.total_price = total_price;
        this.date_creat = date_creat;
    }

    public CouponEntity(int em_id, String supplier_name, double total_price, Date date_creat) {
        this.em_id = em_id;
        this.supplier_name = supplier_name;
        this.total_price = total_price;
        this.date_creat = date_creat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getEm_id() {
        return em_id;
    }

    public void setEm_id(int em_id) {
        this.em_id = em_id;
    }

    public String getSupplier_name() {
        return supplier_name;
    }

    public void setSupplier_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public Date getDate_creat() {
        return date_creat;
    }

    public void setDate_creat(Date date_creat) {
        this.date_creat = date_creat;
    }

    @Override
    public String toString() {
        return "CouponEntity{" + "id=" + id + ", em_id=" + em_id + ", supplier_name=" + supplier_name + ", total_price=" + total_price + ", date_creat=" + date_creat + '}';
    }
    
    
}
