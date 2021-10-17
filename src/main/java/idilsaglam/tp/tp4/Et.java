/* (C)2021 */
package idilsaglam.tp.tp4;

public class Et implements Predicat {

  private Predicat p1, p2;

  public Et(Predicat p1, Predicat p2) {
    this.p1 = p1;
    this.p2 = p2;
  }

  @Override
  public boolean estVrai(Media m) {
    return p1.estVrai(m) && p2.estVrai(m);
  }
}
