/* (C)2021 */
package idilsaglam.tp.tp3;

public class Plateau {

  private Case[][] cases;
  public final boolean couleurBase;

  public Plateau(int longueur, int largeur) {
    this(longueur, largeur, true);
  }

  public Plateau(int longueur, int largeur, boolean couleurBase) {
    boolean c;

    this.cases = new Case[longueur][largeur];
    this.couleurBase = couleurBase;
    for (int i = 0; i < longueur; i++) {
      for (int j = 0; j < largeur; j++) {
        if (i == 0) {
          if (j == 0) {
            c = false;
          } else {
            c = !this.cases[i][j - 1].getCouleur();
          }
        } else {
          c = !this.cases[i - 1][j].getCouleur();
        }
        this.cases[i][j] = new Case(c);
      }
    }
  }

  /**
   * Fonction qui vérifie si la case dont les coordonnés passés en paramètres est dans la plateau
   *
   * @param x L'ordonné de la case
   * @param y L'abscisse de la case
   * @return false si la case passé en paramètres est bien dans le plateau, false sinon
   */
  public boolean horsLimite(int x, int y) {
    /*
        try {
            Case c = this.cases[x][y];
            return false;
        } catch (IndexOutOfBoundsException e) {
            return true;
        }
    */
    return !(this.cases.length > x && this.cases[0].length > y);
  }

  /**
   * La fonction vérifie si le déplacement reste dans le plateau
   *
   * @param d le déplacement à tester
   * @return true si le déplacement reste dans le plateau, false sinon
   */
  public boolean horsLimite(Deplacement d) {
    return this.horsLimite(d.getX0(), d.getY0()) && this.horsLimite(d.getX1(), d.getY1());
  }

  /**
   * Fonction qui renvoie la case dont les coordonnés passé en paramètres
   *
   * @param x L'ordonnée de la case
   * @param y L'abscisse de la case
   * @return La case aux coordonnés passées en paramètres si une telle case existe, null sinon
   */
  public Case getCase(int x, int y) {
    if (!horsLimite(x, y)) {
      return cases[x][y];
    }
    return null;
  }

  /**
   * Fonction qui vide la case dont les coordonnés passé en paramètres
   *
   * @param x L'ordonnée de la case
   * @param y L'abscisse de la case
   */
  public void videCase(int x, int y) {
    if (!horsLimite(x, y)) {
      cases[x][y].enleverPiece();
    }
  }

  /**
   * Fonction remplis la case passé en paramètres avec la pièce donnée
   *
   * @param x L'ordonnée de la case
   * @param y L'abscisse de la case
   * @param p La pièce à mettre dans la case
   */
  public void remplirCase(int x, int y, Piece p) {
    if (!horsLimite(x, y)) {
      cases[x][y].remplirPiece(p);
    }
  }

  @Override
  public String toString() {
    String result = "";
    for (int i = this.cases.length - 1; i >= 0; i--) {
      for (int j = 0; j < this.cases[i].length; j++) {
        result += this.cases[i][j].toString();
      }
      result += "\n";
    }
    return result;
  }

  /** Fonction affiche le plateau du jeu */
  public void afficher() {
    System.out.println(this.toString());
  }

  public int getLongueur() {
    return this.cases.length;
  }

  public int getLargeur() {
    return this.cases[0].length;
  }
}
