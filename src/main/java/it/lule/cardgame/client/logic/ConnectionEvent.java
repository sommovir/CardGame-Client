/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.lule.cardgame.client.logic;

/**
 *
 * @author lele
 */
public interface ConnectionEvent {
    public void userConnected(String nickName);
    
    public void ackReceived(int error);
    
}
