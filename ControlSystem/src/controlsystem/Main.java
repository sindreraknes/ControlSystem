/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlsystem;

import no.hials.crosscom.KRL.KRLInt;
import no.hials.crosscom.KRL.KRLReal;
import no.hials.crosscom.KRL.KRLVariable;

/**
 *
 * @author rakne
 */
public class Main implements Runnable {

    /**
     * @param args the command line arguments
     */
    private RobotConnection weldingRobot;

    public static void main(String[] args) {

        new Thread(new Main()).start();
    }

    @Override
    public void run() {
        weldingRobot = new RobotConnection("129.241.64.185", 7000);
        KRLInt jog = new KRLInt("TESTDIS");
        int i = 1;
        while (true) {
            i++;
            try {
                Thread.sleep(2000);
                jog.setValue(1);
                weldingRobot.getConnection().writeVariable(jog);
                weldingRobot.getConnection().readVariable(jog);
                System.out.println(jog);
                Thread.sleep(2000);
                jog.setValue(10);
                weldingRobot.getConnection().writeVariable(jog);
            } catch (Exception e) {

            }

        }
    }
}
