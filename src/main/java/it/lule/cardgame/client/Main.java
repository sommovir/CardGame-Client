/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.lule.cardgame.client;

import it.lule.cardgame.client.mqtt.MainGUI;
import it.lule.cardgame.client.gui.panels.login.LoginDialog;
import it.lule.cardgame.client.mqtt.MQTTClient;
import javax.swing.JFrame;

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
        
            /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginDialog(new JFrame(), true).setVisible(true);
                
                System.out.println("dasdasdasdasdasdasdasdasdas");
//                new MainGUI().setVisible(true);
            }
        
        });
        
        
    }
}
