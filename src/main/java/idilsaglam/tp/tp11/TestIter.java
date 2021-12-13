/* (C)2021 */
package idilsaglam.tp.tp11;

import java.util.Iterator;

public class TestIter<E> implements Iterator<E> {

  private int index;
  private final E[] tableau;

  public TestIter(E[] tableau) {
    this.index = 0;
    this.tableau = tableau;
  }

  @Override
  public boolean hasNext() {
    return this.index < this.tableau.length;
  }

  @Override
  public E next() {
    E result = this.tableau[this.index];
    this.index++;
    return result;
  }
}
