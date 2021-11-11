/* (C)2021 */
package idilsaglam.tp.tp6;

/*
 Nous avons plus besoin d'implémenter l'interface Triable. Comme la classe TabTriable implémente déjà Triable
 notre classe va aussi implémenter l'interface Triable
*/
public class TriBinaire extends TabTriable<String> {

  public TriBinaire(String[] tab) {
    super.elements = tab;
  }

  @Override
  public boolean plusGrand(int i, int j) {
    return (Integer.parseInt(this.elements[i], 2) > Integer.parseInt(this.elements[j], 2));
  }
}
