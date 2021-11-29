/* (C)2021 */
package idilsaglam.tp.tp9.view;

import idilsaglam.tp.tp9.controller.ButtonController;
import idilsaglam.tp.tp9.model.Modele;
import javax.swing.*;

public class Button extends JButton {

  public enum ButtonType {
    SAVE,
    LOAD,
    INVERSE;

    /**
     * Retourne le texte à afficher sur le bouton
     *
     * @return Le texte à afficher sur le bouton
     */
    private String getText() {
      return switch (this) {
        case LOAD -> "S'en rappeler";
        case SAVE -> "Mémoriser";
        case INVERSE -> "Complémentaire";
      };
    }

    /**
     * Retourne le text à afficher dans la bulle d'aide
     *
     * @return Le texte à afficher dans le bulle d'aide
     */
    private String getToolTipText() {
      return switch (this) {
        case LOAD -> "Remplace la couleur courante par la dernière couleur mémorisée";
        case SAVE -> "Mettre à jour la couleur courante en mémoire";
        case INVERSE -> "Remplace la couleur courante par sa couleur complémentaire";
      };
    }
  }

  private final ButtonController controller;

  /**
   * Crée un nouveau objet bouton
   *
   * @param modele Le modèle associé à ce bouton
   * @param type Le type de bouton
   */
  public Button(Modele modele, ButtonType type) {
    super();
    super.setText(type.getText());
    super.setToolTipText(type.getToolTipText());
    this.controller = new ButtonController(this, modele, type);
  }

  /**
   * Retourne le contrôleur associé à ce bouton
   *
   * @return Le contrôleur associé à ce bouton
   */
  protected ButtonController getController() {
    return this.controller;
  }
}
