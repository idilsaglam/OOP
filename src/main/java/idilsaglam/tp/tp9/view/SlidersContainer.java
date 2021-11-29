/* (C)2021 */
package idilsaglam.tp.tp9.view;

import idilsaglam.tp.tp9.model.Modele;
import java.awt.*;
import java.util.Hashtable;
import javax.swing.*;

public class SlidersContainer extends JPanel {
  private final Modele model;
  private final Slider redSlider, greenSlider, blueSlider, alphaSlider;

  /**
   * Crée un nouveau SliderContainer
   *
   * @param model Le modèle associé à ce slider container
   */
  public SlidersContainer(Modele model) {
    super(new GridLayout(4, 1));
    this.model = model;
    Hashtable<Integer, JLabel> labels = new Hashtable<>();
    for (int i = 0; i < 255; i = i + 25) {
      labels.put(i, new JLabel("" + i));
    }
    this.redSlider = new Slider(labels, this.model, Slider.SliderType.RED);
    this.blueSlider = new Slider(labels, this.model, Slider.SliderType.BLUE);
    this.greenSlider = new Slider(labels, this.model, Slider.SliderType.GREEN);
    this.alphaSlider = new Slider(labels, this.model, Slider.SliderType.ALPHA);
    super.add(this.redSlider);
    super.add(this.greenSlider);
    super.add(this.blueSlider);
    super.add(this.alphaSlider);
  }

  /** Mettre à jour les sliders */
  public void misAjour() {
    Color c = this.model.getColor();
    this.redSlider.setValue(c.getRed());
    this.blueSlider.setValue(c.getBlue());
    this.greenSlider.setValue(c.getGreen());
    this.alphaSlider.setValue(c.getAlpha());
  }
}
