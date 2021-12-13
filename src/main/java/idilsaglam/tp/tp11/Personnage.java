/* (C)2021 */
package idilsaglam.tp.tp11;

import java.util.HashMap;

public class Personnage {

  public static final HashMap<Personnage, Integer> scores = new HashMap<>();

  private final String nom, prenom;

  /**
   * Crée une personnage avec le nom et le prénom
   *
   * @param prenom Le prénom du personnage
   * @param nom Le nom du personnage
   */
  public Personnage(String prenom, String nom) {
    this.nom = nom;
    this.prenom = prenom;
    if (Personnage.scores.containsKey(this)) {
      // Si la personnage existe déjà dans le HashMap scores, on fait rien
      return;
    }
    // Si c'est la première fois qu'une personange avec cette couple (prenom, nom) est crée, on
    // calcle son score et ajoute dans le HashMap
    Personnage.scores.put(this, (int) (Math.random() * 11));
  }

  /**
   * Renvoie le nom du personnage
   *
   * @return Le nom du personnage courant
   */
  public String getNom() {
    return this.nom;
  }

  /**
   * Renvoie le prenom du personnage
   *
   * @return Le prénom du personnage courant
   */
  public String getPrenom() {
    return this.prenom;
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof Personnage) {
      // Deux personange sont égaux s'ils ont le même nom et le même prénom
      return ((Personnage) o).getPrenom().equals(this.getPrenom())
          && ((Personnage) o).getNom().equals(this.getNom());
    }
    return false;
  }

  @Override
  public int hashCode() {
    // Ceci est préférable parce que si on met return 0, on va retourner le même hashCode pour tous
    // les peronnages. Quiite à le remplacer par un attribut statique de type int.
    return 109 * this.prenom.hashCode() + this.nom.hashCode();
  }
}
