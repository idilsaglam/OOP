/* (C)2021 */
package idilsaglam.tp.tp5;

public class Espace extends ChaineCar {

  private int size;

  public Espace(int size) {
    this.size = size;
  }

  public Espace() {
    this.size = 1;
  }

  @Override
  int len() {
    return this.size;
  }

  @Override
  public String toString() {
    return " ".repeat(this.size);
  }

  public void etaler() {
    this.size++;
  }
}
