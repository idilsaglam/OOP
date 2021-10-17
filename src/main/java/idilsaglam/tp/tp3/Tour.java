/* (C)2021 */
package idilsaglam.tp.tp3;

public class Tour extends Piece {
  public Tour(boolean couleur) {
    super(couleur, "Tour");
  }

  public boolean estValide(Deplacement d, Plateau p) {
    return super.estValide(d, p)
        && (d.typeDeplacement() == 'v' || d.typeDeplacement() == 'h')
        && d.estPossible(p);
  }
}
