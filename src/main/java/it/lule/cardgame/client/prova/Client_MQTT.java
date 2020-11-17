/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.lule.cardgame.client.prova;

import it.lule.cardgame.client.logic.EventManager;
import it.lule.cardgame.client.logic.Topics;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttConnect;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 *
 * @author lele
 */
public class Client_MQTT implements MqttCallback {

    public static Client_MQTT instance = null;
    private final int qos = 2;
    private MqttClient client = null;
    private String subscribeChannel = "unknown";
    private final String clientID = "" + new Date().getTime();

    String broker = "tcp://0.0.0.0:1883";

    public static Client_MQTT getInstance() {
        if (instance == null) {
            instance = new Client_MQTT();
        }
        return instance;
    }

    /* inizializza il client */
    private Client_MQTT() {
        super();
        initClient();
    }

    /* inizializza il client */
    private void initClient() {
        try {
            client = new MqttClient(broker, clientID, new MemoryPersistence());
        } catch (MqttException ex) {
            Logger.getLogger(Client_MQTT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void connect() throws MqttException {
        initializeConnection();
    }

    /**
     * inizializza il client e accede a un canale
     */
    private void initializeConnection() throws MqttException {
        initClient();

        MqttConnectOptions connectOptions = new MqttConnectOptions();
        connectOptions.setCleanSession(true);

        /* Conneting to Broker */
        client.connect(connectOptions);

        /* Public message */
        publish("UserConnected", "Client " + clientID + " is connected. " + "\n");

        /* subscribe section */
        client.subscribe("UserConnected");
        client.setCallback(this);

    }

    public void tryLogin(String username, String encryptedPassword) throws MqttException {
        String topic = Topics.ATTEMPT_LOGIN.getTopic() + "/" + clientID;
        String message = username + "," + encryptedPassword;
        
        topicSubscribe(Topics.ACK_LOGIN.getTopic());
        publish(topic, message);
    }

    /**
     * Check Connection
     * @throws MqttException 
     */
    private void checkConnection() throws MqttException{
        if (client == null || client.isConnected()) {
            initClient();
            initializeConnection();
        }        
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

    /* subscribe to channel */
    public void topicSubscribe(String topic) throws MqttException {
        checkConnection();
        client.subscribe(topic);

    }

    /* unsubscribe to channel */
    public void topicUnsubscribe(String topic) throws MqttException {
        checkConnection();
        client.unsubscribe(topic);
    }

    @Override
    public void connectionLost(Throwable thrwbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void messageArrived(String topic, MqttMessage mm) throws Exception {
        System.out.println("TOPIC: " + topic);
        System.out.println("MESSAGE: " + new String(mm.getPayload()));

        // Non mi è chiaro cosa vuoi fare    <<<<<<<<<<<<<<<<<<<<<<<<<<<------------------------- 
        if (topic.equals(Topics.ACK_LOGIN.getTopic() + "/" + clientID)) {

            String message = new String(mm.getPayload());
            if (message.equals("ERROR:1")) {
                EventManager.getInstance().ackReceided(1);
                System.out.println("ERROR:1");
            }
        }

        if (topic.equals("UserConnected")) {
            EventManager.getInstance().userConnected(new String(mm.getPayload()));
        }
        // -----------------------------------

        if (topic.equals(subscribeChannel)) {
            System.out.println("MESSAGGIO PER ME : " + new String(mm.getPayload()));
        }
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken imdt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
