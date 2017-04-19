/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Neo4j;

import java.util.List;
import Neo4j.beans.Q1_result;
import java.util.ArrayList;
import java.util.Iterator;
import SQL.Aggregation.*;

/**
 *
 * @author hom19
 */

public class Update {
    private CreateCustomerDim cc;
    private CreateFact cf;
    private CreateProductDim cp;
    private CreateStoreDim cs;
    private Warehouse wh;
    public Update(){
        cc = new CreateCustomerDim();
        cf = new CreateFact();
        cp = new CreateProductDim();
        cs = new CreateStoreDim();
        wh = new Warehouse();
    }
    public void update(){
        
        cc.create();
        cf.create();
        cp.create();
        cs.create();
        wh.loadWarehouse();
         
        }
    }

