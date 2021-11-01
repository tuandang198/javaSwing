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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Order;
import views.ProductManagement;

/**
 *
 * @author doge
 */
public class OrderDAO {

    public static int addOrder(float price, int quantity, java.sql.Date buyDate) {
        Connection con = DbConnect.open();
        ResultSet result;
        PreparedStatement pstm = null;

        int temp = -1;
        try {
            String sql = "INSERT INTO `_order`(`id`, `tong_gia_tien`, `tong_so_luong`, `ngay_mua`) "
                    + "VALUES (NULL, ?, ?, ?);";

            pstm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstm.setFloat(1, price);
            pstm.setInt(2, quantity);
            pstm.setDate(3, buyDate);
            pstm.executeUpdate();

            result = pstm.getGeneratedKeys();

            if (result.next() && result != null) {
                temp = result.getInt(1);
            } else {
                System.out.println("No, Nop nada");
            }

        } catch (SQLException ex) {
            System.out.println("Loi: " + ex.getMessage());
        } finally {
            DbConnect.close(con, pstm, null);
        }
        return temp;
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

    public static List<Order> OrderList(int orderId) {
        List<Order> orderList = new ArrayList<>();
        Connection con = DbConnect.open();
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DbConnect.open();

            String sql = "select * from _order_details where order_id = ?";

            stm = con.prepareStatement(sql);
            stm.setInt(1, orderId);
            rs = stm.executeQuery();
            Order order;

            while (rs.next()) {
                order = new Order(rs.getString("ten"), rs.getFloat("gia_tien"), rs.getInt("so_luong"));
                orderList.add(order);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductManagement.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbConnect.close(con, stm, rs);
        }
        return orderList;
    }
    public static void delete(int id) {
        Connection con = DbConnect.open();
        PreparedStatement pstm = null;
        try {
            String sql = "DELETE FROM `_order_details` WHERE `order_id`=?";
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
