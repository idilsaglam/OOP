/* (C)2021 */
package idilsaglam.tp.tp7;

abstract class CommandeShell {
  protected Dossier dossierCourant;
  protected String[] args;

  public CommandeShell(Dossier dossierCourant, String[] args) {
    this.dossierCourant = dossierCourant;
    this.args = args;
  }

  public static void aide() {}

  protected static void erreurParams() {
    System.err.println("Pas un bon nombre de paramètres");
    aide();
  }

  public abstract Dossier executer();

  protected Entree acceder(String chemin, boolean creer) {
    String[] path = chemin.trim().split("/");
    boolean absolute = path[0].length() == 0;
    Dossier dc = absolute ? this.dossierCourant.getRacine() : dossierCourant;
    Entree e;
    for (int i = 1; i < path.length - 1; i++) {
      e = dc.getEntree(path[i], creer);
      if ((e == null) || (!(e.getElement() instanceof Dossier) && (i < (path.length - 1)))) {
        return null;
      }
      dc = (Dossier) e.getElement();
    }
    return dc.getEntree(path[path.length - 1], creer);
  }
}
