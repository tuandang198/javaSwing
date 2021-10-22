/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import controllers.DbConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.DanhMuc;
import views.ProductManagement;

/**
 *
 * @author doge
 */
public class CategoryDAO {
    public static List<DanhMuc> categoryList() {
        List<DanhMuc> categoryList = new ArrayList<>();
        Connection con = DbConnect.open();
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DbConnect.open();

            String sql = "select * from danh_muc";
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            DanhMuc danhMuc;
            while (rs.next()) {
                danhMuc = new DanhMuc(rs.getInt("id"), rs.getString("ten"), rs.getInt("status"));
                categoryList.add(danhMuc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductManagement.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbConnect.close(con, stm, rs);
        }
        return categoryList;
    }
    public static void add(String name, int status) {
        Connection con = DbConnect.open();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            // TODO add your handling code here:
            con = DbConnect.open();
            String sql = "INSERT INTO `danh_muc` (`id`, `ten`, `status`) "
                    + "VALUES (NULL, ?, ?);";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, name);

            pstm.setInt(2, status);

            pstm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProductManagement.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbConnect.close(con, pstm, rs);
        }
    }
    public static void update(String name, int status, int id) {
        Connection con = DbConnect.open();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            // TODO add your handling code here:
            con = DbConnect.open();
            String sql = "UPDATE `danh_muc` SET `ten`= ?,`status`= ? WHERE `id`=?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, name);

            pstm.setInt(2, status);
            pstm.setInt(3,id);

            pstm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProductManagement.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbConnect.close(con, pstm, rs);
        }
    }
     public static void delete(int id) {
        Connection con = DbConnect.open();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            // TODO add your handling code here:
            con = DbConnect.open();
            String sql = "DELETE FROM `danh_muc` WHERE `id`=?";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProductManagement.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbConnect.close(con, pstm, rs);
        }
    }
}
