/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlJDBC;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author surface
 */
public class Main{
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

    
    
    public static void main(String[] args) throws ClassNotFoundException{   
        
           ArrayList<String> hlist = RetrieveHomeCustomer.retrieveHome();
           for(String s: hlist){
                System.out.println(s);
            }
        
           ArrayList<String> blist = RetrieveBusinessCustomer.retrieveBusiness();
           for(String s: blist){
                System.out.println(s);
            }
        /*
        HashMap<String, HashMap<String,String>> map = IncreasingStores.stores();
        for(String s :map.keySet()){
            for(String t: map.get(s).keySet()){
                System.out.println(s + " " + t + " " + map.get(s).get(t));
            }
        }
        */
        /*
        HashMap<String, HashMap<String, HashMap<String, Double>>> map = EverydaySales.sales();
        for(String p: map.keySet()){
            for(String t: map.get(p).keySet()){
                for(String s: map.get(p).get(t).keySet()){
                    System.out.println(p + " " + t + " " + s + " " + map.get(p).get(t).get(s));
                }
            }
        }
        */
        /*
        HashMap<String, Integer> map = RegionCompare.regionCompare();
        for(String s: map.keySet()){
                System.out.println(s + " " + map.get(s));
            }
        */
        /*
        ArrayList<String> list = BusinessBuyMost.buyMost("Leonardo and the Last Supper");
        for(String s: list){
            System.out.println(s);
        }
        */
        
        /*
        HashMap<String, HashMap<Double, Double>> map = DemandCurve.demand();
        for(String s: map.keySet()){
            for(Double d: map.get(s).keySet()){
                System.out.println(s + " price " + d + " sale " + map.get(s).get(d));
            }
        }
        */
        /*
        ArrayList<String[]> list = StartLoad.load();
        for(String[] str: list){
            System.out.println(str[0] + "  " +  str[1]);
        }
        */
        /*
        String[] str = LoadCustomer.load("3", "2");
        System.out.println(str[0] + "  " + str[1]);
        */
        /*
        String[] str = LoadStore.load("3", "2");
        System.out.println(str[0] + "  " + str[1]);
        */
        /*
        String[] str = LoadProduct.load("2");
        System.out.println(str[0] + "  " + str[1]);
        */
        /*
        String[] str = LoadSale.load("3", "2");
        System.out.println(str[0] + "  " + str[1] + "  " + str[2] + "   " + str[3]);
        */
    }
    
    
    
}


