/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.lule.cardgame.client.logic;

import it.lule.cardgame.client.mqtt.MQTTClient;

/**
 *
 * @author lele
 */
public class TalkTtoTheServer {

    public TalkTtoTheServer() {
    }
    
    public void createRegistration(String nickName, String password){
        String message = nickName + password;
        MQTTClient.getInstance().publish(LoginEnum.REGISTRATION.getLoginEnum(), message);        
    }
}
/*

*/