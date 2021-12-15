package idilsaglam.ea.td.td11;

@SuppressWarnings("unchecked")
public class EATD11SaglamIdil {

  private static class HeapTree<T extends Comparable<T>> {
    public HeapNode<T> root;

    public HeapTree(HeapNode<T> root) {
      this.root = root;
    }

    /**
     * L'insère un nouveu noeud dans l'arbre
     * @param e La valeur du noeud à insérer
     * @param priority La priorité du noeud à insérer
     */
    public void insert(T e, int priority) {
      if (this.root == null) {
        this.root = new HeapNode<>(e, priority);
        return;
      }
      // On fait appel à la fonction insert à la racine
      this.root.insert(e, priority);
      // On reconstruit l'arbre
      this.root.rebuild();
    }

    /**
     * Enlevé et renvoie le noeud avec la priorité plus grand (la racine pour notre cas)
     * @return Renvoie le noeud enlevé
     */
    public HeapNode<T> remove() {
      if (this.root == null) {
        return null;
      }
      HeapNode<T> result;
      if (this.root.isLeaf()) {
        // Si la racine est une feulle, il suffit d'enlever la racine
        result = this.root;
        this.root = null;
        return result;
      }
      // Si la racine n'est pas une feuille, on appele la fonction remove sur la racine
      result = this.root.remove();
      // On reconstruit l'arbre
      this.root.rebuild();
      // On retourne le noeud enlevé
      return result;
    }

  }

  private static class HeapNode<T extends Comparable<T>> implements Comparable<HeapNode<T>> {
    private int priority;
    private T content;
    private HeapNode<T> left, right;

    /**
     * Crée une nouvelle instance de la file de priorité
     * @param content Le contenu de racine
     * @param priority La priorité de racine
     */
    public HeapNode(T content, int priority) {
      this.priority = priority;
      this.content = content;
      this.left = null;
      this.right = null;
    }

    /**
     * Permet de échanger le contenus et les priorités de deux noeuds
     * @param o L'autre noeud avec lequel nous allons échanger le contenu et la priorité
     */
    private void swap(HeapNode<T> o) {
      final T tmpc = this.content;
      this.content = o.content;
      o.content = tmpc;
      final int p = this.priority;
      this.priority = o.priority;
      o.priority = p;
    }

    /**
     * Reconstruire l'arbre pour respecter les priorités
     */
    public void rebuild() {
      if (this.isLeaf()) {
        // Si le noeud est une feuille, on a rien a faire
        return;
      }
      if (this.compareTo(this.left) < 0 || this.compareTo(this.right) < 0) {
        /*
           Si le sous-arbre gauche ou le sous-arbre droit est plus grand que le noeuud courant
           On trouve d'abord quel sous-arbre est plus grand parmi les deux
         */
        if (this.left != null && this.compareTo(this.left) < 0) {
          // Si le sous-arbre gauche est plus grand que le noeud courant, on échange les deux
          this.swap(this.left);
          // On rebuild l'arbre de gauche après échange
          this.left.rebuild();
          return;
        }
        // Si on arrive ici, c'est parce que le sous-arbre gauche n'est pas plus grand que le noeud courant. Dans ce cas, ça doit être le sous-arbre droit qui est plus grand
        // On vérifie d'abord que le sous-arbre droit n'est pas nulle.
        if (this.right != null) {
          // On échange les deux noeuds
          this.swap(this.right);
          // On reconstruit le sous-arbre droit
          this.right.rebuild();
        }
      }
      // Si le noeud courant est plus grand que le sous arbre-gauche et le sous-arbre droit, ça veut dire que les règles sont bien respecté. Pas de reconstruction nécessaire.
    }

    /**
     * Retourne si l'arbre est rempli completement
     * @return True si l'arbre est complet, false sinon
     */
    private boolean isFull() {

      if (this.right == null || this.left == null) {
        // S'il y a au moins, un sous-arbre qui est nulle. Le noeud est complet s'il s'agit d'une feuille
        return (this.right == null && this.left == null);
      }
      // Si les deux sous-arbres sont bien remplis, le noeud est complet si ses deux sous-arbres sont complets.
      return this.right.isFull() && this.left.isFull();
    }



    /**
     * Vérifie si le noeud courant est une feuille
     * @return True si le noeud courant est une feuille, false sinon
     */
    public boolean isLeaf() {
      return this.left == null && this.right == null;
    }

