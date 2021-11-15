/* (C)2021 */
package idilsaglam.tp.tp7;

import java.util.Scanner;

public class CommandeEd extends CommandeShell {
  private final Scanner sc;
  private final boolean echo;

  public CommandeEd(Dossier dossierCourant, String[] args, Scanner sc, boolean echo) {
    super(dossierCourant, args);
    this.sc = sc;
    this.echo = echo;
  }

  @Override
  public Dossier executer() {
    if (super.args.length == 1) {
      Entree e = super.acceder(super.args[0], true);
      if (e != null && e.getElement() instanceof FichierTexte) {
        ((FichierTexte) e.getElement()).editer(this.sc, this.echo);
        return null;
      }
    }
    CommandeShell.erreurParams();
    return null;
  }
}
