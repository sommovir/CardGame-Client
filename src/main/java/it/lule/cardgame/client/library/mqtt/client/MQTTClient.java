/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.lule.cardgame.client.library.mqtt.client;

import it.lule.cardgame.client.library.enumname.ChannelEnum;
import it.lule.cardgame.client.library.event.EventManager;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 *
 * @author lele
 */
public class MQTTClient implements MqttCallback {

    public static MQTTClient instance = null;
    private final int qos = 2;
    private MqttClient client = null;
    private final String clientID = "" + new Date().getTime();
    private String user = "DBG";
    private String broker = "tcp://0.0.0.0:1883";

    public static MQTTClient getInstance() throws MqttException {
        if (instance == null) {
            instance = new MQTTClient();
        }
        return instance;
    }

    private MQTTClient() throws MqttException {
        super();
        initializeConnection();
    }

    /**
     * Get Subscribe My Channel
     *
     * @return
     */
    public String getSubscribeMyChannel() {
        String subscribeMyChannel = user + clientID;
        return subscribeMyChannel;
    }

    /**
     * Inizializza il client
     *
     * @return
     * @throws MqttException
     */
    private boolean initClient() throws MqttException {
        if (client == null || !client.isConnected()) {
            client = new MqttClient(broker, clientID, new MemoryPersistence());
            return true;
        }
        return false;
    }

    /**
     * Connect User
     *
     * @throws MqttException
     * @deprecated
     */
    public void connect() throws MqttException {
        initializeConnection();
    }

    /**
     * Connect User
     *
     * @param user
     * @throws MqttException
     */
    public void connect(String user) throws MqttException {
        initializeConnection();
        this.user = user;
    }

    /**
     * Initialize Connection
     *
     * @throws MqttException
     */
    private void initializeConnection() throws MqttException {
        /* avoid double connection */
        if ( initClient() ) {
            MqttConnectOptions connectOptions = new MqttConnectOptions();
            connectOptions.setCleanSession(true);

            /* Conneting to Broker */
            client.connect(connectOptions);

            /* subscribe section */
            client.subscribe(ChannelEnum.ALL_CONNECTED.getChannelEnum());
            client.subscribe(ChannelEnum.FIRST_CONNECTION.getChannelEnum());
            client.setCallback(this);

//            waitTime();
            
            /* Public message */
            publish("AllConnected", "Client " + clientID + " is connected. " + "\n");

        }
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
    
    /**
     * Check Connection
     *
     * @throws MqttException
     */
    private void checkConnection() throws MqttException {
        initializeConnection();
    }

    /**
     * Public message
     *
     * @param topic
     * @param message
     */
    public void publish(String topic, String message) throws MqttException {
        checkConnection();

        MqttMessage mqttMessage = new MqttMessage(message.getBytes());
        mqttMessage.setQos(qos);

        client.publish(topic, mqttMessage);
    }

    /**
     * Subscribe to channel
     *
     * @param topic
     * @throws MqttException
     */
    public void topicSubscribe(String topic) throws MqttException {
        checkConnection();
        client.subscribe(topic);
    }

    /**
     * Unsubscribe to channel
     *
     * @param topic
     * @throws MqttException
     */
    public void topicUnsubscribe(String topic) throws MqttException {
        checkConnection();
        client.unsubscribe(topic);
    }

    @Override
    public void messageArrived(String topic, MqttMessage mqttMessage) throws MqttException {

        EventManager.getInstance().messageArrived(topic, mqttMessage);

//        System.out.println("MQTTClient > messageArrived ");
//        System.out.println("TOPIC: " + topic);
//        System.out.println("MESSAGE: " + new String(mqttMessage.getPayload()));
//        System.out.println("");

    }

    @Override
    public void connectionLost(Throwable thrwbl) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken imdt) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // --------------------------------------------------------------------------------------------
//    @Override
//    public void messageArrived(String topic, MqttMessage mm) throws Exception {
//        System.out.println("TOPIC: " + topic);
//        System.out.println("MESSAGE: " + new String(mm.getPayload()));
//
////        // Non mi è chiaro cosa vuoi fare    <<<<<<<<<<<<<<<<<<<<<<<<<<<------------------------- 
////        if (topic.equals(Topics.ACK_LOGIN.getTopic() + "/" + clientID)) {
////
////            String message = new String(mm.getPayload());
////            if (message.equals("ERROR:1")) {
////                EventManager.getInstance().ackReceided(1);
////                System.out.println("ERROR:1");
////            }
////        }
////
////        if (topic.equals("UserConnected")) {
////            EventManager.getInstance().userConnected(new String(mm.getPayload()));
////        }
////        // -----------------------------------
////
////        if (topic.equals(subscribeMyChannel)) {
////            System.out.println("MESSAGGIO PER ME : " + new String(mm.getPayload()));
////        }
//    }    
//    public void tryLogin(String username, String encryptedPassword) throws MqttException {
//        String topic = Topics.ATTEMPT_LOGIN.getTopic() + "/" + clientID;
//        String message = username + "," + encryptedPassword;
//
//        topicSubscribe(Topics.ACK_LOGIN.getTopic());
//        publish(topic, message);
//    }    
    // --------------------------------------------------------------------------------------------------
}
