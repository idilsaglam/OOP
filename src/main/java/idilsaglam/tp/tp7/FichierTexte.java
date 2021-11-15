/* (C)2021 */
package idilsaglam.tp.tp7;

import java.util.Scanner;

public class FichierTexte extends Element implements Affichable, Editable {

  private String contenu;

  public FichierTexte(String contenu) {
    super();
    this.contenu = contenu;
  }

  public FichierTexte() {
    super();
    this.contenu = "";
  }

  @Override
  public String getType() {
    return "texte";
  }

  @Override
  public void afficher() {
    System.out.println(this.contenu);
  }

  @Override
  public void editer(Scanner sc, boolean echo) {
    String line;
    this.contenu = "";
    while (true) {
      line = sc.nextLine();
      if (line.equals(".")) {
        sc.close();
        return;
      }
      this.contenu += String.format("%s\n", line);
      if (echo) {
        System.out.println(line);
      }
    }
  }
}
