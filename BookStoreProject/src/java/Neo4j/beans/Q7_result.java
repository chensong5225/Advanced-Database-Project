/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Neo4j.beans;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author mac
 */
public class Q7_result extends Object implements Serializable{
    
    private static long serialVersionUID = 102831973239L;
    private ArrayList<Float> pricelist;
    private ArrayList<Float> salelist;    

    /**
     * @return the pricelist
     */
    public ArrayList<Float> getPricelist() {
        return pricelist;
    }

    /**
     * @param pricelist the pricelist to set
     */
    public void setPricelist(ArrayList<Float> pricelist) {
        this.pricelist = pricelist;
    }

    /**
     * @return the salelist
     */
    public ArrayList<Float> getSalelist() {
        return salelist;
    }

    /**
     * @param salelist the salelist to set
     */
    public void setSalelist(ArrayList<Float> salelist) {
        this.salelist = salelist;
    }

    /**
     * @return the list
     */
  
 
    
    
}
