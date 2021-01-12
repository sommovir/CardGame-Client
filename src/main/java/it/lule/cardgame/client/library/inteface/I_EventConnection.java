/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.lule.cardgame.client.library.inteface;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 *
 * @author lele
 */
public interface I_EventConnection {

    public void userConnected(String nickName);
    public void messageArrived(String topic, MqttMessage mqttMessage) throws MqttException;
    public void ackReceided(int error);
}
