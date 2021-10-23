/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import utils.DbConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author doge
 */
public class OrderDAO {

    public static void addOrder(float price, int quantity, java.sql.Date buyDate) {
        Connection con = DbConnect.open();
        PreparedStatement pstm = null;
        try {

            String sql = "INSERT INTO `_order`(`id`, `tong_gia_tien`, `tong_so_luong`, `ngay_mua`) "
                    + "VALUES (NULL, ?, ?, ?);";
            pstm = con.prepareStatement(sql);
            pstm.setFloat(1, price);
            pstm.setInt(2, quantity);
            pstm.setDate(3, buyDate);

            pstm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Loi: " + ex.getMessage());
        } finally {
            DbConnect.close(con, pstm, null);
        }
    }

    public static void addOrderList(int orderId, String name, float price, int quantity) {
        Connection con = DbConnect.open();
        PreparedStatement pstm = null;
        try {

            String sql = "INSERT INTO `_order_details`(`id`, `order_id`, `ten`, `gia_tien`, `so_luong`) "
                    + "VALUES (NULL, ?, ?, ?, ?);";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, orderId);
            pstm.setString(2, name);
            pstm.setFloat(3, price);
            pstm.setInt(4, quantity);

            pstm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Loi: " + ex.getMessage());
        } finally {
            DbConnect.close(con, pstm, null);
        }
    }
}
