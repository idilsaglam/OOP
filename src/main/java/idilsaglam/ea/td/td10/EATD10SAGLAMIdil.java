/* (C)2021 */
package idilsaglam.ea.td.td10;

import java.util.ArrayList;
import java.util.List;

public class EATD10SAGLAMIdil {

  // La classe node représent un noeud d'un arbre binaire
  private static class Node<T> {
    // Nous avons deux sous-arbre gauche et droit
    private Node<T> left, right;
    // Nous avons un contenu des noeuds
    private final T content;

    /**
     * Initialise une feuille avec le contenu passé en paramètres
     *
     * @param content Le contenu du noeud
     */
    public Node(T content) {
      this.content = content;
      this.left = null;
      this.right = null;
    }

    /**
     * Retourne le contenu du noeud
     *
     * @return Le contenu du noeud
     */
    public T getContent() {
      return this.content;
    }

    /**
     * Permet de changer le sous-arbre gauche de l'arbre courant
     *
     * @param left Le nouveau sous-arbre gauche
     */
    public void setLeft(Node<T> left) {
      this.left = left;
    }

    /**
     * Permet de changer le sous-arbre droit de l'arbre courant
     *
     * @param right Le nouveau sous-arbre droit
     */
    public void setRight(Node<T> right) {
      this.right = right;
    }

    /**
     * Retourne le sous-arbre gauche de l'arbre courant
     *
     * @return Le sous-arbre gauche de l'arbre courant
     */
    public Node<T> getLeft() {
      return this.left;
    }

    /**
     * Retourne le sous-arbre droit de l'arbre courant
     *
     * @return Le sous-arbre droit
     */
    public Node<T> getRight() {
      return this.right;
    }
  }

  /**
   * Fonction qui renvoie le code prefixe décrit en cours de l’arbre général correspondant
   *
   * @param binaryTree un arbre binaire sans sous-arbre droit
   * @return Le code prefix décrit en cours de l'arbre général correspondant
   */
  public static List<Integer> trasfBinGen(Node<Integer> binaryTree) {
    /*
      Le parcours prefix de arbre binaire sans sous arbre droit
      est le même que celui de l'arbre général associé. Donc il suffit de calculer le parcours
      prefix de l'arbre binaire sans sous-arbre droit
    */
    // Nous créons une list qui va contenir le parcours prefix
    List<Integer> result = new ArrayList<>();
    if (binaryTree == null) {
      // Si l'arbre en question est null on a rien à parcourir on va retourner la liste vide
      return result;
    }
    // On ajoute d'abord la racine de l'arbre dans la liste
    result.add(binaryTree.getContent());
    /*
    On continue avec le sous-arbre gauche.
    On concatène notre liste actuelle avec la parcours preifx du sous-arbre gauche.
    */
    result.addAll(trasfBinGen(binaryTree.getLeft()));
    /*
     * Pour finir on concatène le parcours préfix de sous-arbre droit
     */
    result.addAll(trasfBinGen(binaryTree.getRight()));
    // On retourne la liste qui contient le parcours prefix
    return result;
  }

  public static void main(String[] args) {
    // Créons l'arbre binaire affiché dans les diapos
    Node<Integer> bn1 = new Node<>(1),
        bn2 = new Node<>(2),
        bn3 = new Node<>(3),
        bn4 = new Node<>(6),
        bn5 = new Node<>(9),
        bn6 = new Node<>(4),
        bn7 = new Node<>(7),
        bn8 = new Node<>(8),
        bn9 = new Node<>(5);
    bn2.setRight(bn1);
    bn3.setRight(bn2);
    bn4.setLeft(bn3);
    bn5.setRight(bn4);
    bn7.setRight(bn6);
    bn8.setRight(bn5);
    bn8.setLeft(bn7);
    bn9.setLeft(bn8);

    List<Integer> parcoursPrefix = trasfBinGen(bn9);

    System.out.printf("[ ");
    for (Integer i : parcoursPrefix) {
      System.out.printf("%d ", i);
    }
    System.out.printf("]\n");
  }
}
