/* (C)2021 */
package idilsaglam.tp.tp4;

public class DictionnaireBilingue extends Dictionnaire {

  private final String langageDest;

  public DictionnaireBilingue(String nom, String langue, int nbTomes, String langueDest) {
    super(langue, nbTomes, nom);
    this.langageDest = langueDest;
  }

  @Override
  public int ordreMedia() {
    return 1;
  }

  @Override
  public String toString() {
    return "DictionnaireBilingue : " + super.toString();
  }
}
