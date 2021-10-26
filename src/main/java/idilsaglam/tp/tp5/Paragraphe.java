/* (C)2021 */
package idilsaglam.tp.tp5;

import java.util.LinkedList;
import java.util.Scanner;

public class Paragraphe extends ChaineCar {

  private final LinkedList<Ligne> lignes;
  private final int pageWidth;

  public Paragraphe(LinkedList<Ligne> lignes, int pageWidth) {
    this.lignes = lignes;
    this.pageWidth = pageWidth;
  }

  /** Crée une paragraphe vide */
  public Paragraphe(int pageWidth) {
    this.lignes = new LinkedList<>();
    this.pageWidth = pageWidth;
  }

  /**
   * Crée un paragraphe à partir d'une chaîne de caractères
   *
   * @param s Le chaîne de caractres
   */
  public Paragraphe(String s, int pageWidth) {
    this(pageWidth);
    Scanner sc = new Scanner(s);
    sc.useDelimiter("");
    Mot m = new Mot();
    while (sc.hasNext()) {
      String c = sc.next();
      if (c.equals(" ")) {
        this.addChaine(m);
        m = new Mot();
        this.addChaine(new Espace());
        continue;
      }
      m.addChar(c.charAt(0));
    }
    this.addChaine(m);
    this.lignes.get(0).ajouteAuDebut(new Espace(3));
    sc.close();
  }

  /**
   * Retourne true si le paragraphe est vide, false sinon
   *
   * @return True si la paragraphe est vide, false sinon
   */
  public boolean isEmpty() {
    return this.lignes == null
        || this.lignes.size() == 0
        || this.lignes.size()
            == this.lignes.stream().map(Ligne::len).filter(e -> e == 0).toArray().length;
  }

  @Override
  public int len() {
    return this.lignes.stream().map(Ligne::len).reduce(0, Integer::sum);
  }

  private int lastLinelength() {
    return (this.lignes == null || this.lignes.size() == 0) ? 0 : this.lignes.getLast().len();
  }

  /**
   * Ajoute une nouvelle châine à la fin de la pragraphe
   *
   * @param c La châine à ajouter
   */
  public void addChaine(ChaineCar c) {
    if (this.lignes.size() == 0 || this.lastLinelength() + c.len() > this.pageWidth) {
      // Si le largeur va dépasser le largeur maximale, on va passer à une nouvelle ligne
      this.lignes.add(new Ligne());
    }
    this.lignes.getLast().addChaine(c);
  }

  public void justifier(int n) {
    this.lignes.forEach(e -> e.justifier(n));
  }

  @Override
  public String toString() {
    return this.lignes.stream().map(Ligne::toString).reduce("", String::concat);
  }
}
