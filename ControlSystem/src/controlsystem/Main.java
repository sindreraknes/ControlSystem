/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlsystem;


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

    public static void main(String[] args) {

        new Thread(new Main()).start();
    }

    @Override
    public void run() {
        weldingRobot = new RobotConnection("129.241.64.185", 7000);
        gui = new GUI(weldingRobot);
        gui.setVisible(true);
        
        while (true) {

            try {
                Thread.sleep(100);
                if(weldingRobot.getTest() == true){
                    weldingRobot.setGoHome(true);
                    System.out.println("CLICKED IT");
                    Thread.sleep(500);
                    weldingRobot.setGoHome(false);
                    weldingRobot.setTest(false);
                }
                
            } catch (Exception e) {

            }

        }
    }
}
