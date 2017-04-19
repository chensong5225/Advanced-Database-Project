/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xy.service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author mac
 */
public class tst {

    public static void main(String args[]) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd HHMMss");
        String str = formatter.format(date);
        String str2 = "2017-2-15";
        int tid = Integer.parseInt(str);
       // int tid2 = Integer.valueOf(date);
        //  int wk = Integer.valueOf(str - str2);

        Random r = new Random();
        int si = r.nextInt(4);
        double dis = r.nextDouble();
        //DecimalFormat df   = new DecimalFormat("##.0");   
        //df.format(dis);
        BigDecimal b = new BigDecimal(dis);
        double f1 = b.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.print(tid);
    }
}
