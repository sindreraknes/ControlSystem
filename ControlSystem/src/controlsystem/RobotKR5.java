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
public class RobotKR5 extends RobotConnection {
    
    private KRLBool KR5isWelding = new KRLBool("isWelding");
    
    public RobotKR5(String ipAddress, int port){
        super(ipAddress, port);
    }
    
    public void startWelding(){
        KR5isWelding.setValue(true);
        writeBoolean(KR5isWelding);
    }
    
    public void stopWelding(){
        KR5isWelding.setValue(false);
        writeBoolean(KR5isWelding);
    }
    
}
