/* (C)2021 */
package idilsaglam.tp.tp3;

public class Deplacement {
  private final int x0;
  private final int y0;
  private final int x1;
  private final int y1;
  private final int deltaX;

  public int getX0() {
    return x0;
  }

  public int getY0() {
    return y0;
  }

  public int getX1() {
    return x1;
  }

  public int getY1() {
    return y1;
  }

  private final int deltaY;

  /**
   * Crée un objet de déplacement
   *
   * @param x0 le nombre de lignes de départ
   * @param y0 le nombre de colonnes de départ
   * @param x1 le nombre de ligne destination
   * @param y1 le nombre de colonne destination
   */
  public Deplacement(int x0, int y0, int x1, int y1) {
    this.x0 = x0;
    this.y0 = y0;
    this.x1 = x1;
    this.y1 = y1;
    this.deltaX = Math.abs(x1 - x0);
    this.deltaY = Math.abs(y1 - y0);
  }

  /**
   * Fonction qui renvoie le type de déplacement
   *
   * @return Le char correspondant au type de déplacement
   */
  public char typeDeplacement() {
    if (this.deltaX == 0 && this.deltaY != 0) {
      return 'h';
    }
    if (this.deltaY == 0 && this.deltaX != 0) {
      return 'v';
    }
    if (this.deltaX != 0 && this.deltaX == this.deltaY) {
      return 'd';
    }
    if (deltaX * deltaY == 2) {
      return 'c';
    }
    return 'x';
  }

  /**
   * Fonction qui renvoie la distance du déplacement
   *
   * @return retourne la distance absolue entre le point de départ et le point d'arrivée si le
   *     déplacement est de type `h', `v' ou `d'. Si le déplacement est de type `c' ou `x', elle
   *     retourne -1.
   */
  public int dist() {
    if (this.deltaX == 0 && this.deltaY != 0) {
      return this.deltaY;
    }
    if ((this.deltaY == 0 && this.deltaX != 0)
        || (this.deltaX != 0 && this.deltaX == this.deltaY)) {
      return this.deltaX;
    }
    return -1;
  }

  /**
   * Fonction qui vérifie si le déplacement est possible pour les déplacements horizontal, vertical
   * est diagonale. Une déplacement est dite possible, si tous les pièces en cours de route sont
   * vide.
   *
   * @param p L'état actuel du plateau
   * @return true si le déplacement est possible, false sinon
   */
  public boolean estPossible(Plateau p) {
    switch (this.typeDeplacement()) {
      case 'd':
        for (int i = this.y0 + 1; i < this.y1; i++) {
          for (int j = this.x0 + 1; j < this.y1; j++) {
            if (p.getCase(i, j).estVide()) {
              continue;
            }
            return false;
          }
        }
        break;
      case 'h':
        for (int i = this.x0 + 1; i < this.x1; i++) {
          if (p.getCase(i, this.y0).estVide()) {
            continue;
          }
          return false;
        }
        break;
      case 'v':
        for (int i = this.y0 + 1; i < this.y1; i++) {
          if (p.getCase(this.x0, i).estVide()) {
            continue;
          }
          return false;
        }
        break;
    }
    return true;
  }

  @Override
  public String toString() {
    return String.format("(%d,%d) -> (%d,%d)", x0, y0, x1, y1);
  }
}
