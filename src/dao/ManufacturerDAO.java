/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import utils.DbConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.NhaSanXuat;
import views.ProductManagement;

/**
 *
 * @author doge
 */
public  class ManufacturerDAO {
    public static List<NhaSanXuat> manufacturerList() {
        List<NhaSanXuat> manufacturerList = new ArrayList<>();
        Connection con = DbConnect.open();
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DbConnect.open();
            String sql = "select * from nha_san_xuat";
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery(sql);
            NhaSanXuat nhaSanXuat;
            while (rs.next()) {
                nhaSanXuat = new NhaSanXuat(rs.getInt("id"), rs.getString("ten_nha_san_xuat"), rs.getInt("status"));
                manufacturerList.add(nhaSanXuat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductManagement.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbConnect.close(con, stm, rs);
        }
        return manufacturerList;
    }
    public static void add(String name, int status) {
        Connection con = DbConnect.open();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            // TODO add your handling code here:
            con = DbConnect.open();
            String sql = "INSERT INTO `nha_san_xuat` (`id`, `ten_nha_san_xuat`, `status`) "
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
            String sql = "UPDATE `nha_san_xuat` SET `ten_nha_san_xuat`= ?,`status`= ? WHERE `id`=?";
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
            String sql = "DELETE FROM `nha_san_xuat` WHERE `id`=?";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProductManagement.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbConnect.close(con, pstm, rs);
        }
    }
     public static int findDuplicate(String name){
        int temp =0;
        
        Connection con = DbConnect.open();
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DbConnect.open();

            String sql = "select * from nha_san_xuat where ten_nha_san_xuat = ?";
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
}
