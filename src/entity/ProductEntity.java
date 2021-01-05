/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Lenovo
 */
public class ProductEntity {
    
    private int id;
    private String name;
    private int cate_id;
    private int old_count;
    private int now_count;
    private double price;
    private String cou_id;
<<<<<<< HEAD
=======

    public ProductEntity() {
    }

    public ProductEntity(int id, String name, int cate_id, int old_count, int now_count, double price, String cou_id) {
        this.id = id;
        this.name = name;
        this.cate_id = cate_id;
        this.old_count = old_count;
        this.now_count = now_count;
        this.price = price;
        this.cou_id = cou_id;
    }

    public ProductEntity(String name, int cate_id, int old_count, int now_count, double price, String cou_id) {
        this.name = name;
        this.cate_id = cate_id;
        this.old_count = old_count;
        this.now_count = now_count;
        this.price = price;
        this.cou_id = cou_id;
    }
    
    public ProductEntity(String name, int cate_id, int old_count, int now_count, double price) {
        this.name = name;
        this.cate_id = cate_id;
        this.old_count = old_count;
        this.now_count = now_count;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCate_id() {
        return cate_id;
    }

    public void setCate_id(int cate_id) {
        this.cate_id = cate_id;
    }

    public int getOld_count() {
        return old_count;
    }

    public void setOld_count(int old_count) {
        this.old_count = old_count;
    }

    public int getNow_count() {
        return now_count;
    }

    public void setNow_count(int now_count) {
        this.now_count = now_count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCou_id() {
        return cou_id;
    }

    public void setCou_id(String cou_id) {
        this.cou_id = cou_id;
    }

    @Override
    public String toString() {
        return "ProductEntity{" + "id=" + id + ", name=" + name + ", cate_id=" + cate_id + ", old_count=" + old_count + ", now_count=" + now_count + ", price=" + price + ", cou_id=" + cou_id + '}';
    }
>>>>>>> 7515b971883b024348893979712532e83a96d9f4
    
    
    
    
    
}
