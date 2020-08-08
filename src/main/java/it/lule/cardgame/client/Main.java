/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.lule.cardgame.client;

import it.lule.cardgame.client.mqtt.MQTTClient;

/**
 *
 * @author Luca
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("[CardGame-Client]Initializing..");
        //preloads data
        System.out.println("[CardGame-Client]Initializing.. [OK]");
        //insert loading GUI
        System.out.println("[CardGame-Client] bye");
        
        MQTTClient.getInstance().connect();
    }
}
