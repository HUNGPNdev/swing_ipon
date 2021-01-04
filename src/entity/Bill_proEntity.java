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
public class Bill_proEntity {
    private int pro_id;
    private int bill_id;

    public Bill_proEntity(int pro_id, int bill_id) {
        this.pro_id = pro_id;
        this.bill_id = bill_id;
    }

    public Bill_proEntity() {
    }

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public int getBill_id() {
        return bill_id;
    }

    public void setBill_id(int bill_id) {
        this.bill_id = bill_id;
    }
    
    
}
