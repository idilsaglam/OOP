/* (C)2021 */
package idilsaglam.tp.tp5;

public class Mot extends ChaineCar {

  private String content;

  public Mot(String mot) {
    this.content = mot;
  }

  /** Crée un mot vode */
  public Mot() {
    this.content = "";
  }

  /**
   * Ajoute un caractère à la fin du mot
   *
   * @param c
   */
  public void addChar(char c) {
    this.content += c;
  }

  @Override
  int len() {
    return this.content.length();
  }

  @Override
  public String toString() {
    return this.content;
  }
}
