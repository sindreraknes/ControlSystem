/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlsystem;

import no.hials.crosscom.KRL.KRLBool;

/**
 *
 * @author rakne
 */
// KR120 Robot global variables


public class RobotKR120 extends RobotConnection {

    private KRLBool KR120goHome = new KRLBool("goHome");
    
    public RobotKR120(String ipAddress, int port){
        super(ipAddress, port);
    }
    
    public void goHome(){
        KR120goHome.setValue(true);
        writeBoolean(KR120goHome);
    }
    
}
