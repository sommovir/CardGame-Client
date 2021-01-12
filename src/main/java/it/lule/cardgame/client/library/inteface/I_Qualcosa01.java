/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.lule.cardgame.client.library.inteface;

import org.eclipse.paho.client.mqttv3.MqttException;

/**
 *
 * @author lele
 */
public interface I_Qualcosa01 {
    public void allConnected() throws MqttException;
    public void firstConnection() throws MqttException;
    public void subscribeMyChannel() throws MqttException;
    
}
