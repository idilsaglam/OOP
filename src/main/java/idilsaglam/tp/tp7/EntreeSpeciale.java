/* (C)2021 */
package idilsaglam.tp.tp7;

public class EntreeSpeciale extends Entree {

  public EntreeSpeciale(Dossier p, String n, Element e) {
    super(p, n, e);
  }

  @Override
  public void supprimer() {
    System.err.println("Les entrées spéciales sont protégés à la suppression");
  }

  @Override
  public void remplacer(Element e) {
    System.err.println("Les entrées spéciales sont protégés à la modification");
  }
}
