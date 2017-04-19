/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL.Aggregation;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author yuq
 */
public class Main {
    
    public static void main(String[] args) throws ClassNotFoundException{
        /*
        Q2FindIncreasingStores q2 = new Q2FindIncreasingStores();
        ArrayList<String> list = q2.stores("2017-02-18", "2017-02-28");
        for(String s: list){
            System.out.println(s);
        }
        */
        /*
        Q1CustomerRatio q1 = new Q1CustomerRatio();
        int[] arr = q1.ratio();
        System.out.println(arr[0] + " ：" + arr[1]);
        */
        
        //CreateCustomerDim cc = new CreateCustomerDim();
        //cc.create();
        //CreateStoreDim.create();
        
        /*
        HashMap<String, Integer> map = Q5RegionCompare.regionCompare();
        for(String s: map.keySet()){
                System.out.println(s + " " + map.get(s));
            }
        */
        Q5RegionCompare q5 = new Q5RegionCompare();
        HashMap<String, Double> map2 = q5.regionCompare();
        for(String s: map2.keySet()){
                System.out.println(s + " " + map2.get(s));
            }
        
        Q9StoreCompare q9 = new Q9StoreCompare();
        HashMap<String, Double> map = q9.storeCompare();
        for(String s: map.keySet()){
                System.out.println(s + " " + map.get(s));
            }
        
        /*
        HashMap<String, HashMap<Double, Double>> map = Q7DemandCurve.demand();
        for(String s: map.keySet()){
            for(Double d: map.get(s).keySet()){
                System.out.println(s + " price " + d + " sale " + map.get(s).get(d));
            }
        }
        */
        /*
        Q3EverydaySales q3 = new Q3EverydaySales();
        q3.maintain("2017-02-28");
        Q3RetrieveViews q3r = new Q3RetrieveViews();
        ArrayList<ArrayList<String>> list = q3r.retrieve("2017-02-28");
        for(int i = 0; i < list.size(); i++){
            ArrayList<String> nestList = list.get(i);
            for(String s: nestList){
                System.out.println(s);
            }
        }
        */
        //Q4aTopCustomerCategories.maintain("2017-02-28");
        //Q4bTopProductCategories.maintain("2017-02-28");
        
        /*
        ArrayList<String> list = Q6BusinessBuyMost.buyMost("Today I ll Be a Princess");
        for(String s: list){
                System.out.println(s);
            }
        */
        /*
        Q7DemandCurve q7 = new Q7DemandCurve();
        ArrayList<ArrayList<Double>> list = q7.demand("Today I ll Be a Princess");
        //ArrayList<ArrayList<Double>> list = q7.demand("3");
        ArrayList<Double> price = list.get(0);
        ArrayList<Double> sale = list.get(1);
        for(int i = 0; i < price.size(); i++){
            System.out.println(price.get(i) + "   " + sale.get(i));
        }
        */
        /*
        Q8MarketingData q8 = new Q8MarketingData();
        ArrayList<String> list = q8.show("DanTDM: Trayaurus and the Enchanted Crystal", "3");
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
        */
    }
    
}
