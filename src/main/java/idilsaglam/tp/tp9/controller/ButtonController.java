/* (C)2021 */
package idilsaglam.tp.tp9.controller;

import idilsaglam.tp.tp9.model.Modele;
import idilsaglam.tp.tp9.view.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ButtonController {
  private final JButton button;
  private final Modele model;
  private final Button.ButtonType buttonType;

  /**
   * Crée un nouveau button controller
   *
   * @param button Le bouton associé
   * @param model Le modèle associé
   * @param buttonType Le type de bouton
   */
  public ButtonController(JButton button, Modele model, Button.ButtonType buttonType) {
    this.button = button;
    this.model = model;
    this.button.addActionListener(this.buttonClicked());
    this.buttonType = buttonType;
  }

  /**
   * Retourne la fonction action listener pour le bouton associé
   *
   * @return La fonction action listener pour le bouton associé
   */
  private ActionListener buttonClicked() {
    return (ActionEvent e) -> {
      switch (this.buttonType) {
        case INVERSE -> this.model.setComplementaire();
        case LOAD -> this.model.load();
        case SAVE -> this.model.save();
      }
    };
  }
}
