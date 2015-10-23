/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlsystem;

import java.io.IOException;
import java.net.UnknownHostException;
import no.hials.crosscom.CrossComClient;
import no.hials.crosscom.KRL.KRLBool;
import no.hials.crosscom.KRL.structs.KRLFrame;

/**
 *
 * @author Minions
 */
public class RobotConnection {
    private CrossComClient connection;
    private String ipAddress;
    private int port;
    public RobotConnection(){
    }
    public RobotConnection(String ipAddress, int port){
        this.port = port;
        this.ipAddress = ipAddress;
        
        connect();
    }
    
    public boolean readBoolean(KRLBool bool){
        try{
            this.connection.readVariable(bool);
        }
        catch(Exception e){
            System.out.println("Error writing bool to Robot");
        }
        
        return bool.getValue();
    }
    public void writeBoolean(KRLBool bool){
        try{
            this.connection.writeVariable(bool);
        }
        catch(Exception e){
            System.out.println("Error writing bool to Robot");
        }
    }

    public void writeFrame(String frameName, double X, double Y, double Z, double A, double B, double C){
        KRLFrame frame = new KRLFrame(frameName);
        frame.setX(X);
        frame.setY(Y);
        frame.setZ(Z);
        frame.setA(A);
        frame.setB(B);
        frame.setC(C);
        try{
            this.connection.writeVariable(frame);
        }
        catch(Exception e){
            System.out.println("Error writing frame to Robot");
        }
    }
    public String readFrame(String frameName){
        KRLFrame frame = new KRLFrame(frameName);
        try{
            this.connection.readVariable(frame);
        }
        catch(Exception e){
            System.out.println("Error reading frame from Robot");
        }
        return "Frame: "+frameName + ", X: "+frame.getX() +", Y: "+frame.getY() +", Z: "+frame.getZ() +", A: "+frame.getA() +", B :"+frame.getB() +", C : " +frame.getC();
    }
    
    
    private void connect(){
        try{
            setConnection(new CrossComClient(getIpAddress(), getPort()));
        }
        catch(UnknownHostException e){
            System.err.println("Unknown host exception");
        }
        catch(IOException e){
            System.err.println("IOException");
        }
        
    }

    /**
     * @return the connection
     */
    public CrossComClient getConnection() {
        return connection;
    }

    /**
     * @param connection the connection to set
     */
    public void setConnection(CrossComClient connection) {
        this.connection = connection;
    }

    /**
     * @return the ipAddress
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * @param ipAddress the ipAddress to set
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    /**
     * @return the port
     */
    public int getPort() {
        return port;
    }

    /**
     * @param port the port to set
     */
    public void setPort(int port) {
        this.port = port;
    }
}
