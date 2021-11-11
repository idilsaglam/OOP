/* (C)2021 */
package idilsaglam.tp.tp6;

public interface Triable {

  // échange les éléments en positions i et j
  void echange(int i, int j);
  // retourne vrai si l'élément de position i est plus grand que
  // l'élément de position j
  boolean plusGrand(int i, int j);
  // nombre d'éléments à trier
  int taille();

  /**
   * Exercice 7: Nous avons plus besoin de définir la méthode static dans une interface. Avec le
   * Java 8 nous pouvons s'en servir des interfaces fonctionnelles. Nous pouvons ajouter
   * l'implémentation d'une fonction dans une interface.
   */
  default void triBulles() {
    boolean change;
    do {
      change = false;
      for (int i = 0; i < this.taille() - 1; i++) {
        if (this.plusGrand(i, i + 1)) {
          this.echange(i, i + 1);
          change = true;
        }
      }
    } while (change);
  }
}
