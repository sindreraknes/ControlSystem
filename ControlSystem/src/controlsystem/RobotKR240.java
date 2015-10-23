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
public class RobotKR240 extends RobotConnection {
    
    private KRLBool KR240goHome = new KRLBool("goHome");
    private KRLBool KR240gotoPipePickup = new KRLBool("gotoPipePickup");
    private KRLBool KR240positionPipe = new KRLBool("positionPipe");
    
    public RobotKR240(String ipAddress, int port){
        super(ipAddress, port);
    }
    
    public void goHome(){
        KR240goHome.setValue(true);
        writeBoolean(KR240goHome);
    }
    
    public void gotoPipePickup(){
        KR240gotoPipePickup.setValue(true);
        writeBoolean(KR240gotoPipePickup);
    }
    
    public void positionPipe(){
        KR240positionPipe.setValue(true);
        writeBoolean(KR240positionPipe);
    }
}
