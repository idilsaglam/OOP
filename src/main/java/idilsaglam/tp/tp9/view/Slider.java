/* (C)2021 */
package idilsaglam.tp.tp9.view;

import idilsaglam.tp.tp9.controller.SliderController;
import idilsaglam.tp.tp9.model.Modele;
import java.util.Hashtable;
import javax.swing.*;

public class Slider extends JSlider {

  private final SliderController controller;

  /**
   * Crée une nouvelle instance de Slider
   *
   * @param labels Les étiquettes à afficher en bas de slider
   * @param modele Le modèle associé a ce slider
   * @param type Le type de slider
   */
  public Slider(Hashtable<Integer, JLabel> labels, Modele modele, SliderType type) {
    super();
    super.setValue(type.getDefaultCouleur(modele));
    super.setToolTipText(type.getToolTipText());
    super.setPaintTicks(true);
    super.setMinimum(0);
    super.setMaximum(255);
    super.setMinorTickSpacing(5);
    super.setMajorTickSpacing(25);
    super.setLabelTable(labels);
    super.setPaintLabels(true);
    this.controller = new SliderController(modele, this, type);
  }

  protected SliderController getController() {
    return this.controller;
  }

  public enum SliderType {
    RED,
    GREEN,
    BLUE,
    ALPHA;

    /**
     * Retourne la valeur de la couleur par défaut pour le slider courant
     *
     * @param model Le model depuis lequel la couleur va être récupéré
     * @return La valeur par défaut de slider courant
     */
    private int getDefaultCouleur(Modele model) {
      return switch (this) {
        case BLUE -> model.getColor().getBlue();
        case ALPHA -> model.getColor().getAlpha();
        case RED -> model.getColor().getRed();
        case GREEN -> model.getColor().getGreen();
      };
    }

    /**
     * Retourne le texte à afficher dans la bulle d'aide
     *
     * @return Le texte à afficher dans la bulle d'aide
     */
    private String getToolTipText() {
      return String.format(
          "Set %s channel value",
          switch (this) {
            case GREEN -> "green";
            case ALPHA -> "alphe";
            case BLUE -> "blue";
            case RED -> "red";
          });
    }
  }
}
