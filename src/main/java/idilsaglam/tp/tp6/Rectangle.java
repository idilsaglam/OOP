/* (C)2021 */
package idilsaglam.tp.tp6;

public class Rectangle extends Figure implements Deformable {
  private final double largeur;
  private final double hauteur;

  /**
   * Crée un nouvelle instance de l'objet Rectangle
   *
   * @param largeur Le largeur de rectangle
   * @param hauteur L'hauteur de rectangle
   * @param centreX L'abscisse du centre de rectangle
   * @param centreY L'ordonnée du centre de rectangle
   */
  public Rectangle(double largeur, double hauteur, int centreX, int centreY) {
    super(centreX, centreY);
    this.hauteur = hauteur;
    this.largeur = largeur;
  }

  /**
   * Retourne l'hauteur de rectangle
   *
   * @return L'hauteur de rectangle
   */
  public double getHauteur() {
    return hauteur;
  }

  /**
   * Retourne largeur de rectangle
   *
   * @return Le largeur de rectangle
   */
  public double getLargeur() {
    return largeur;
  }

  @Override
  public void affiche() {
    System.out.println(this.toString());
  }

  @Override
  public String toString() {
    return String.format(
        "%s, centre (%d,%d), largeur: %f l'hauteur: %f",
        this.getClass().getSimpleName(),
        super.getPosX(),
        super.getPosY(),
        this.getLargeur(),
        this.getHauteur());
  }

  @Override
  public double surface() {
    return largeur * hauteur;
  }

  @Override
  public Figure deformation(double coeffH, double coeffV) {
    double largeur = this.largeur * coeffH;
    double hauteur = this.hauteur * coeffV;
    if (largeur == hauteur) {
      return new Carre(largeur, this.getPosX(), this.getPosY());
    }
    return new Rectangle(largeur, hauteur, this.getPosX(), this.getPosY());
  }
}
