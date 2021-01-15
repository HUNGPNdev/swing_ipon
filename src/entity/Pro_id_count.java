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
public class Pro_id_count {
    
    private int pro_id;
    private int count;

    public Pro_id_count(int pro_id, int count) {
        this.pro_id = pro_id;
        this.count = count;
    }

    public Pro_id_count() {
    }

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Pro_id_count{" + "pro_id=" + pro_id + ", count=" + count + '}';
    }
    
    
    
}
