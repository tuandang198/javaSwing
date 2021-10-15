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
public class SanPham {
    private int productId, giaTien, soLuong;
    private String ten, tenDanhMuc, tenNhaSanXuat;

    public SanPham(int productId,String ten,  int giaTien, int soLuong, String tenDanhMuc, String tenNhaSanXuat) {
        this.productId = productId;
        this.giaTien = giaTien;
        this.soLuong = soLuong;
        this.ten = ten;
        this.tenDanhMuc = tenDanhMuc;
        this.tenNhaSanXuat = tenNhaSanXuat;
    }

    public SanPham() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(int giaTien) {
        this.giaTien = giaTien;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    public String getTenNhaSanXuat() {
        return tenNhaSanXuat;
    }

    public void setTenNhaSanXuat(String tenNhaSanXuat) {
        this.tenNhaSanXuat = tenNhaSanXuat;
    }
}
