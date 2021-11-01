/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Order;
import models.TotalBill;
import utils.DbConnect;
import views.ProductManagement;

/**
 *
 * @author doge
 */
public class TotalBillDAO {
    public static List<TotalBill> TotalBillList() {
        List<TotalBill> totalBillList = new ArrayList<>();
        Connection con = DbConnect.open();
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DbConnect.open();

            String sql = "select * from _order";
            stm = con.prepareStatement(sql);
           
            rs = stm.executeQuery();
            TotalBill totalBill;
            while (rs.next()) {
                totalBill = new TotalBill(rs.getInt("id"), rs.getFloat("tong_gia_tien"), rs.getInt("tong_so_luong"), rs.getString("ngay_mua"));
                totalBillList.add(totalBill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductManagement.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbConnect.close(con, stm, rs);
        }
        return totalBillList;
    }
    public static void delete(int id) {
        Connection con = DbConnect.open();
        PreparedStatement pstm = null;
        try {
            String sql = "DELETE FROM `_order` WHERE `id`=?";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Loi: " + ex.getMessage());
        } finally {
            DbConnect.close(con, pstm, null);
        }
    }
}
