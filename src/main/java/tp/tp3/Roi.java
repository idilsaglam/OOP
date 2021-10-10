package tp.tp3;

public class Roi extends Piece {
  public Roi(boolean couleur) {
    super(couleur, "Roi");
  }

  public boolean estValide(Deplacement d, Plateau p) {
    return super.estValide(d, p)
        && (d.typeDeplacement() == 'd' || d.typeDeplacement() == 'v' || d.typeDeplacement() == 'h')
        && (d.dist() == 1);
  }
}
