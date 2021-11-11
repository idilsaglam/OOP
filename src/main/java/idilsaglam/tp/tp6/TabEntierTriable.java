/* (C)2021 */
package idilsaglam.tp.tp6;

/*
Nous avons plus besoin d'implémenter l'interface Triable. Comme la classe TabTriable implémente déjà Triable
notre classe va aussi implémenter l'interface Triable
*/
public class TabEntierTriable extends TabTriable<Integer> {

  public TabEntierTriable(Integer[] tab) {
    super.elements = tab;
  }

  @Override
  public boolean plusGrand(int i, int j) {
    return super.elements[i] > super.elements[j];
  }
}
