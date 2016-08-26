package me.pixel.oscillator;
import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Oscillator
 * me.pixel.oscillator
 * Created by Pixel.
 */

public class DisplayModule extends Applet implements OscillatingStatusChangeListener, ActionListener {

    private Graphics globalGraphics = null;
    WaveGenerator waveGenerator;
    Timer timer = new Timer(10, this);
    int moveDistance = 0;
    Pixel[] pixels;
    int windowWidth = 600;
    int windowHeight = 200;
    Dimension windowSize = new Dimension(windowWidth, windowHeight);
    int pixelSize = 5;
    int pixelAmount = (windowWidth / pixelSize) * (windowHeight / pixelSize);
    Color specialColour = new Color(62, 213, 192);
    Color specialColour2 = new Color(180, 229, 222);
    Color defaultPixelColour = new Color(0, 0, 0);
    Color activatedPixelColour = new Color(255, 255, 255);
    boolean initialized = false;
    boolean oscillate = false;

    public void paint(Graphics g){
        this.setSize(windowSize);
        globalGraphics = g.create();
    }

    public void showPixel(Pixel pixel, Color colour){
        globalGraphics.setColor(colour);
        globalGraphics.fillRect(pixel.getExactX(), pixel.getExactY(), pixel.getGlobalPixelSize(), pixel.getGlobalPixelSize());
    }

    public void init(){
        pixels = new Pixel[pixelAmount];
        for(int i = 1; i < pixelAmount + 1; i++){
            int x = (int) Math.floor((i % (windowWidth / pixelSize)));
            if(x == 0){
                x = (windowWidth / pixelSize);
            }
            int y = ((i - 1) / (windowWidth / pixelSize));
            Pixel pixel = new Pixel(i, pixelSize, x, y, defaultPixelColour);
            pixels[i - 1] = pixel;
        }
        for(Pixel pixel : pixels){
            pixel.setColour(defaultPixelColour);
        }
        waveGenerator = new WaveGenerator(pixels);
        initialized = true;
    }

    public void start(){
        System.out.println("DisplayModule started.");
    }

    public Dimension getWindowSize(){
        return windowSize;
    }

    public void onStatusChange(boolean status){
        this.oscillate = status;
        if(oscillate){
            timer.start();
        }else{
            timer.stop();
        }
    }

    public void setOscillating(boolean oscillate){
        this.oscillate = oscillate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(moveDistance > 350){
            moveDistance = 0;
        }
        for(Pixel pixel : pixels){
            if(waveGenerator.generateLocation(pixel, moveDistance, windowSize)){
                showPixel(pixel, activatedPixelColour);
            }else{
                showPixel(pixel, defaultPixelColour);
            }
        }
        moveDistance = moveDistance + 2;
    }
}
