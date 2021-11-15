/* (C)2021 */
package idilsaglam.tp.tp7;

public class CommandeMkdir extends CommandeShell {

  public CommandeMkdir(Dossier dossierCourant, String[] args) {
    super(dossierCourant, args);
  }

  @Override
  public Dossier executer() {
    if (super.args.length != 1) {
      CommandeShell.erreurParams();
      return null;
    }
    super.dossierCourant.ajouter(args[0], new Dossier(super.dossierCourant));
    return null;
  }

  public static void aide() {
    System.out.println("mkdir <foldername>");
  }
}
