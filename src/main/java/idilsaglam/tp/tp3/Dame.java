/* (C)2021 */
package idilsaglam.tp.tp3;

public class Dame extends Piece {
  public Dame(boolean couleur) {
    super(couleur, "Dame");
  }

  public boolean estValide(Deplacement d, Plateau p) {
    return super.estValide(d, p)
        && (d.typeDeplacement() == 'd' || d.typeDeplacement() == 'v' || d.typeDeplacement() == 'h')
        && d.estPossible(p);
  }
}
