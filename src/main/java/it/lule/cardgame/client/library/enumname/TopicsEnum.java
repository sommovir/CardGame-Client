/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.lule.cardgame.client.library.enumname;

/**
 *
 * @author Luca
 */
public enum TopicsEnum {

    ATTEMPT_LOGIN("attempt_login"),
    ATTEMPT_LOGIN_RESPONSE("attempt_login_response"),
    ACK_LOGIN("ack_login");
    
    private TopicsEnum(String topic) {
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }
    
    
    
    
    private String topic;
}
