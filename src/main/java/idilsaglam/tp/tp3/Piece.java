/* (C)2021 */
package idilsaglam.tp.tp3;

public class Piece {
  private final boolean couleur;
  private final String nom;

  public Piece(boolean couleur, String nom) {
    this.couleur = couleur;
    this.nom = nom;
  }

  public String getNom() {
    return nom;
  }

  public boolean getCouleur() {
    return this.couleur;
  }

  @Override
  public String toString() {
    char c = this.nom.charAt(0);
    if (this.couleur) {
      return "" + Character.toLowerCase(c);
    }
    return "" + Character.toUpperCase(c);
  }

  /**
   * Fonction qui vérifie si le déplacement de la pièce est valide pour la pièce concernée et l'état
   * actuel du plateau
   *
   * @param d Le déplacement à tester
   * @param p L'état actuel du plateau
   * @return true si le déplacement est valide pour l'état actuel du plateau, false sinon
   */
  public boolean estValide(Deplacement d, Plateau p) {
    return !p.horsLimite(d)
        && d.estPossible(p)
        && (this.nom.trim().equalsIgnoreCase("pion")
            || (p.getCase(d.getX1(), d.getY1()).estVide()
                || p.getCase(d.getX1(), d.getY1()).getCouleur() != this.couleur));
  }

  public boolean estRoi() {
    return (this.nom.toLowerCase().trim().equals("roi"));
  }
}
