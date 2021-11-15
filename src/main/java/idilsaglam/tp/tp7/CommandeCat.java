/* (C)2021 */
package idilsaglam.tp.tp7;

public class CommandeCat extends CommandeShell {

  public CommandeCat(Dossier dossierCourant, String[] args) {
    super(dossierCourant, args);
  }

  @Override
  public Dossier executer() {
    if (args.length == 1) {
      Entree e = super.acceder(super.args[0], false);
      if (e != null && e.getElement() instanceof Affichable) {
        ((Affichable) e.getElement()).afficher();
        return null;
      }
    }
    CommandeShell.erreurParams();
    return null;
  }

  public static void aide() {
    System.out.println("cat <name>");
  }
}
