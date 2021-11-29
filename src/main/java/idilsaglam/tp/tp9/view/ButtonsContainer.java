/* (C)2021 */
package idilsaglam.tp.tp9.view;

import idilsaglam.tp.tp9.model.Modele;
import javax.swing.*;

public class ButtonsContainer extends JPanel {

  private final Button saveButton, loadButton, inverseButton;

  /**
   * Crée une nouvelle instance de boutons container
   *
   * @param model Le modèle associé
   */
  public ButtonsContainer(Modele model) {
    super();
    super.setOpaque(false);
    this.saveButton = new Button(model, Button.ButtonType.SAVE);
    this.loadButton = new Button(model, Button.ButtonType.LOAD);
    this.inverseButton = new Button(model, Button.ButtonType.INVERSE);
    super.add(saveButton);
    super.add(loadButton);
    super.add(inverseButton);
  }
}
