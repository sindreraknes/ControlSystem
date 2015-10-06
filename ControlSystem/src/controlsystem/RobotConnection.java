/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlsystem;

import java.io.IOException;
import java.net.UnknownHostException;
import no.hials.crosscom.CrossComClient;
import no.hials.crosscom.KRL.KRLInt;

/**
 *
 * @author Minions
 */
public class RobotConnection {
    private CrossComClient connection;
    private String ipAddress;
    private int port;
    int state;
    KRLInt variable;
    public RobotConnection(){
    }
    public RobotConnection(String ipAddress, int port){
        this.port = port;
        this.ipAddress = ipAddress;
        this.state = 0;
        connect();
    }
    
    public int getState(){
        return this.state;
    }
    
    public void writeInt(String variableName, int value){
        variable = new KRLInt(variableName);
        variable.setValue(value);
        try{
            this.connection.writeVariable(variable);
        }
        catch(Exception e){
            System.out.println("Error writing to Robot");
        }
    }
    
    public int readInt(String variableName){
        variable = new KRLInt(variableName);
        try{
            this.connection.readVariable(variable);
        }
        catch(Exception e){
            System.out.println("Error writing to Robot");
        }
        return variable.getValue();
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
