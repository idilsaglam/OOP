/* (C)2021 */
package idilsaglam.tp.tp6;

public class Circle extends Ellipse {

  /**
   * Crée une nouvelle instance de Cercle
   *
   * @param rayon La rayon du cercle
   * @param posX L'abscisse du centre du cercle
   * @param posY L'ordonnée du centre du cercle
   */
  public Circle(double rayon, int posX, int posY) {
    super(rayon, rayon, posX, posY);
  }

  /**
   * Retourne le rayon du cercle
   *
   * @return Le rayon du cercle
   */
  public double getRayon() {
    return super.getGrandRayon();
  }

  @Override
  public String toString() {
    return String.format(
        "Cercle de centre (%d, %d) du rayon %f",
        super.getPosX(), super.getPosY(), super.getGrandRayon());
  }
}
