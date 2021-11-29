/* (C)2021 */
package idilsaglam.tp.tp9.view;

import idilsaglam.tp.tp9.model.Modele;
import java.awt.*;
import javax.swing.*;

public class Vue extends JFrame {
  private PanneauColore panneauColore;
  private PanneauChoix panneauChoix;
  private Modele m;
  private JLabel etiqCouleur;

  /** Crée la vue */
  public Vue() {
    this.setTitle("Palette");
    this.setSize(800, 600);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.m = new Modele(Color.PINK, this);
    this.getContentPane().setLayout(new GridLayout());
    this.panneauChoix = new PanneauChoix(this.m);
    this.panneauColore = new PanneauColore(this.m);
    this.getContentPane().add(this.panneauChoix);
    this.getContentPane().add(this.panneauColore);
  }

  /** Mettre à jour le panneau avec la couleur et les sliders */
  public void misAjour() {
    this.updateColorPane();
    this.updateSliders();
  }

  /** Mettre à jour le panneau où la couleur s'affiche */
  public void updateColorPane() {
    this.panneauColore.misAjour();
  }

  /** Mettre à jour les sliders */
  public void updateSliders() {
    this.panneauChoix.misAjour();
  }
}
