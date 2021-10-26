/* (C)2021 */
package idilsaglam.tp.tp5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Formatteur {

  private final LinkedList<Paragraphe> texte;
  private Scanner scanner;
  /**
   * Crée unve nouvelle instance du formatteur
   *
   * @param filename Le nom de fichier sur lequel nous allons initialiser le Scanner
   */
  public Formatteur(String filename) {
    this.texte = new LinkedList<>();
    try {
      this.scanner = new Scanner(new File(filename));

    } catch (FileNotFoundException e) {
      System.err.println("Erreur lors d'ouverture de fichier");
      e.printStackTrace();
      System.exit(1);
    }
  }

  /** Fonction gère le lecture de fichier et initialise les paragraphes */
  public void read(int pageWidth) {
    this.scanner.useDelimiter("\n(\\s|\\t)*\n");
    while (this.scanner.hasNext()) {
      String p = this.scanner.next();
      this.texte.add(new Paragraphe(p, pageWidth));
    }
    this.scanner.close();
  }

  public void print() {
    System.out.print(
        this.texte.stream().map(Paragraphe::toString).collect(Collectors.joining("\n")));
  }

  public void justifier(int n) {
    this.texte.forEach(e -> e.justifier(n));
  }
}
