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
    Container c = getContentPane();
    j.add(c);

    JPanel panneauColore = new JPanel();
    panneauColore.setBackground(Color.GREEN);
    this.setContentPane(panneauColore);

    JLabel etiqCouleur = new JLabel("Vert");
    panneauColore.add(etiqCouleur);
    //this.getContentPane().add(etiqCouleur, BorderLayout.CENTER);

  }
}
