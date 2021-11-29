/* (C)2021 */
package idilsaglam.tp.tp9;

import java.awt.*;
import javax.swing.*;

public class Vue extends JFrame {

  public Controleur c = new Controleur();
  private JPanel panneauColore;
  private JPanel panneauChoix;
  private Modele m;
  private JSlider slider;
  private JLabel etiqCouleur;

  public Vue() {
    this.setTitle("Palette");
    this.setSize(800, 600);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.m = new Modele(Color.red, this);

    this.etiqCouleur = new JLabel(this.m.colorToRGB());
    this.panneauColore = this.initPaneauColore();
    this.panneauChoix = this.initPanneauChoix();

    this.getContentPane().add(this.panneauChoix);
    this.getContentPane().add(this.panneauColore);
    this.getContentPane().setLayout(new GridLayout());
    this.panneauChoix.add(initButtons(), BorderLayout.PAGE_END);
    this.panneauChoix.add(initSliders(), BorderLayout.CENTER);
    miseAjour();
  }

  private JPanel initPanneauChoix() {
    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout());
    return panel;
  }

  private JPanel initPaneauColore() {
    JPanel panel = new JPanel();
    panel.setBackground(Color.GREEN);
    panel.setLayout(new BorderLayout());
    etiqCouleur.setHorizontalAlignment(0);
    panel.add(etiqCouleur, BorderLayout.CENTER);
    return panel;
  }

  private JPanel initButtons() {
    JPanel buttonContainer = new JPanel();
    buttonContainer.setOpaque(false);

    JButton btnMemoriser = new JButton();
    btnMemoriser.setText("Mémoriser");
    buttonContainer.add(btnMemoriser);

    JButton btnSenRappeler = new JButton();
    btnSenRappeler.setText("S'en rappeler");
    buttonContainer.add(btnSenRappeler);

    JButton btnComplementaire = new JButton();
    btnComplementaire.setText("Complémentaire");
    buttonContainer.add(btnComplementaire);
    return buttonContainer;
  }

  public void miseAjour() {
    this.panneauColore.setBackground(m.getColor());
    this.etiqCouleur.setText(this.m.colorToRGB());
  }

  private JPanel initSliders() {
    JPanel p = new JPanel(new GridLayout(4, 1));
    JSlider slider1 = new JSlider();
    JSlider slider2 = new JSlider();
    JSlider slider3 = new JSlider();
    JSlider slider4 = new JSlider();

    p.add(slider1);
    p.add(slider2);
    p.add(slider3);
    p.add(slider4);
    return p;
  }
}
