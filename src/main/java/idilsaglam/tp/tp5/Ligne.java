/* (C)2021 */
package idilsaglam.tp.tp5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Ligne extends ChaineCar {
  LinkedList<ChaineCar> content;

  /**
   * Crée une nouvelle insance de la ligne
   *
   * @param content
   */
  public Ligne(LinkedList<ChaineCar> content) {
    this.content = content;
  }

  /** Crée une ligne vide */
  public Ligne() {
    this.content = new LinkedList<>();
  }

  /**
   * Crée une ligne à partir d'une châine de caractres.
   *
   * @param texte
   */
  public Ligne(String texte) {
    this();
    Scanner sc = new Scanner(texte);
    sc.useDelimiter("");
    while (sc.hasNext()) {
      String c = sc.next();
      if (c.equals(" ")) {
        this.addChaine(new Espace());
        continue;
      }
      if (this.content.size() == 0 || this.content.getLast() instanceof Espace) {
        this.addChaine(new Mot(c));
        continue;
      }

      ((Mot) this.content.getLast()).addChar(c.charAt(0));
    }
    sc.close();
  }

  @Override
  public int len() {
    return this.content.stream().map(ChaineCar::len).reduce(0, Integer::sum);
  }

  /**
   * Ajoute une chaîne de caractère à la fin de la ligne
   *
   * @param c
   */
  public void addChaine(ChaineCar c) {
    this.content.add(c);
  }

  @Override
  public String toString() {
    return this.content.stream().map(ChaineCar::toString).reduce("", String::concat) + "\n";
  }

  public void ajouteAuDebut(ChaineCar c) {
    this.content.add(0, c);
  }

  public void justifier(int n) {
    List<Integer> indexes = new ArrayList<>();
    for (int i = 0; i < this.content.size(); i++) {
      if (this.content.get(i) instanceof Espace) {
        indexes.add(i);
      }
    }
    int j = 0;
    for (int i = 0; i < n; i++) {
      ((Espace) this.content.get(indexes.get(j))).etaler();
      j = (j + 1) % indexes.size();
    }
  }
}
