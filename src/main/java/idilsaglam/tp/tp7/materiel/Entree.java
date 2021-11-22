/* (C)2021 */
package idilsaglam.tp.tp7.materiel;

public class Entree extends Dossier {
  private Element element;
  private String nom;
  private Dossier parent;

  public Entree(Dossier p, String n, Element e) {
    super(p);
    this.element = e;
    this.nom = n;
    this.parent = p;
  }

  public String getNom() {
    return this.nom;
  }

  public Element getElement() {
    return this.element;
  }

  public Dossier getParent() {
    return this.parent;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public void setParent(Dossier parent) {
    this.parent = parent;
  }

  public void setElement(Element element) {
    this.element = element;
  }

  public void supprimer() {
    this.element = null;
    this.nom = "";
  }

  public void remplacer(Element e) {}

  /**
   * Une méthode qui renvoie le nom de l'entrée et le type de l'élément correspondant
   *
   * @return nom (dossier) pour un dossier, nom(texte) pour un texte et nom(entrée vide) pour le
   *     vide.
   */
  @Override
  public String toString() {
    return this.nom + " " + "( " + this.element.getType() + " )";
  }
}
