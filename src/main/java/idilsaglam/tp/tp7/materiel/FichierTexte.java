/* (C)2021 */
package idilsaglam.tp.tp7.materiel;

import java.util.Scanner;

public class FichierTexte extends Element implements Affichable, Editable {
  private String contenu;

  @Override
  public String getType() {
    return "texte";
  }

  @Override
  public void afficher() {
    // TODO
  }

  @Override
  public void editer(Scanner sc, boolean echo) {
    // Todo:
  }
}
