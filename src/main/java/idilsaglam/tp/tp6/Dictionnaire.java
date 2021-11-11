/* (C)2021 */
package idilsaglam.tp.tp6;

public class Dictionnaire extends TabTriable<String> {

  public Dictionnaire(String[] tab) {
    super.elements = tab;
  }

  @Override
  public boolean plusGrand(int i, int j) {
    return super.elements[i].compareTo(this.elements[j]) > 0;
  }
}
