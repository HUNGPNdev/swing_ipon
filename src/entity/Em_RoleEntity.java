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
public class Em_RoleEntity {
    
    private int em_id;
    private int role_id;

    public Em_RoleEntity() {
    }

    public Em_RoleEntity(int em_id, int role_id) {
        this.em_id = em_id;
        this.role_id = role_id;
    }

    @Override
    public String toString() {
        return "Em_RoleEntity{" + "em_id=" + em_id + ", role_id=" + role_id + '}';
    }

    public int getEm_id() {
        return em_id;
    }

    public void setEm_id(int em_id) {
        this.em_id = em_id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }
    
    
    
}
