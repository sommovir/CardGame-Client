/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.lule.cardgame.client.library.enumname;

/**
 *
 * @author lele
 */
public enum ChannelEnum {
    ALL_CONNECTED("AllConnected"),
    FIRST_CONNECTION("FirstConnection"),
    SUBSCRIBE_MY_CHANNEL("SubscribeMyChannel");
    
    private String user;

    private ChannelEnum(String user) {
        this.user = user;
    }
    
    public String getChannelEnum(){
        return user;
    }
}
