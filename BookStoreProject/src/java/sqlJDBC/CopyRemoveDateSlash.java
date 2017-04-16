/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlJDBC;


/**
 *
 * @author yuq
 */
public class CopyRemoveDateSlash {
    public static String remove(String date){
        String s = "";
        for(int i = 0; i < date.length(); i++){
            if(date.charAt(i) != '-'){
                s += date.charAt(i);
            }
        }
        return s;
    }
}
