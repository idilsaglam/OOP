/* (C)2021 */
package idilsaglam.tp.tp3;

public class Fou extends Piece {
  public Fou(boolean couleur) {
    super(couleur, "Fou");
  }

  public boolean estValide(Deplacement d, Plateau p) {
    return super.estValide(d, p) && d.typeDeplacement() == 'd' && d.estPossible(p);
  }
}
