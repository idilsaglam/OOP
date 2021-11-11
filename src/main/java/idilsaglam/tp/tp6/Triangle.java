/* (C)2021 */
package idilsaglam.tp.tp6;

public class Triangle extends Figure implements Deformable {
  private final double base;
  private final double hauteur;

  public Triangle(double base, double hauteur, int posX, int posY) {
    super(posX, posY);
    this.base = base;
    this.hauteur = hauteur;
  }

  public double getHauteur() {
    return hauteur;
  }

  public double getBase() {
    return base;
  }

  @Override
  public void affiche() {
    System.out.println(this.toString());
  }

  @Override
  public String toString() {
    return String.format(
        "Triangle du centre (%d,%d), base: %f et l'hauteur %f",
        this.getPosX(), this.getPosY(), this.getBase(), this.getHauteur());
  }

  @Override
  public double surface() {
    return (base * hauteur) / 2;
  }

  @Override
  public Figure deformation(double coeffH, double coeffV) {
    return new Triangle(this.base * coeffH, this.hauteur * coeffV, this.getPosX(), this.getPosY());
  }
}
