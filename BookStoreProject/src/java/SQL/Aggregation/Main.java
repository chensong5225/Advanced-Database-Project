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
        ArrayList<String> list = Q2FindIncreasingStores.stores("2017-02-18", "2017-03-18");
        for(String s: list){
            System.out.println(s);
        }
        */
        /*
        int[] arr = Q1CustomerRatio.ratio();
        System.out.println(arr[0] + " ：" + arr[1]);
        */
        
        //CreateCustomerDim.create();
        //CreateStoreDim.create();
        
        
        HashMap<String, Integer> map = Q5RegionCompare.regionCompare();
        for(String s: map.keySet()){
                System.out.println(s + " " + map.get(s));
            }
        
    }
    
}
