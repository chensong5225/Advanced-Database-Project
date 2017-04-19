/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MongoBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author fei
 */
public class BeanQ7 extends Object implements Serializable{
    private static long serialVersionUID = 102831973239L;
    HashMap<Double,Double> beanq7 = new  HashMap<Double,Double>();
    ArrayList<Double> price = new ArrayList();
    ArrayList<Double> amount = new ArrayList();
    
    public HashMap<Double, Double> getBeanq7() {
        return beanq7;
    }

    public ArrayList<Double> getPrice() {
        return price;
    }

    public ArrayList<Double> getAmount() {
        return amount;
    }

    public void setBeanq7(HashMap<Double, Double> beanq7) {
        this.beanq7 = beanq7;
        Iterator it = beanq7.entrySet().iterator();
        while(it.hasNext()){
           Map.Entry entry = (Map.Entry) it.next();
           Double key = (Double)entry.getKey();
           Double value = (Double)entry.getValue();
           price.add(key);
           amount.add(value);
        }
        
    }
     
}
