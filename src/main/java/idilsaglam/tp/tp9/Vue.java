/* (C)2021 */
package idilsaglam.tp.tp9;

import java.awt.*;
import javax.swing.*;

public class Vue extends JFrame {
  JPanel panneauColore = new JPanel();

  public Vue() {
    this.setTitle("Palette");
    this.setSize(800, 600);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    JComponent j = new JComponent() {};
    this.getContentPane().add(j);

    JPanel panneauColore = new JPanel();
    panneauColore.setBackground(Color.GREEN);
    this.getContentPane().add(panneauColore);

    JLabel etiqCouleur = new JLabel("Vert");
    etiqCouleur.setHorizontalAlignment(0);
    panneauColore.setLayout(new BorderLayout());
    panneauColore.add(etiqCouleur, BorderLayout.CENTER);

    JPanel panneauChoix = new JPanel();
    panneauChoix.setBackground();
    panneauChoix.setLayout(new BorderLayout());
    this.getContentPane().add(panneauChoix);
    this.getContentPane().setLayout(new GridLayout());

    JComponent buttonContainer = new JComponent() {};
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
  }
}
