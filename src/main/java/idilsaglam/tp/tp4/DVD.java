/* (C)2021 */
package idilsaglam.tp.tp4;

public class DVD extends Media {
  private final int duree;
  private final String productrice;
  private final String langue;

  /**
   * Fonction crée une nouvelle instance de DVD
   *
   * @param duree La durée
   * @param productrice Le producteur ou la productrice
   * @param langue La langue
   * @param nom Le nom
   */
  public DVD(int duree, String productrice, String langue, String nom) {
    super(nom);
    this.duree = duree;
    this.langue = langue;
    this.productrice = productrice;
  }

  /**
   * Fonction retourne la durée du DVD
   *
   * @return La durée de DVD
   */
  public int getDuree() {
    return this.duree;
  }

  /**
   * Fonction retourne la productrice de du film
   *
   * @return La productrice
   */
  public String getProductrice() {
    return productrice;
  }

  /**
   * Fonction retourne la langue de DVD
   *
   * @return La langue du DVD
   */
  public String getLangue() {
    return this.langue;
  }

  @Override
  public int ordreMedia() {
    return 75;
  }

  @Override
  public String toString() {
    return "Film : " + super.toString();
  }
}
