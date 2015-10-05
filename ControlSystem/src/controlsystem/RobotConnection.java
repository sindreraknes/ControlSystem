/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlsystem;

import java.io.IOException;
import java.net.UnknownHostException;
import no.hials.crosscom.CrossComClient;

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
