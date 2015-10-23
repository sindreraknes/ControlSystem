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
    private RobotKR120 KR120;
    private RobotKR240 KR240;
    private RobotKR16 KR16;
    private RobotKR5 KR5;
    private PLCConnection PLCConnection;

    public static void main(String[] args) {
        new Thread(new Main()).start();
    }

    @Override
    public void run() {
        //Create connection to the PLC
        PLCConnection = new PLCConnection();
        new Thread(PLCConnection).start();
        
        //Closest to workstation
        KR120 = new RobotKR120("192.168.250.120", 7000);
        //Not closest to workstation
        KR240 = new RobotKR240("192.168.250.240", 7000);
        // Old welding robot
        KR5 = new RobotKR5("192.168.250.5", 7000);
        // New welding robot
        KR16 = new RobotKR16("192.168.250.16", 7000);
        
        //Create GUI for controlling the Robots
        gui = new GUI(KR120, KR240, KR16, KR5, PLCConnection);
    }
}
