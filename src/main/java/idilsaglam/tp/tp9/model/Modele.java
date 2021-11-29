/* (C)2021 */
package idilsaglam.tp.tp9.model;

import idilsaglam.tp.tp9.view.Vue;
import java.awt.*;

public class Modele {

  private static Color DEFAULT_COLOR;

  private Color color;
  private Vue vue;

  /**
   * Crée un nouveau modèle
   *
   * @param c La couleur par défaut
   * @param vue La vue associé
   */
  public Modele(Color c, Vue vue) {
    this.color = c;
    this.save();
    this.vue = vue;
  }

  /**
   * Crée le modèle uniquement par la vue
   *
   * @param vue La vue associé
   */
  public Modele(Vue vue) {
    Modele.DEFAULT_COLOR = Color.PINK;
  }

  /**
   * Retourne la couleur courante
   *
   * @return La couleur courante
   */
  public Color getColor() {
    return color;
  }

  /**
   * mettre à jour la valeur de la couleur courante
   *
   * @param color La nouvelle couleur courante
   */
  public void setColor(Color color) {
    this.color = color;
    this.vue.updateColorPane();
  }

  /** Sauvegarde la couleur courante à la mémoire */
  public void save() {
    Modele.DEFAULT_COLOR = this.color;
  }

  /** Mette à jour la couleur courante par la couleur sauvegarde dans la mémore */
  public void load() {
    this.color = Modele.DEFAULT_COLOR;
    this.vue.updateSliders();
  }

  /**
   * Mettre à jour la valeur de rouge dans la couleur courante
   *
   * @param n La nouvelle valeur de rouge
   */
  public void setColorR(int n) {
    this.setColor(new Color(n, this.color.getGreen(), this.color.getBlue(), this.color.getAlpha()));
  }

  /**
   * Mettre à jour la valeur de verte dans la couleur courante
   *
   * @param n La nouvelle valeur de verte
   */
  public void setColorG(int n) {
    this.setColor(new Color(this.color.getRed(), n, this.color.getBlue(), this.color.getAlpha()));
  }

  /**
   * Mettre à jour la valeur de bleu dans la couleur courante
   *
   * @param n La nouvelle valeur de bleu
   */
  public void setColorB(int n) {
    this.setColor(new Color(this.color.getRed(), this.color.getGreen(), n, this.color.getAlpha()));
  }

  /**
   * Mettre à jour la valeur d'alpha dans la couleur courante
   *
   * @param n La nouvelle valeur d'alpha
   */
  public void setColorA(int n) {
    this.setColor(new Color(this.color.getRed(), this.color.getGreen(), this.color.getBlue(), n));
  }

  /**
   * Retourne la représentation HEX de la couleur courante
   *
   * @return La chaîne de caractères contenant la représentation HEX de la couleur courante
   */
  public String getHEX() {
    return String.format("#%s", Integer.toHexString(this.color.getRGB()));
  }

  /** Change la couleur courante avec la couleur complémentaire. Et mets à jours les sliders. */
  public void setComplementaire() {
    this.setColor(
        new Color(
            255 - this.color.getRed(),
            255 - this.color.getGreen(),
            255 - this.color.getBlue(),
            this.color.getAlpha()));
    this.vue.updateSliders();
  }
}
