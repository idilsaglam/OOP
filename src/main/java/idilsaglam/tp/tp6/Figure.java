/* (C)2021 */
package idilsaglam.tp.tp6;

public abstract class Figure {
  // coordonnées du centre approximatif de la figure
  private int posX;
  private int posY;

  public Figure(int x, int y) {
    this.posX = x;
    this.posY = y;
  }

  /**
   * Fonction retourne l'abscisse du centre de la figure
   *
   * @return L'abscisse du centre de la figure
   */
  public final int getPosX() {
    return this.posX;
  }

  /**
   * Fonction retourne l'ordonnée du centre de la figure
   *
   * @return L'ordonnée du centre de la figure
   */
  public final int getPosY() {
    return this.posY;
  }

  public abstract void affiche();

  public final double estDistantDe(Figure fig) {
    return Math.sqrt(
        Math.abs(this.getPosY() - fig.getPosY())
            ^ 2 + Math.abs(this.getPosX() - fig.getPosX())
            ^ 2);
  }

  public abstract double surface();

  public final void deplacement(int x, int y) {
    this.posX += x;
    this.posY += y;
  }
}
