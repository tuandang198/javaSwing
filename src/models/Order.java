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
public class Order {
    private int quantity;
    private float price;
    private String name;

    public Order(String name, float price, int quantity) {
        this.price = price;
        this.quantity = quantity;
        this.name = name;
    }

    public Order() {
    }


    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Order{" + "quantity=" + quantity + ", price=" + price + ", name=" + name + '}';
    }
    
}
