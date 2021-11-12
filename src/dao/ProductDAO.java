/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import utils.DbConnect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.SanPham;
import views.ProductManagement;

/**
 *
 * @author doge
 */
public class ProductDAO {

    public static List<SanPham> productList() {
        List<SanPham> productList = new ArrayList<>();
        Connection con = DbConnect.open();
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DbConnect.open();
            String sql = "select b.id,b.ten,b.gia_tien,b.so_luong,a.ten,c.ten_nha_san_xuat from danh_muc as a join san_pham as b on a.id = b.danh_muc_id join nha_san_xuat as c on b.nha_san_xuat_id = c.id";
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            SanPham sanPham;
            while (rs.next()) {
                sanPham = new SanPham(rs.getInt("id"), rs.getString("ten"), rs.getInt("gia_tien"), rs.getInt("so_luong"), rs.getString("a.ten"), rs.getString("ten_nha_san_xuat"));
                productList.add(sanPham);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductManagement.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbConnect.close(con, stm, rs);
        }
        return productList;
    }

    public static void update(String name, String price, String quantity, int category, int manufacturer, int id) {
        Connection con = DbConnect.open();
        PreparedStatement pstm = null;

        try {

            String sql = "UPDATE `san_pham` SET `ten`= ?,`gia_tien`= ?,`so_luong`= ?,`danh_muc_id`= ?, `nha_san_xuat_id`= ? WHERE `id`=?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, name);
            pstm.setString(2, price);
            pstm.setString(3, quantity);
            pstm.setInt(4, category);
            pstm.setInt(5, manufacturer);
            pstm.setInt(6, id);

            pstm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Loi: " + ex.getMessage());
        } finally {
            DbConnect.close(con, pstm, null);
        }
    }
    public static void updateQty(int qty, String name) {
        Connection con = DbConnect.open();
        PreparedStatement pstm = null;

        try {

            String sql = "UPDATE `san_pham` SET `so_luong`= ? WHERE `ten`=?";
            pstm = con.prepareStatement(sql);
            
            pstm.setInt(1, qty);
            pstm.setString(2, name);

            pstm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Loi: " + ex.getMessage());
        } finally {
            DbConnect.close(con, pstm, null);
        }
    }

    public static void add(String name, String price, String quantity, int category, int manufacturer) {
        Connection con = DbConnect.open();
        PreparedStatement pstm = null;

        try {

            String sql = "INSERT INTO `san_pham` (`id`, `ten`, `so_luong`, `gia_tien`, `nha_san_xuat_id`, `danh_muc_id`) "
                    + "VALUES (NULL, ?, ?, ?, ?, ?);";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, name);
            pstm.setString(2, price);
            pstm.setString(3, quantity);
            pstm.setInt(4, category);
            pstm.setInt(5, manufacturer);

            pstm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Loi: " + ex.getMessage());
        } finally {
            DbConnect.close(con, pstm, null);
        }
    }

    public static void delete(int id) {
        Connection con = DbConnect.open();
        PreparedStatement pstm = null;
        try {
            String sql = "DELETE FROM `san_pham` WHERE `id`=?";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Loi: " + ex.getMessage());
        } finally {
            DbConnect.close(con, pstm, null);
        }
    }
    public static int findDuplicate(String name){
        int temp =0;
        
        Connection con = DbConnect.open();
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DbConnect.open();

            String sql = "select * from san_pham where ten = ?";
            stm = con.prepareStatement(sql);
            stm.setString(1,name);
            rs = stm.executeQuery();
            if (rs.next()) {
                temp=1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductManagement.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbConnect.close(con, stm, rs);
        }
        return temp;
    }

//    public static SanPham findProduct(String name) {
//        Connection con = DbConnect.open();
//        PreparedStatement pstm = null;
//        ResultSet rs = null;
//
//        try {
//            String sql = "SELECT FROM `san_pham` WHERE `ten` like ?";
//            pstm = con.prepareStatement(sql);
//            pstm.setString(1, name);
//            rs = pstm.executeQuery();
//            SanPham sanPham;
//            if (rs.next()) {
//                sanPham = new SanPham(rs.getInt("id"), rs.getString("ten"), rs.getInt("gia_tien"), rs.getInt("so_luong"), rs.getString("a.ten"), rs.getString("ten_nha_san_xuat"));
//
//            }
//        } catch (SQLException ex) {
//            System.out.println("Loi: " + ex.getMessage());
//        } finally {
//            DbConnect.close(con, pstm, null);
//        }
//        
//    }
}
