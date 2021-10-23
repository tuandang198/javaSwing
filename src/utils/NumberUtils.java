/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.text.NumberFormat;

/**
 *
 * @author doge
 */
public class NumberUtils {
    public static String formatNumber(Number num){
        System.out.println(num);
        return NumberFormat.getNumberInstance().format(num);
    }
}
