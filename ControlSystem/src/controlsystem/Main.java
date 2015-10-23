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
    private RobotConnection weldingRobot;
    private ServerSocket serverSocket;
    private byte[] byteArray = new byte [8];

    public static void main(String[] args) {

        new Thread(new Main()).start();
    }

    @Override
    public void run() {
       // 1 - Open, 2 - Close, [0] - 120, [1] - 240
       byteArray[0] = 1;
       byteArray[1] = 1;
       byteArray[2] = 0;
       byteArray[3] = 0;
       byteArray[4] = 0;
       byteArray[5] = 0;
       byteArray[6] = 0;
       byteArray[7] = 0;
        
        try{
            serverSocket = new ServerSocket(7005);
            
            while(true){
                Socket connectionSocket = serverSocket.accept();
                System.out.println("Connection established");
                OutputStream os = connectionSocket.getOutputStream();
                os.write(byteArray);
                os.flush();
            
            }
        }
        catch (Exception e){ 
        }
        
    }
}
