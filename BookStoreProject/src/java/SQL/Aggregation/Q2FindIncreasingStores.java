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
public class Q2FindIncreasingStores {
    
    public ArrayList<String> stores(String startDate, String endDate) throws ClassNotFoundException{
        ArrayList<String> list = new ArrayList<>();
        HashMap<String, HashMap<String, String>> map = SQLIncreasingStores.stores();
        for(String store: map.keySet()){
            HashMap<String, String> saleMap = map.get(store);
            double startSale = 0;
            double endSale = 0;
            if(saleMap.containsKey(startDate)){
                startSale = Double.parseDouble(saleMap.get(startDate));
            }
            if(saleMap.containsKey(endDate)){
                endSale = Double.parseDouble(saleMap.get(endDate));
            }
            if(startSale < endSale){
                list.add(store);
            }
        }
        
        return list;
    }
}
