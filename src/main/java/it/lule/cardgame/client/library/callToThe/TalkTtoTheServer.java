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
import org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory;

/**
 *
 * @author lele
 */
public class TalkTtoTheServer extends TalkTtoThe {

    private boolean flag01 = true;

    public TalkTtoTheServer() throws MqttException {
        EventManager.getInstance().addConnectionEvents(this);

        System.out.println("Sono TalkTtoTheServer \n");
        System.out.println("");
    }

    /**
     * First Connection
     *
     * @throws MqttException
     */
    @Override
    public void firstConnection() throws MqttException {
        message001_DBG("TalkTtoTheServer > firstConnection ");
        String subscribeMyChannel = new String(mqttMessage.getPayload());

        mQTTClient.publish(subscribeMyChannel, "Welcome " + subscribeMyChannel + "\n");
    }

    /**
     * All Connected
     *
     * @throws MqttException
     */
    @Override
    public void allConnected() throws MqttException {
        message001_DBG("TalkTtoTheServer > allConnected ");
    }

    /**
     * Subscribe My Channel
     *
     * @throws MqttException
     */
    @Override
    public void subscribeMyChannel() throws MqttException {
        super.subscribeMyChannel(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void messageArrived(String topic, MqttMessage mqttMessage) throws MqttException {
        this.topic = topic;
        this.mqttMessage = mqttMessage;

        switch (this.topic) {
            case "AllConnected":
                System.out.println("TalkTtoThe > messageArrived > AllConnected ");
                allConnected();
                break;
            case "FirstConnection":
                System.out.println("TalkTtoThe > messageArrived > firstConnection ");
                firstConnection();
                break;
//            case "SubscribeMyChannel":
//                System.out.println("TalkTtoThe > messageArrived > subscribeMyChannel ");
//                subscribeMyChannel();
//                break;
            default:
                System.err.println("TalkTtoThe > messageArrived > default ");
        }
    }

}
