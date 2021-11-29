/* (C)2021 */
package idilsaglam.tp.tp9;

import java.awt.*;
import java.util.Hashtable;
import javax.swing.*;

public class Vue extends JFrame {
  private JPanel panneauColore;
  private JPanel panneauChoix;
  private Modele m;
  private JLabel etiqCouleur;

  private JSlider slider1, slider2, slider3, slider4;

  public Vue() {
    this.setTitle("Palette");
    this.setSize(800, 600);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.m = new Modele(Color.PINK, this);

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
    Hashtable<Integer, JLabel> labels = new Hashtable<>();
    for (int i = 0; i < 255; i = i + 25) {
      labels.put(i, new JLabel("" + i));
    }

    this.slider1 = new JSlider();
    this.slider1.setValue(this.m.getColor().getRed());
    this.slider1.setToolTipText("Change red channel value");
    this.slider1.setPaintTicks(true);
    this.slider1.setMinimum(0);
    this.slider1.setMaximum(255);
    this.slider1.setMinorTickSpacing(5);
    this.slider1.setMajorTickSpacing(25);
    this.slider1.setLabelTable(labels);
    this.slider1.setPaintLabels(true);

    this.slider2 = new JSlider();
    this.slider2.setValue(this.m.getColor().getGreen());
    this.slider2.setToolTipText("Change green channel value");
    this.slider2.setPaintTicks(true);
    this.slider2.setMinimum(0);
    this.slider2.setMaximum(255);
    this.slider2.setMinorTickSpacing(5);
    this.slider2.setMajorTickSpacing(25);
    this.slider2.setLabelTable(labels);
    this.slider2.setPaintLabels(true);

    this.slider3 = new JSlider();
    this.slider3.setValue(this.m.getColor().getBlue());
    this.slider3.setToolTipText("Change blue channel value");
    this.slider3.setPaintTicks(true);
    this.slider3.setMinimum(0);
    this.slider3.setMaximum(255);
    this.slider3.setMinorTickSpacing(5);
    this.slider3.setMajorTickSpacing(25);
    this.slider3.setLabelTable(labels);
    this.slider3.setPaintLabels(true);

    this.slider4 = new JSlider();
    this.slider4.setValue(this.m.getColor().getAlpha());
    this.slider4.setToolTipText("Change alpha channel value");
    this.slider4.setPaintTicks(true);
    this.slider4.setMinimum(0);
    this.slider4.setMaximum(255);
    this.slider4.setMinorTickSpacing(5);
    this.slider4.setMajorTickSpacing(25);
    this.slider4.setLabelTable(labels);
    this.slider4.setPaintLabels(true);

    Controleur controleurRed = new Controleur(this.m, this.slider1, Controleur.SliderType.RED);
    Controleur controleurBlue = new Controleur(this.m, this.slider2, Controleur.SliderType.GREEN);
    Controleur controleurGreen = new Controleur(this.m, this.slider3, Controleur.SliderType.BLUE);
    Controleur controleurAlpha = new Controleur(this.m, this.slider4, Controleur.SliderType.ALPHA);

    p.add(this.slider1);
    p.add(this.slider2);
    p.add(this.slider3);
    p.add(this.slider4);
    return p;
  }
}
