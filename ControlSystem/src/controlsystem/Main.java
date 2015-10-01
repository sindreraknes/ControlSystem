/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlsystem;

import javax.swing.JOptionPane;
import no.hials.crosscom.CrossComClient;
import no.hials.crosscom.KRL.KRLReal;

/**
 *
 * @author rakne
 */
public class Main implements Runnable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        new Thread(new Main()).start();
    }

    @Override
    public void run() {
        CrossComClient pipeRobot;
        //String ipWeldRobot = JOptionPane.showInputDialog(null, "IP Adress of welding robot");
        //String ipFlangeRobot = JOptionPane.showInputDialog(null, "IP Adress of flange robot");
        String ipPipeRobot = JOptionPane.showInputDialog(null, "IP Adress pipe robot");
        try{
            //CrossComClient weldRobot = new CrossComClient(ipWeldRobot, 7000);
            //CrossComClient flangeRobot = new CrossComClient(ipFlangeRobot, 7000);
            pipeRobot = new CrossComClient(ipPipeRobot, 7000);
            KRLReal jog = KRLReal.OV_JOG();
            pipeRobot.readVariable(jog);
            System.out.println(jog);
            
            jog.setValue(13.5);
            pipeRobot.writeVariable(jog);
            pipeRobot.readVariable(jog);
            System.out.println(jog);
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Exception");
        }
        
        
        
    }
    
}
