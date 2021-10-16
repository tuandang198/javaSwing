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
public class NhaSanXuat {
     private int id;
    private int status;
    private String name;

    public NhaSanXuat(int status, String name) {
        this.status = status;
        this.name = name;
    }

    public NhaSanXuat(int id, String name, int status) {
        this.id = id;
        this.status = status;
        this.name = name;
    }

    public NhaSanXuat() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
