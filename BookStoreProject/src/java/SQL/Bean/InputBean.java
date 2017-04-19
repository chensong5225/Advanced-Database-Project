/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL.Bean;

import java.io.Serializable;

/**
 *
 * @author surface
 */
public class InputBean extends Object implements Serializable{
    
    private static final long serialVersionUID = 102831973239L;
    
    String productName;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    
    
}
