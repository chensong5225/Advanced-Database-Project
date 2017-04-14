/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xy.bean;

import java.io.Serializable;

/**
 *
 * @author mac
 */
public class Cart extends Object implements Serializable{
    
    private static final long serialVersionUID = 102831973239L;
    
    private int cid;
    private int bid;
    private float totoal_price;
    private int quantity;

    /**
     * @return the cid
     */
    public int getCid() {
        return cid;
    }

    /**
     * @param cid the cid to set
     */
    public void setCid(int cid) {
        this.cid = cid;
    }

    /**
     * @return the bid
     */
    public int getBid() {
        return bid;
    }

    /**
     * @param bid the bid to set
     */
    public void setBid(int bid) {
        this.bid = bid;
    }

    /**
     * @return the totoal_price
     */
    public float getTotoal_price() {
        return totoal_price;
    }

    /**
     * @param totoal_price the totoal_price to set
     */
    public void setTotoal_price(float totoal_price) {
        this.totoal_price = totoal_price;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }   
    
}
