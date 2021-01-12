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

/**
 *
 * @author lele
 */
public class TalkTtoTheClient extends TalkTtoThe {

    private String subscribeMyChannel;
    
    public TalkTtoTheClient() throws MqttException {
        EventManager.getInstance().addConnectionEvents(this);

        init01();
    }

    public void init01() throws MqttException {

        /* String subscribeMyChannel = user + clientID; */
        subscribeMyChannel = mQTTClient.getSubscribeMyChannel();

        mQTTClient.topicUnsubscribe(ChannelEnum.FIRST_CONNECTION.getChannelEnum());
        mQTTClient.topicSubscribe(subscribeMyChannel);
        
        mQTTClient.publish(ChannelEnum.FIRST_CONNECTION.getChannelEnum(),
                subscribeMyChannel);

//        message001_DBG("TalkTtoTheClient > firstConnection");        
    }

    /**
     * Subscribe My Channel
     *
     * @throws MqttException
     */
    @Override
    public void subscribeMyChannel() throws MqttException {
        message001_DBG("TalkTtoTheClient > subscribeMyChannel");
    }

    /**
     * First Connection
     *
     * @throws MqttException
     */
    @Override
    public void firstConnection() throws MqttException {
        message001_DBG("TalkTtoTheClient > firstConnection");
    }

    /**
     * All Connected
     *
     * @throws MqttException
     */
    @Override
    public void allConnected() throws MqttException {
        message001_DBG("TalkTtoTheClient > allConnected ");

    }

    @Override
    public void messageArrived(String topic, MqttMessage mqttMessage) throws MqttException {
        this.topic = topic;
        this.mqttMessage = mqttMessage; 
        message001_DBG("TalkTtoTheClient > messageArrived > subscribeMyChannel " + subscribeMyChannel + "\n");
//        
//        if ( topic.equals(subscribeMyChannel)){
//            subscribeMyChannel();
//        }
    }


}
