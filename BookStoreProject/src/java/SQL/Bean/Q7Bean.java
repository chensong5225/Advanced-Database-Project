/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL.Bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author surface
 */
public class Q7Bean extends Object implements Serializable{
    
    private static final long serialVersionUID = 102831973239L;
    
    ArrayList<ArrayList<Double>> list;

    public ArrayList<ArrayList<Double>> getList() {
        return list;
    }

    public void setList(ArrayList<ArrayList<Double>> list) {
        this.list = list;
    }
    
}
