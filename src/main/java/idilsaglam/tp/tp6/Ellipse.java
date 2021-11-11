/* (C)2021 */
package idilsaglam.tp.tp6;

public class Ellipse extends Figure implements Deformable {
  private final double grandRayon;
  private final double petitRayon;

  /**
   * Crée une nouvelle objet Ellipse
   *
   * @param grandRayon Le grand rayon d'ellipse
   * @param petitRayon le petit rayon d'ellipse
   * @param posX L'abscisse du centre d'ellipse
   * @param posY L'ordonnées du centre d'ellipse
   */
  public Ellipse(double grandRayon, double petitRayon, int posX, int posY) {
    super(posX, posY);
    this.grandRayon = grandRayon;
    this.petitRayon = petitRayon;
  }

  /**
   * Retourne le grand rayon d'ellipse
   *
   * @return Le grand rayon d'ellipse
   */
  public double getGrandRayon() {
    return this.grandRayon;
  }

  /**
   * Retourne le petit rayon d'ellipse
   *
   * @return Le petit rayon d'ellipse
   */
  public double getPetitRayon() {
    return petitRayon;
  }

  @Override
  public void affiche() {
    System.out.println(this.toString());
  }

  @Override
  public String toString() {
    return String.format(
        "%s, centre (%d,%d), Grand rayon: %f Petit rayon: %f",
        this.getClass().getSimpleName(),
        super.getPosX(),
        super.getPosY(),
        this.getGrandRayon(),
        this.getPetitRayon());
  }

  @Override
  public double surface() {
    return Math.PI * grandRayon * petitRayon;
  }

  @Override
  public Figure deformation(double coeffH, double coeffV) {
    return new Ellipse(
        this.grandRayon * coeffH, this.petitRayon * coeffV, this.getPosX(), this.getPosY());
  }
}
