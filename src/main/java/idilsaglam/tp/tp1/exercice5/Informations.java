/* (C)2021 */
package idilsaglam.tp.tp1.exercice5;

public class Informations {

  private int vivalite;
  private final int force;
  private int agilite;

  public Informations(int v, int f, int a) {
    this.vivalite = v;
    this.force = f;
    this.agilite = a;
  }

  public int getVitalite() {
    return this.vivalite;
  }

  public int getForce() {
    return this.force;
  }

  public int getAgilite() {
    return this.agilite;
  }

  public void setAgilite(int a) {
    this.agilite = a;
  }

  public void setVivalite(int v) {
    this.vivalite = v;
  }

  @Override
  public String toString() {
    return String.format(
        "Vitalité: %d Force: %d Agilité: %d",
        this.getVitalite(), this.getForce(), this.getAgilite());
  }
}
