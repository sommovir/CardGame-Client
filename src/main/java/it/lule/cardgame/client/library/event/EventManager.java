/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.lule.cardgame.client.library.event;

import java.util.LinkedList;
import java.util.List;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import it.lule.cardgame.client.library.inteface.I_EventConnection;
import org.eclipse.paho.client.mqttv3.MqttException;

/**
 *
 * @author lele
 */
public class EventManager {
    private static EventManager instance = null;
    private List < I_EventConnection > eventConnections = new LinkedList<>();
    
    private EventManager() {

    }
    
    public static EventManager getInstance(){
        if ( instance == null  ){
            instance = new EventManager();
        }
        return instance;
    }

    public void addConnectionEvents(I_EventConnection connectionEvent) {
        this.eventConnections.add(connectionEvent);
    }
    
    public void userConnected(String nickName){
        for (I_EventConnection eventConnection : eventConnections) {
            eventConnection.userConnected(nickName);
        }
    }
    
    public void messageArrived(String topic, MqttMessage mqttMessage) throws MqttException{
        for (I_EventConnection eventConnection : eventConnections) {
            eventConnection.messageArrived(topic, mqttMessage);
        }
    }
    
    public void ackReceided(int error){
        for (I_EventConnection eventConnection : eventConnections) {
            eventConnection.ackReceided(error);
        }
    }
    
}
