/* (C)2021 */
package idilsaglam.tp.tp9.view;

import idilsaglam.tp.tp9.model.Modele;
import java.awt.*;
import javax.swing.*;

public class PanneauChoix extends JPanel {

  private Modele model;
  private ButtonsContainer buttonsContainer;
  private SlidersContainer slidersContainer;

  /**
   * Crée le panneau des choix
   *
   * @param model Le modèle associé au panneau des choix
   */
  public PanneauChoix(Modele model) {
    super();
    super.setLayout(new BorderLayout());
    this.model = model;
    this.slidersContainer = new SlidersContainer(this.model);
    this.buttonsContainer = new ButtonsContainer(this.model);
    super.add(this.buttonsContainer, BorderLayout.PAGE_END);
    super.add(this.slidersContainer, BorderLayout.CENTER);
  }

  /** Mettre à jour le sliders */
  public void misAjour() {
    this.slidersContainer.misAjour();
  }
}
