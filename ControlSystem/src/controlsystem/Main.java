/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlsystem;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import no.hials.crosscom.KRL.KRLBool;


/**
 *
 * @author rakne
 */
public class Main implements Runnable {

    /**
     * @param args the command line arguments
     */
    private GUI gui;
    private RobotConnection KR120;
    private RobotConnection KR240;
    private RobotConnection KR16;
    private RobotConnection KR5;
    private PLCConnection PLCConnection;
    
    // KR120 Robot global variables
    private KRLBool KR120goHome = new KRLBool("goHome");
    
    // KR240 Robot global variables
    private KRLBool KR240goHome = new KRLBool("goHome");
    private KRLBool KR240gotoPipePickup = new KRLBool("gotoPipePickup");
    private KRLBool KR240positionPipe = new KRLBool("positionPipe");
    
    // KR16 Robot global variables
    private KRLBool KR16goHome = new KRLBool("goHome");
    
    // KR5 Robot global variables
    private KRLBool KR5goHome = new KRLBool("goHome");

    public static void main(String[] args) {
        new Thread(new Main()).start();
    }

    @Override
    public void run() {
        //Create connection to the PLC
        PLCConnection = new PLCConnection();
        new Thread(PLCConnection).start();
        //Closest to workstation
        KR120 = new RobotConnection("192.168.250.120", 7000);
        //Not closest to workstation
        KR240 = new RobotConnection("192.168.250.240", 7000);
        // Old welding robot
        KR5 = new RobotConnection("192.168.250.5", 7000);
        // New welding robot
        KR16 = new RobotConnection("192.168.250.16", 7000);
        
        //Create GUI for controlling the Robots
        gui = new GUI(KR120, KR240, KR16, KR5, PLCConnection);
    }
}
