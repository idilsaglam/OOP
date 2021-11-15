/* (C)2021 */
package idilsaglam.tp.tp7;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Dossier extends Element implements Affichable {
  private LinkedList<Entree> entrees;
  private Dossier parent;

  public Dossier(LinkedList<Entree> entrees, Dossier parent) {
    this.entrees = entrees;
    this.parent = parent;
  }

  public Dossier(Dossier parent) {
    this.entrees = new LinkedList<>();
    this.entrees.add(new EntreeSpeciale(this, ".", this));
    this.parent = parent;
    if (this.parent != null) {
      this.entrees.add(new EntreeSpeciale(this, "..", this.parent));
    }
  }

  /**
   * Fonction ajoute une entrée à liste des entrées
   *
   * @param e L'entrée à ajouter
   */
  public void ajouter(Entree e) {
    this.entrees.add(e);
  }

  public void ajouter(String name, Element element) {
    this.entrees.add(new Entree(this, name, element));
  }

  /**
   * Fonction ajoute une entrée à la lste des entrées à l'index donnée
   *
   * @param index L'index à laquelle entrée va être ajouté
   * @param e L'entrée à ajouter
   */
  public void ajouter(int index, Entree e) {
    this.entrees.add(index, e);
  }

  /**
   * Fonction renvoie le parent du dossier courant
   *
   * @return Le parent du dossier courant
   */
  public Dossier getParent() {
    return this.parent;
  }

  /**
   * Fonction renvoie l'entrée avec le nom passé en paramètres
   *
   * @param nom Le nom d'entrée à chercher
   * @return L'entrée avec le nom passé en paramètre, null sinon
   */
  public Entree getEntree(String nom, boolean creer) {
    List<Entree> results =
        this.entrees.stream().filter(e -> e.getNom().equals(nom)).collect(Collectors.toList());
    if (results.size() == 0) {
      if (creer) {
        Entree e = new Entree(this, nom, null);
        this.ajouter(e);
        return e;
      }
      return null;
    }
    return results.get(0);
  }

  @Override
  public String getType() {
    return "dossier";
  }

  /**
   * Fontion supprime l'entrée passé en paramètres de la liste des entrées.
   *
   * @param e L'entrée à supprimer
   */
  protected void supprimer(Entree e) {
    this.entrees.remove(e);
  }

  @Override
  public void afficher() {
    this.entrees.forEach(System.out::println);
  }

  public boolean estEnfantDe(Dossier d) {
    if (this.equals(d)) {
      return true;
    }
    if (this.parent == null) {
      return false;
    }
    return this.parent.estEnfantDe(d);
  }

  public Dossier getRacine() {
    Dossier d = this.parent;
    if (d == null) {
      return this;
    }
    while (d.parent != null) {
      d = d.parent;
    }
    return d;
  }
}
