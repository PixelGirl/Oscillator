package me.pixel.oscillator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Oscillator
 * me.pixel.oscillator
 * Created by Pixel.
 */

public class ControllerPanel extends JPanel{

    public boolean oscillating = false;

    public ControllerPanel(){
        JButton oscillate = new JButton("Oscillate");
        oscillate.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(oscillating){
                    oscillate.setText("Oscillate");
                    oscillating = false;
                    notifyListeners(false);
                }else{
                    oscillate.setText("Stop");
                    oscillating = true;
                    notifyListeners(true);
                }
            }
        });
        this.add(oscillate);
    }

    private List<OscillatingStatusChangeListener> listeners = new ArrayList<OscillatingStatusChangeListener>();

    public void addListener(OscillatingStatusChangeListener listener){
        listeners.add(listener);
    }

    private void notifyListeners(boolean status){
        for(OscillatingStatusChangeListener listener : listeners){
            listener.onStatusChange(status);
        }
    }
}
