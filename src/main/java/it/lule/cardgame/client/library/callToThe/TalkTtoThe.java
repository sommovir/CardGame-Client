/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.lule.cardgame.client.library.callToThe;

import it.lule.cardgame.client.library.enumname.ChannelEnum;
import it.lule.cardgame.client.library.event.EventManager;
import it.lule.cardgame.client.library.mqtt.client.MQTTClient;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import it.lule.cardgame.client.library.inteface.I_EventConnection;
import it.lule.cardgame.client.library.inteface.I_Qualcosa01;

/**
 *
 * @author lele
 */
public class TalkTtoThe implements I_EventConnection, I_Qualcosa01 {

    protected MQTTClient mQTTClient;
    protected String topic;
    protected MqttMessage mqttMessage;

    public TalkTtoThe() throws MqttException {
        mQTTClient = MQTTClient.getInstance();

//        waitTime();

        
//        EventManager.getInstance().addConnectionEvents(this);
    }

    private void waitTime(){
        try {
            /* Thread.sleep(1000) */
            System.out.println("a");
            Thread.sleep(1000);
            System.out.println("b");
        } catch (InterruptedException ex) {
            Logger.getLogger(MQTTClient.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    protected void message001_DBG(String _message) {
        System.out.println("" + _message);
        String message = null;
        
        if ( mqttMessage != null){
            message = new String(mqttMessage.getPayload());
        }        
         
        System.out.println("topic " + topic);
        System.out.println("mqttMessage " + message);
        System.out.println("");
    }    
    
    @Override
    public void messageArrived(String topic, MqttMessage mqttMessage) throws MqttException {
//        this.topic = topic;
//        this.mqttMessage = mqttMessage;
//
//        switch (this.topic) {
//            case "AllConnected":
//                System.out.println("TalkTtoThe > messageArrived > AllConnected ");
//                allConnected();
//                break;
//            case "FirstConnection":
//                System.out.println("TalkTtoThe > messageArrived > firstConnection ");
//                firstConnection();
//                break;
//            case "SubscribeMyChannel":
//                System.out.println("TalkTtoThe > messageArrived > subscribeMyChannel ");
//                subscribeMyChannel();
//                break;
//            default:
//                System.err.println("TalkTtoThe > messageArrived > default ");
//        }

    }

    @Override
    public void userConnected(String nickName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ackReceided(int error) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void allConnected() throws MqttException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void firstConnection() throws MqttException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void subscribeMyChannel() throws MqttException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
