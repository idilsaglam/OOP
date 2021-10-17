/* (C)2021 */
package idilsaglam.tp.tp1.exercice5;

import java.util.Random;

public class Personnage {
  private final Informations initialInformations, currentInformations;
  private final String nom;

  public Personnage(
      String nom, Informations initialInformations, Informations currentInformations) {
    this.nom = nom;
    this.initialInformations = initialInformations;
    this.currentInformations = currentInformations;
  }

  public Personnage(String nom, Informations initialInformations) {
    this.nom = nom;
    this.initialInformations = initialInformations;
    this.currentInformations = initialInformations;
  }

  @Override
  public String toString() {
    return String.format(
        "Nom: %s, Etat initiale: %s Etat actuel: %s",
        this.nom, this.initialInformations.toString(), this.currentInformations.toString());
  }

  public String getNom() {
    return this.nom;
  }

  /**
   * Fonction qui vérifie si la vitalité de l'état actuel est supérieur à 0
   *
   * @return true si la vitalité à l'état actuel est supérieur à 0
   */
  public boolean estVivant() {
    return this.currentInformations.getVitalite() > 0;
  }

  /** Fonction qui restore la vitalité de l'état actuel avec celui de l'état initial */
  public void rebirth() {
    this.currentInformations.setVivalite(this.initialInformations.getVitalite());
  }

  /**
   * Fonction qui permet d'attaquer au Personnage def
   *
   * @param def Le personnage défenseur à attaquer
   */
  public void attaque(Personnage def) {
    Random rd = new Random();
    int n =
        rd.nextInt(
            Math.max(
                1, (this.currentInformations.getForce() - def.currentInformations.getForce())));
    if (def.currentInformations.getAgilite() < this.currentInformations.getAgilite()) {
      System.out.printf(
          "%s attaque à %s. %s perds %d de son vitalité.\n", this.nom, def.nom, def.nom, n);
      def.currentInformations.setVivalite(def.currentInformations.getVitalite() - n);
      return;
    }
    System.out.printf(
        "%s attaque à %s. %s perds %d de son vitalité.\n", this.nom, def.nom, def.nom, n / 2);
    def.currentInformations.setVivalite(def.currentInformations.getVitalite() - n / 2);
    def.currentInformations.setAgilite(def.currentInformations.getAgilite() / 3);
  }

  /**
   * Exercice 5.4.1 L'implémentation itérative de la fonction lutte.
   *
   * @param def le personnage renommé défenseur.
   */
  public void lutte(Personnage def) {
    while (this.estVivant() && def.estVivant()) {
      this.attaque(def);
      if (def.estVivant()) {
        def.attaque(this);
      }
    }
  }

  /**
   * Exercice 5.4.2 l'implémentation récursive de la fonction lutte
   *
   * @param def Le personnage en riposte
   */
  public void lutteRec(Personnage def) {
    if (this.estVivant() && def.estVivant()) {
      this.attaque(def);
      def.lutteRec(this);
    }
  }
}
