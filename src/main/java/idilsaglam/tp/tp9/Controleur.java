package idilsaglam.tp.tp9;

import javax.swing.*;

public class Controleur {
    private Modele modele;
    private Vue vue;
    JSlider slider = new JSlider();

    public void sliderMoved(){
        int value = slider.getValue();
    }

}
