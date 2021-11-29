/* (C)2021 */
package idilsaglam.tp.tp9.view;

import idilsaglam.tp.tp9.model.Modele;
import java.awt.*;
import javax.swing.*;

public class PanneauColore extends JPanel {

  private final Modele model;
  private JLabel etiquette;

  /**
   * Crée le panneau coloré
   *
   * @param modele Le modèle associé au panneau coloré
   */
  public PanneauColore(Modele modele) {
    super();
    this.model = modele;
    this.etiquette = new JLabel(this.model.getHEX());
    this.etiquette.setHorizontalAlignment(0);
    super.setLayout(new BorderLayout());
    super.add(this.etiquette, BorderLayout.CENTER);
    this.misAjour();
  }

  /** Mettre à jour l'arrière plan et l'étiquette */
  public void misAjour() {
    super.setBackground(this.model.getColor());
    this.etiquette.setText(this.model.getHEX());
  }
}
