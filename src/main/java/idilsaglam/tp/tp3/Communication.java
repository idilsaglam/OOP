/* (C)2021 */
package idilsaglam.tp.tp3;

import java.util.Scanner;

public class Communication {
  private final Scanner scanner;

  public Communication() {
    this.scanner = new Scanner(System.in);
  }

  private int[] getCoords(int maxlignes, int maxcolonnes, String message) {
    int col, lig;
    System.out.print(message);
    String s = this.scanner.next();
    s = s.toLowerCase();
    col = s.charAt(0) - 'a';
    lig = s.charAt(1) - '1';
    if (col >= maxcolonnes || lig >= maxlignes) {
      System.out.println(
          "Les coordonnées que vous avez saisi ne sont pas valides. Veuillez essayer à nouveau.");
      return getCoords(maxlignes, maxcolonnes, message);
    }
    System.out.println();
    // System.out.printf("COLONNE %d LIGNE %d\n", col, lig);
    return new int[] {lig, col};
  }

  public Deplacement demanderDeplacement(int maxlignes, int maxColonnes) {
    // On initialise par un tableau vide pour calmer le message d'erreur de IDE. (Possible
    // NullPointerException)
    int[] coordDepart = new int[2], coordArrive = new int[2];
    coordDepart =
        this.getCoords(
            maxlignes, maxColonnes, "Veuillez saisir les coordonnées de la case de départ");
    coordArrive =
        this.getCoords(
            maxlignes, maxColonnes, "Veuillez saisir les coordonnés de la case destination");

    return new Deplacement(coordDepart[0], coordDepart[1], coordArrive[0], coordArrive[1]);
  }

  public void close() {
    this.scanner.close();
  }
}
