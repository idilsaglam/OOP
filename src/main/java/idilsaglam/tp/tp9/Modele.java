/* (C)2021 */
package idilsaglam.tp.tp9;

import java.awt.*;

public class Modele {
  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  private Color color;

  public Modele(Color c) {
    color = c;
  }
}
