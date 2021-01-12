/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.lule.cardgame.client.library.mqtt.client;

import it.lule.cardgame.client.library.callToThe.TalkTtoTheClient;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.paho.client.mqttv3.MqttException;

/**
 *
 * @author lele
 */
public class MainClientX01 {
    public static void main(String[] args) {
        try {
//            MQTTClient.getInstance().connect();
            TalkTtoTheClient talkTtoTheClient = new TalkTtoTheClient();
        } catch (MqttException ex) {
            Logger.getLogger(MainClientX01.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
