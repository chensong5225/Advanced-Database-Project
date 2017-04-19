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
public class Q1Bean extends Object implements Serializable{
    
    private static final long serialVersionUID = 102831973239L;
    
    int home;
    int business;

    public int getHome() {
        return home;
    }

    public void setHome(int home) {
        this.home = home;
    }

    public int getBusiness() {
        return business;
    }

    public void setBusiness(int business) {
        this.business = business;
    }
    
    
}
