/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL.Bean;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author surface
 */
public class Q9Bean extends Object implements Serializable{
    
    private static final long serialVersionUID = 102831973239L;
    
    HashMap<String, Double> map;

    public HashMap<String, Double> getMap() {
        return map;
    }

    public void setMap(HashMap<String, Double> map) {
        this.map = map;
    }
}
