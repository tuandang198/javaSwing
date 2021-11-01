/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author doge
 */
public class TotalBill {
    private int id;
    private float totalPrice;
    private int totalQuantity;
    private String date;

    public TotalBill(float totalPrice, int totalQuantity, String date) {
        this.totalPrice = totalPrice;
        this.totalQuantity = totalQuantity;
        this.date = date;
    }

    public TotalBill(int id, float totalPrice, int totalQuantity, String date) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.totalQuantity = totalQuantity;
        this.date = date;
    }

    public TotalBill() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
}
