/* (C)2021 */
package idilsaglam.tp.tp7;

public class CommandeRm extends CommandeShell {

  public CommandeRm(Dossier dossierCourant, String[] args) {
    super(dossierCourant, args);
  }

  @Override
  public Dossier executer() {
    if (super.args.length == 1) {
      Entree e = super.acceder(super.args[0], false);
      if (e == null || e instanceof EntreeSpeciale) {
        CommandeShell.erreurParams();
        return null;
      }
      e.supprimer();
      return null;
    }
    CommandeShell.erreurParams();
    return null;
  }

  public static void aide() {
    System.out.println("rm <name>");
  }
}
