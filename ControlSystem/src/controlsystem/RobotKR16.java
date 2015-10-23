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
public class RobotKR16 extends RobotConnection {
    private KRLBool KR16goHome = new KRLBool("goHome");
    
    public RobotKR16(String ipAddress, int port){
        super(ipAddress, port);
    }
    
    public void goHome(){
        KR16goHome.setValue(true);
        writeBoolean(KR16goHome);
    }
}
