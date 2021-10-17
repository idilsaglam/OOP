/* (C)2021 */
package idilsaglam.tp.tp3;

public class Pion extends Piece {
  public Pion(boolean couleur) {
    super(couleur, "Pion");
  }

  public boolean estValide(Deplacement d, Plateau p) {
    /*
     * Un pion peut se déplacer verticalement. Les conditions générales pour le déplacement d'un pion:
     * - Si le couleur du pion est le même que le couleur du base du plateau (càd le couleur de la pièce à l'index 0, 0 à l'état initiale du jeu).
     *   le déplacement doit être fait vers le haut
     * - Sinon, le déplacement doit être fait vers le bas.
     * - Dans les deux précédent cas, la case d'arrivée doit être vide.
     * S'il y a une autre pièce du couleur adversaire à la case diagonale, le pion peut se déplacer diagonalement en gardant le sens de déplacement que le cas précédent.
     */

    // La variable dirty contient si le pion est déjà joué ou pas
    boolean dirty = false;
    if (super.estValide(d, p)) {
      if (p.couleurBase == super.getCouleur()) {
        // Dans ce cas, on peut déplacer dans le sens positif.

        // On vérifie si le pion est déjà joué ou pas
        dirty = d.getX0() != 1;
        if (!dirty && d.typeDeplacement() == 'v' && d.dist() == 2 && (d.getX1() - d.getX0()) == 2) {
          return d.estPossible(p);
        }

        if (d.typeDeplacement() == 'd' && (d.getX1() - d.getX0() == 1)) {
          return !p.getCase(d.getX1(), d.getY1()).estVide()
              && p.getCase(d.getX1(), d.getY1()).getPiece().getCouleur() != super.getCouleur();
        }

        return (d.typeDeplacement() == 'v' && d.dist() == 1 && d.getX1() - d.getX0() == 1);
      }
      // Dans ce cas on peut se déplacer que dans le sens négatif

      // On vérifie si le pion est déjà joué ou pas
      dirty = d.getX0() != p.getLongueur() - 2;

      if (!dirty && d.typeDeplacement() == 'v' && d.dist() == 2 && (d.getX1() - d.getX0()) == -2) {
        return d.estPossible(p);
      }

      if (d.typeDeplacement() == 'd' && (d.getX1() - d.getX0() == -1)) {
        return !p.getCase(d.getX1(), d.getY1()).estVide()
            && p.getCase(d.getX1(), d.getY1()).getPiece().getCouleur() != super.getCouleur();
      }

      return (d.typeDeplacement() == 'v' && d.dist() == 1 && d.getX1() - d.getX0() == -1);
    }
    return false;
  }
}
