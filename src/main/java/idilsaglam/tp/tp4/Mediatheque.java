/* (C)2021 */
package idilsaglam.tp.tp4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Mediatheque {

  private final LinkedList<Media> baseDeDonnees;

  public Mediatheque() {
    this.baseDeDonnees = new LinkedList<>();
  }

  /**
   * Fonction qui ajoute une nouvelle Media à la base de données
   *
   * @param doc Le nouveau média à ajouter.
   */
  public void ajouter(Media doc) {
    // On parcourt la liste des médias
    for (int i = 0; i < baseDeDonnees.size(); i++) {
      // A chaque itération on contrôle si le média à ajouter est plus petit que le média actuel
      if (doc.plusPetit(this.baseDeDonnees.get(i))) {
        // Si c'est le cas, c'est à dire qu'on a trouvé l'indice à laquelle on va ajouter le média.
        this.baseDeDonnees.add(i, doc);
        // Une fois c'est ajouté, on a plus rien à faire. Donc on quitte la fonction.
        return;
      }
    }
    // Si on arrive là, c'est parce que soit la liste est vide, soit on doit ajouter à la fin de la
    // liste
    this.baseDeDonnees.add(doc);
  }

  /** Une méthode qui imprime tous les dictionnaires */
  public void tousLesDictionnaires() {
    this.baseDeDonnees.stream().filter(m -> m instanceof Dictionnaire).forEach(System.out::println);
    /*
    Une façon plus classique de le faire.
    for(int i=0; i< baseDeDonnees.size();i++){
        if(this.baseDeDonnees.get(i) instanceof Dictionnaire){
            System.out.println(this.baseDeDonnees.get(i).toString());
        }
    }
    */
  }

  /**
   * Une méthode qui qui retourne tous les médias pour lesquels p est vrai
   *
   * @param p La fonction prédicat à exécuter
   * @return true si tous les médias pour lesquels p est vrai sinon false
   */
  public ArrayList<Media> recherche(Predicat p) {
    return this.baseDeDonnees.stream()
        .filter(p::estVrai)
        .collect(Collectors.toCollection(ArrayList::new));
    /*
    Une autre façon de le faire
     ArrayList<Media> a = new ArrayList<>();
       for(int i=0; i<baseDeDonnees.size(); i++){
           if(p.estVrai(baseDeDonnees.get(i))){
               a.add(baseDeDonnees.get(i));
           }
       }
       return a;
       */
  }

  /** La fonction affiche tous les éléments de la base des données */
  public void affiche() {
    this.baseDeDonnees.forEach(System.out::println);
  }

  public static void main(String[] args) {
    Mediatheque m = new Mediatheque();
    // System.out.println(m.toString());
    Livre l0 = new Livre("Livre1", "Idil Saglam", 10);
    DVD d0 = new DVD(105, "Kaan Yagci", "Francais", "Duduk Idik");
    DVD d1 = new DVD(111, "OOP", "Russe", "Mahmut abi");
    Dictionnaire dico0 = new Dictionnaire("Japonais", 300, "dicot");
    Dictionnaire dico1 = new Dictionnaire("Français", 200, "dictf");
    DVD d2 = new DVD(105, "Kaan Yagci", "Francais", "SOIREE");
    Livre l1 = new Livre("Livre1", "Kaan Yagcim", 100);
    Dictionnaire dico2 = new Dictionnaire("Français", 200, "Salamica");
    Livre l2 = new Livre("sucrée", "Idil Saglam", 10);

    /* System.out.println(f.toString());
    System.out.println(l.toString());
    System.out.println(d.toString());*/

    Predicat p = new Et(new EstUnLivre(), new TitreCommencePar('S'));
    Predicat p1 = new TitreEstAPeuPres("dic", 2);
    Predicat p2 = new TitreContiensSousChaine("ic");
    m.ajouter(l0);
    m.ajouter(d1);
    m.ajouter(d2);
    m.ajouter(dico0);
    m.ajouter(l1);
    m.ajouter(l2);
    m.ajouter(dico1);
    m.ajouter(dico2);
    m.ajouter(d0);

    // m.affiche();
    // m.recherche(p).forEach(System.out::println);
    // m.recherche(p1).forEach(System.out::println);
    m.recherche(p2).forEach(System.out::println);
    // m.tousLesDictionnaires();

  }
}
