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
public class Message extends Object implements Serializable{
    
    private String messageInfo;

    /**
     * @return the messageInfo
     */
    public String getMessageInfo() {
        return messageInfo;
    }

    /**
     * @param messageInfo the messageInfo to set
     */
    public void setMessageInfo(String messageInfo) {
        this.messageInfo = messageInfo;
    }
    
    
    
}
