/* (C)2021 */
package idilsaglam.tp.tp6;

public abstract class TabTriable<T> implements Triable {
  T[] elements;

  @Override
  public void echange(int i, int j) {
    T tmp = this.elements[i];
    this.elements[i] = this.elements[j];
    this.elements[j] = tmp;
  }

  @Override
  public int taille() {
    return this.elements.length;
  }

  @Override
  public String toString() {
    String res = "";
    for (int i = 0; i < this.taille(); i++) {
      res += this.elements[i];
      if (i < this.taille() - 1) {
        res += " ,";
      }
    }
    return res;
  }
}
