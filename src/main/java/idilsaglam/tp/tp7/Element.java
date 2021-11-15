/* (C)2021 */
package idilsaglam.tp.tp7;

abstract class Element {
  public abstract String getType();

  @Override
  public String toString() {
    return String.format("ficher de type %s", this.getType());
  }
}
