/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlsystem;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


/**
 *
 * @author rakne
 */


public class PLCConnection implements Runnable {
    
    private ServerSocket serverSocket;
    private Socket connectionSocket;
    private OutputStream os;
     private byte[] byteArray = new byte [8];
    
    public PLCConnection(){
        try{
            serverSocket = new ServerSocket(7005);
        }
        catch (IOException e){
            
        }
    }

    @Override
    public void run() {
        try{
            System.out.println("Waiting for connection");
            connectionSocket = serverSocket.accept();
            System.out.println("Connection established");
            os = connectionSocket.getOutputStream();
        }
        catch (Exception e){
            
        }
    }
    
    public void closeGripper120(){
        // 1 - Open, 2 - Close, [0] - 120, [1] - 240
       byteArray[0] = 2;
       byteArray[1] = 0;
       byteArray[2] = 0;
       byteArray[3] = 0;
       byteArray[4] = 0;
       byteArray[5] = 0;
       byteArray[6] = 0;
       byteArray[7] = 0;
        
        try{
                os.write(byteArray);
                os.flush();
        }
        catch (Exception e){ 
        }
    }
    
    public void openGripper120(){
     // 1 - Open, 2 - Close, [0] - 120, [1] - 240
       byteArray[0] = 1;
       byteArray[1] = 0;
       byteArray[2] = 0;
       byteArray[3] = 0;
       byteArray[4] = 0;
       byteArray[5] = 0;
       byteArray[6] = 0;
       byteArray[7] = 0;
        
        try{
                os.write(byteArray);
                os.flush();
        }
        catch (Exception e){ 
        }    
    }
    
    public void closeGripper240(){
     // 1 - Open, 2 - Close, [0] - 120, [1] - 240
       byteArray[0] = 0;
       byteArray[1] = 2;
       byteArray[2] = 0;
       byteArray[3] = 0;
       byteArray[4] = 0;
       byteArray[5] = 0;
       byteArray[6] = 0;
       byteArray[7] = 0;
        
        try{
                os.write(byteArray);
                os.flush();
        }
        catch (Exception e){ 
        }    
    }
    
    public void openGripper240(){
     // 1 - Open, 2 - Close, [0] - 120, [1] - 240
       byteArray[0] = 0;
       byteArray[1] = 1;
       byteArray[2] = 0;
       byteArray[3] = 0;
       byteArray[4] = 0;
       byteArray[5] = 0;
       byteArray[6] = 0;
       byteArray[7] = 0;
        
        try{
                os.write(byteArray);
                os.flush();
        }
        catch (Exception e){ 
        }    
    }
}
