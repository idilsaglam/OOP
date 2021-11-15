/* (C)2021 */
package idilsaglam.tp.tp7;

public class CommandeLs extends CommandeShell {

  public CommandeLs(Dossier dossierCourant, String[] args) {
    super(dossierCourant, args);
  }

  @Override
  public Dossier executer() {
    switch (args.length) {
      case 0:
        super.dossierCourant.afficher();
        return null;
      case 1:
        Entree e = super.acceder(args[0], false);
        if (e != null && e.getElement() instanceof Affichable) {
          ((Affichable) e.getElement()).afficher();
          return null;
        }
        CommandeShell.erreurParams();
        return null;
      default:
        CommandeShell.erreurParams();
        return null;
    }
  }
}
