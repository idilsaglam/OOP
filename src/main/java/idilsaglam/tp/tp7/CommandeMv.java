/* (C)2021 */
package idilsaglam.tp.tp7;

public class CommandeMv extends CommandeShell {

  public CommandeMv(Dossier dossierCourant, String[] args) {
    super(dossierCourant, args);
  }

  @Override
  public Dossier executer() {
    if (super.args.length == 2) {
      String src = super.args[0], dest = super.args[1];
      Entree srcE = super.acceder(src, false), destE = super.acceder(dest, false);
      if (srcE != null && destE != null) {
        if ((srcE.getElement() instanceof Dossier)
            && (destE.getElement() instanceof Dossier)
            && ((Dossier) destE.getElement()).estEnfantDe((Dossier) srcE.getElement())) {
          System.err.println("Pas possible de déplacer un dossier dans lui-même");
          return null;
        }

        destE.remplacer(srcE.getElement());
        srcE.supprimer();
        return null;
      }
      CommandeShell.erreurParams();
      return null;
    }
    CommandeShell.erreurParams();
    return null;
  }

  public static void aide() {
    System.out.println("mv <src> <dest>");
  }
}
