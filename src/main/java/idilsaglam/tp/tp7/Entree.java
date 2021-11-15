/* (C)2021 */
package idilsaglam.tp.tp7;

public class Entree {
  private Element element;
  private String nom;
  private Dossier parent;

  public Entree(Dossier p, String n, Element e) {
    this.parent = p;
    this.nom = n;
    this.element = e;
  }

  @Override
  public String toString() {
    return String.format(
        "%s (%s) ", this.nom, (this.element == null ? "entrée vide" : this.element.getType()));
  }

  public Element getElement() {
    return this.element;
  }

  /** Fonction supprime l'entrée du dossier parent */
  public void supprimer() {
    this.parent.supprimer(this);
    this.parent = null;
  }

  public void remplacer(Element e) {
    if (e instanceof Dossier) {
      this.supprimer();
      this.parent = ((Dossier) e).getParent();
      this.parent.ajouter(this);
    }
    this.element = e;
  }

  /**
   * Renvoie le nom de l'entrée courant
   *
   * @return Le nom de l'entrée courant
   */
  public String getNom() {
    return this.nom;
  }
}
