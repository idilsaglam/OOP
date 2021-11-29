/* (C)2021 */
package idilsaglam.tp.tp9;

import java.awt.*;

public class Modele {
  private Color color;
  private Vue vue;

  public Modele(Color c, Vue vue) {
    this.color = c;
    this.vue = vue;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public void setColorR(int n) {
    this.color = new Color(n, this.color.getGreen(), this.color.getBlue(), this.color.getAlpha());
    this.vue.miseAjour();
  }

  public void setColorG(int n) {
    this.color = new Color(this.color.getRed(), n, this.color.getBlue(), this.color.getAlpha());
    this.vue.miseAjour();
  }

  public void setColorB(int n) {
    this.color = new Color(this.color.getRed(), this.color.getGreen(), n, this.color.getAlpha());
    this.vue.miseAjour();
  }

  public void setColorA(int n) {
    this.color = new Color(this.color.getRed(), this.color.getGreen(), this.color.getBlue(), n);
    this.vue.miseAjour();
  }

  public String colorToRGB() {
    return String.format("#%s", Integer.toHexString(this.color.getRGB()));
  }
}
