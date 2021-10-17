/* (C)2021 */
package idilsaglam.tp.tp3;

public class Cavalier extends Piece {
  public Cavalier(boolean couleur) {
    super(couleur, "Cavalier");
  }

  public boolean estValide(Deplacement d, Plateau p) {
    return super.estValide(d, p) && (d.typeDeplacement() == 'c');
  }
}
