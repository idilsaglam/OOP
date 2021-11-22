/* (C)2021 */
package idilsaglam.tp.tp7.materiel;

import java.util.LinkedList;

public class Dossier {
  private LinkedList<Entree> listEntre;
  private Dossier dossierParent;

  public Dossier(Dossier dossierParent) {
    this.dossierParent = dossierParent;
    this.listEntre = null;
  }

  public Dossier getDossierParent() {
    return dossierParent;
  }

  public LinkedList<Entree> getListEntre() {
    return listEntre;
  }

  public void setDossierParent(Dossier dossierParent) {
    this.dossierParent = dossierParent;
  }

  public void setListEntre(LinkedList<Entree> listEntre) {
    this.listEntre = listEntre;
  }
  /*public Entree getEntree(String nom){
      return this.
  }*/
}
