/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MongoJDBC.mongFromSql;

/**
 *
 * @author fei
 */
public class LoadAll {
    public void load() throws ClassNotFoundException{
        //load Fact
        new Fact().load();
        //load viewsType for Q1
        new ViewsType().load();
        
    }
    public static void main(String args[]) throws ClassNotFoundException{
        LoadAll f = new LoadAll();
        f.load();
    }
}
