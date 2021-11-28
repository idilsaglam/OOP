/* (C)2021 */
package idilsaglam.tp.tp9;

import java.awt.*;
import javax.swing.*;

public class Vue extends JFrame {


  private JPanel panneauColore;
  private JPanel panneauChoix;
  private Controleur c;

  private Modele m;

  public Vue() {
    this.setTitle("Palette");
    this.setSize(800, 600);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    this.panneauColore = new JPanel();
    this.panneauChoix = new JPanel();

    panneauColore.setBackground(Color.GREEN);

    JLabel etiqCouleur = new JLabel("Vert");
    etiqCouleur.setHorizontalAlignment(0);
    panneauColore.setLayout(new BorderLayout());
    panneauColore.add(etiqCouleur, BorderLayout.CENTER);

    panneauChoix.setLayout(new BorderLayout());
    this.getContentPane().add(panneauChoix);
    this.getContentPane().add(panneauColore);
    this.getContentPane().setLayout(new GridLayout());

    JComponent buttonContainer = new JPanel();
    buttonContainer.setOpaque(false);
    panneauChoix.add(buttonContainer, BorderLayout.PAGE_END);

    JButton btnMemoriser = new JButton();
    btnMemoriser.setText("Mémoriser");
    buttonContainer.add(btnMemoriser);

    JButton btnSenRappeler = new JButton();
    btnSenRappeler.setText("S'en rappeler");
    buttonContainer.add(btnSenRappeler);

    JButton btnComplementaire = new JButton();
    btnComplementaire.setText("Complémentaire");
    buttonContainer.add(btnComplementaire);

    miseAjour();
  }

  public String colorToRGB() {
    String red = Integer.toHexString(this.panneauColore.getBackground().getRed());
    String green = Integer.toHexString(this.panneauColore.getBackground().getGreen());
    String blue = Integer.toHexString(this.panneauColore.getBackground().getBlue());

    if (red.length() == 1) red = "0" + red;
    if (green.length() == 1) green = "0" + green;
    if (blue.length() == 1) blue = "0" + blue;
    return "#" + red + green + blue;
  }

  public void miseAjour() {
    m = new Modele(Color.red);
    this.panneauColore.setBackground(m.getColor());
    JLabel hex = new JLabel(colorToRGB());
    hex.setHorizontalAlignment(0);

    panneauColore.setLayout(new BorderLayout());
    panneauColore.add(hex, BorderLayout.CENTER);
  }

  public JPanel getPanneauColore() {
    return panneauColore;
  }

  public void setPanneauColore(JPanel panneauColore) {
    this.panneauColore = panneauColore;
  }

  public JPanel getPanneauChoix() {
    return panneauChoix;
  }

  public void setPanneauChoix(JPanel panneauChoix) {
    this.panneauChoix = panneauChoix;
  }

  public Controleur getC() {
    return c;
  }

  public void setC(Controleur c) {
    this.c = c;
  }

  public Modele getM() {
    return m;
  }

  public void setM(Modele m) {
    this.m = m;
  }
}
