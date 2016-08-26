package me.pixel.oscillator;

import java.awt.*;

/**
 * Oscillator
 * me.pixel.oscillator
 * Created by Pixel.
 */

public class WaveGenerator{

    int waveGeneratorMode = 0;

    Pixel[] pixels;

    public WaveGenerator(Pixel[] pixels){

    }

    public boolean generateLocation(Pixel pixel, int moveDistance, Dimension dimension){
        switch(waveGeneratorMode){
            case 0:
                int activateY = (int) Math.round(8 * Math.sin(Math.toRadians(pixel.getExactX() + moveDistance))) + 20;
                return (pixel.getY() == activateY);
            default: return false;
        }
    }
}
