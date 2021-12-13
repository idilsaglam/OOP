/* (C)2021 */
package idilsaglam.tp.tp11;

public class Groupe extends TabSet<Personnage> {

  /**
   * Renvoie le score total de l'ensemble des personnages
   *
   * @return Le score total de l'ensemble
   */
  public int score() {
    int result = 0;
    // Pour chaque personnage de l'ensemble
    for (Personnage p : this) {
      result += Personnage.scores.get(p);
    }
    return result;
  }
}