    /**
     * Renvoie le profondeur de l'arbre courant
     * @return Le profondeur de l'arbre
     */
    private int depth() {
      // On initialise les profondeurs gauche et droit par 0
      int leftDepth = 0, rightDepth = 0;
      if (this.left != null) {
        // Si le sous-arbre gauche n'est pas null, on calcule son profondeur
        leftDepth = this.left.depth();
      }
      if (this.right != null) {
        // Si le sous-arbre droit n'est pas null, on calcule son profondeur
        rightDepth = this.right.depth();
      }
      // Le pronfondeur du noeud courant est le maximum des profondeurs de ses sous arbres + 1
      return 1 + Math.max(leftDepth, rightDepth);
    }

    /**
     * Insère un noeud de priorité priority avec le contenu e dans
     * @param e Le contenu de l'élément à insérer
     * @param priority La priorité de l'élément à insérer
     */
    public void insert(T e, int priority) {
      // On vérifie d'abord s'il s'agit d'une feuille
      if (this.isLeaf()) {
        // Si le noeud courant est une feuille, on va insérer à gauche en créant un nouveu noeud
        this.left = new HeapNode<>(e, priority);
        return;
      }
      // On vérifie si le sous-arbre gauche est vide
      if (this.left == null) {
        this.left = new HeapNode<>(e, priority);
        return;
      }
      // On vérifie si le sous-arbre droit est vide
      if (this.right == null) {
        this.right = new HeapNode<>(e, priority);
        return;
      }
      // Si le noeud n'est pas une feuille et les deux sous-arbres sont bien définis, on vérifie si l'arbre est complet
      if (this.isFull()) {
        // si l'arbre est complet, on vérifie
        int ld = this.left.depth(), rd = this.right.depth();
        if (ld < rd) {
          this.left.insert(e, priority);
          return;
        }
        this.right.insert(e, priority);
        return;
      }
      // Si l'arbre n'est pas complet, on va insérer au sous-arbre qui n'est pas complet
      if (this.left.isFull()) {
        // Si le sous-arbre gauche est complet, alors le sous-arbre droit n'est pas complet
        this.right.insert(e, priority);
        // On reconstruit le tas pour respecter l'ordre de priorité
        return;
      }
      // Sinon on insère à son sous-arbre gauche
      this.left.insert(e, priority);
    }

    /**
     * Fonction pousse le noeud courant au plus bas niveau sur la branche de droite
     * @param result Le noeud parent du noeud déplacé finalement
     */
    private HeapNode<T> pushToRightBottom(HeapNode<T> result) {
      if (this.right == null) {
        // Si le sous-arbre droit est null, on retourne le parent passé en paramètres
        return result;
      }
      // Sinon on échange le noeud courant avec son sous-arbre droit
      this.swap(this.right);
      // On continue à déplacer le noeud sur la branche droite en changeans la racine avec la nouvelle noeud (l'ancien noeud de sous-arbre droit)
      return this.right.pushToRightBottom(this);
    }

    /**
     * Enleve l'élément à priorité maximale (racine de l'arbre)
     */
    public HeapNode<T> remove() {
      // On pousse la racine au plus bas sur la branche de droite
      HeapNode<T> parent = this.pushToRightBottom(this);
      // On garde le noeud à retourner dans une variable
      HeapNode<T> result = parent.right;
      // On enlève le fils droite (qui était anciennement la racine de l'arbre)
      parent.right = null;
      // On retourne le noeud enlevé
      return result;
    }

    @Override
    public boolean equals(Object o) {
      if (o instanceof HeapNode) {
        HeapNode<T> h = (HeapNode<T>) o;
        return h.content.equals(this.content) && h.priority == this.priority;
      }
      return false;
    }

    @Override
    public int compareTo(HeapNode<T> o) {
      if (o == null) {
        return 1;
      }
      // On compare d'abord les priorités
      int result = Integer.compare(this.priority, o.priority);
      if (result == 0) {
        // Si les deux noeuds ont le même priorité. On compare leurs contenus.
        result = this.content.compareTo(o.content);
      }
      return result;
    }
  }

  public static void main (String[] args) {
    // TODO: Complete with tests.
    // TODO: Add complexity for each function in classes
    // TODO: Implement array based approach
  }
}
