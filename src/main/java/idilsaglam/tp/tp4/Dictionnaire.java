/* (C)2021 */
package idilsaglam.tp.tp4;

public class Dictionnaire extends Media {
  private final String langage;
  private final int nbTomes;

  /**
   * Fonction crée une nouvelle instance de la classe Dictionnaire
   *
   * @param langage La langue du dictionnaire
   * @param nbTomes Le nombre de tomes du dictionnaire
   * @param nom Le nom de la dictionnaire
   */
  public Dictionnaire(String langage, int nbTomes, String nom) {
    super(nom);
    this.langage = langage;
    this.nbTomes = nbTomes;
  }

  /**
   * Fonction retourne la langue du dictionnaire courant
   *
   * @return La langue du dictionnaire
   */
  public String getLangage() {
    return this.langage;
  }

  /**
   * Fonction retourne le nombre de tomes du dictionnaire
   *
   * @return Le nombre de tomes du dictionnaire
   */
  public int getNbTomes() {
    return this.nbTomes;
  }

  @Override
  public int ordreMedia() {
    return 10;
  }

  @Override
  public String toString() {
    return String.format(
        "Dictionnaire de %s, nombre de tomes: %d, %s",
        this.langage, this.nbTomes, super.toString());
  }
}
