/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.lule.cardgame.client.logic;

import java.util.Arrays;

/**
 *  !!!!!!!!!!!!LEGGIMI!!!!!!!!!!!!
 * Consiglieri di mettere questa classe come libreria sia sul client che sul server per avere un doppio controllo
 * Valutiamo l'idea di renderlo statico per fare una cosa cosi
 * ManagementPassword.checkPasswordRegistration(.....)
 * @author lele
 */
public class  ManagementPassword {
    public ManagementPassword() {
    }

    public boolean checkPasswordRegistration(String nickName, 
            char[] jPasswordField1, char[] jPasswordField2) {
        
        if (jPasswordField1.length == 0 || 
                jPasswordField2.length == 0 || nickName.isEmpty()){
            return false;
        }        

        if (!Arrays.equals(jPasswordField1, jPasswordField2)) {
            return false;
        }

        return true;
    }
    
    public boolean checkPasswordlogin(String nickName, char[] jPasswordField1){
            if (jPasswordField1.length == 0 || nickName.isEmpty()){
            return false;
        }  
        return true;
    }
}
