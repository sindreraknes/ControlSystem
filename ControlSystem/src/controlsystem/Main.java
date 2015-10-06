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
        while (true) {
            try {
                Thread.sleep(2000);
                weldingRobot.writeInt("State", 1);
                int state = weldingRobot.readInt("State");
                System.out.println(state);
                Thread.sleep(2000);
                weldingRobot.writeInt("State", 10);
                state = weldingRobot.readInt("State");
                System.out.println(state);
            } catch (Exception e) {

            }

        }
    }
}
