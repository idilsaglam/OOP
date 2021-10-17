/* (C)2021 */
package idilsaglam.tp.tp3;

public class Case {
  private final boolean couleur;
  Piece piece; // null si la case est vide

  public Case(boolean couleur) {
    this.couleur = couleur;
  }

  public Case(boolean couleur, Piece piece) {
    this(couleur);
    this.piece = piece;
  }

  /**
   * Fonction retourne la pièce qui est dans la case
   *
   * @return La pièce qu'il est dans cette case
   */
  public Piece getPiece() {
    return this.piece;
  }

  /**
   * Fonction qui vérifie si la case est vide
   *
   * @return true si la case est vide
   */
  public boolean estVide() {
    return piece == null;
  }

  /**
   * Fonction qui change la pièce de cette case avec la pièce passée en paramètre
   *
   * @param p La pièce à mettre dans cette case
   */
  public void remplirPiece(Piece p) {
    this.piece = p;
  }

  /** Fonction qui enlève la pièce de cette case */
  public void enleverPiece() {

    Piece p = this.piece;
    this.piece = null;
  }

  /**
   * Fonction retourne la couleur de la case
   *
   * @return La couleur de la case
   */
  public boolean getCouleur() {
    return this.couleur;
  }

  @Override
  public String toString() {
    // si la case est vide
    if (this.estVide()) {
      return (this.couleur ? "-" : "*");
    }
    // Nous retournons la lettre initiale de la pièce.
    // On utilise la fonction toString de la pièce qui nous aide à distinguer le couleur de la pièce
    return "" + this.piece.toString();
  }
}
