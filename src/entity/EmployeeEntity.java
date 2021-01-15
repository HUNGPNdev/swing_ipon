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
public class EmployeeEntity {
    
    private int id;
    private String fullname;
    private String username;
    private String password;
    private boolean status;

    public EmployeeEntity() {
    }

    public EmployeeEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    

    public EmployeeEntity(int id, String fullname, String username, String password, boolean status) {
        this.id = id;
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.status = status;
    }

    public EmployeeEntity(String fullname, String username, String password, boolean status) {
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "EmployeeEntity{" + "id=" + id + ", fullname=" + fullname + ", username=" + username + ", password=" + password + ", status=" + status + '}';
    }
    
    
    
}
