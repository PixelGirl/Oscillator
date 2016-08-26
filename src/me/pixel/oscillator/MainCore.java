package me.pixel.oscillator;

import javax.swing.*;

/**
 * Oscillator
 * me.pixel.oscillator
 * Created by Pixel.
 */

public class MainCore{

    public static void main(String[] args){

        DisplayModule displayModule = new DisplayModule();
        displayModule.setPreferredSize(displayModule.getWindowSize());
        displayModule.init();

        JFrame displayFrame = new JFrame();
        displayFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        displayFrame.getContentPane().add(displayModule);
        displayFrame.pack();
        displayFrame.setVisible(true);

        displayModule.start();

        ControllerModule controllerModule = new ControllerModule();

        ControllerPanel controllerPanel = controllerModule.getControllerPanel();
        controllerPanel.addListener(displayModule);
        controllerModule.add(controllerPanel);
        controllerModule.setSize(controllerModule.getDimension());
        controllerModule.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controllerModule.setVisible(true);
    }
}
