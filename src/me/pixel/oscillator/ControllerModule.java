package me.pixel.oscillator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Oscillator
 * me.pixel.oscillator
 * Created by Pixel.
 */

public class ControllerModule extends JFrame{

    Dimension dimension = new Dimension(300, 100);
    ControllerPanel controllerPanel;

    public ControllerModule(){
        controllerPanel = new ControllerPanel();
    }

    public Dimension getDimension(){
        return dimension;
    }

    public ControllerPanel getControllerPanel(){
        return controllerPanel;
    }
}
