/* (C)2021 */
package idilsaglam.tp.tp9;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Controleur {
  private Modele modele;
  private JSlider slider;
  private SliderType sliderType;

  public Controleur(Modele modele, JSlider slider, SliderType sliderType) {
    this.slider = slider;
    this.sliderType = sliderType;
    this.modele = modele;
    this.slider.addChangeListener(this.sliderMoved());
  }

  public ChangeListener sliderMoved() {
    return (ChangeEvent e) -> {
      int value = slider.getValue();
      switch (this.sliderType) {
        case RED -> this.modele.setColorR(value);
        case BLUE -> this.modele.setColorB(value);
        case ALPHA -> this.modele.setColorA(value);
        case GREEN -> this.modele.setColorG(value);
      }
    };
  }

  public static enum SliderType {
    RED,
    GREEN,
    BLUE,
    ALPHA
  }
}
