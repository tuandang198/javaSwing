/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Admin
 */
public class DanhMuc {
    private int id;
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    public DanhMuc() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private String name;

    public DanhMuc(int id, String name, int status) {
        this.id = id;
        this.status = status;
        this.name = name;
    }

    public DanhMuc(int status, String name) {
        this.status = status;
        this.name = name;
    }

    
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
