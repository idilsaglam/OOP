/* (C)2021 */
package idilsaglam.tp.tp7;

public class CommandeCd extends CommandeShell {

  public CommandeCd(Dossier dossierCourant, String[] args) {
    super(dossierCourant, args);
  }

  @Override
  public Dossier executer() {
    switch (super.args.length) {
      case 0:
        super.dossierCourant = dossierCourant.getRacine();
        return super.dossierCourant;
      case 1:
        Entree e = super.acceder(args[0], false);
        if (e != null && e.getElement() instanceof Dossier) {
          super.dossierCourant = (Dossier) e.getElement();
          return super.dossierCourant;
        }
        CommandeShell.erreurParams();
        return null;
      default:
        CommandeShell.erreurParams();
        return null;
    }
  }

  public static void aide() {
    System.out.println("cd [<foldername>]");
  }
}
