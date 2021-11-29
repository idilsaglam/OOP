/* (C)2021 */
package idilsaglam.tp.tp9.controller;

import idilsaglam.tp.tp9.model.Modele;
import idilsaglam.tp.tp9.view.Slider;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderController {
  private Modele modele;
  private JSlider slider;
  private Slider.SliderType sliderType;

  /**
   * Crée une nouelle instance de SliderController
   *
   * @param modele Le modèle associé
   * @param slider Le slider associé
   * @param sliderType Le type de slider
   */
  public SliderController(Modele modele, JSlider slider, Slider.SliderType sliderType) {
    this.slider = slider;
    this.sliderType = sliderType;
    this.modele = modele;
    this.slider.addChangeListener(this.sliderMoved());
  }

  /**
   * Retourne la fonction change listener à ajouter dans le slider
   *
   * @return La fonction change listener pour le slider.
   */
  private ChangeListener sliderMoved() {
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
}
