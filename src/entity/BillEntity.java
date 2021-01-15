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
public class BillEntity {
    
    private int id;
    private int em_id;
    private String client_name;
    private double total_price;
    private Date date_create;

    public BillEntity() {
    }

    public BillEntity(int id, int em_id, String client_name, double total_price, Date date_create) {
        this.id = id;
        this.em_id = em_id;
        this.client_name = client_name;
        this.total_price = total_price;
        this.date_create = date_create;
    }

    public BillEntity(int em_id, String client_name, double total_price, Date date_create) {
        this.em_id = em_id;
        this.client_name = client_name;
        this.total_price = total_price;
        this.date_create = date_create;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEm_id() {
        return em_id;
    }

    public void setEm_id(int em_id) {
        this.em_id = em_id;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public Date getDate_create() {
        return date_create;
    }

    public void setDate_create(Date date_create) {
        this.date_create = date_create;
    }

    @Override
    public String toString() {
        return "BillEntity{" + "id=" + id + ", em_id=" + em_id + ", client_name=" + client_name + ", total_price=" + total_price + ", date_create=" + date_create + '}';
    }
    
    
}
