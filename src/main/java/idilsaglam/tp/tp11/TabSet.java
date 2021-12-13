/* (C)2021 */
package idilsaglam.tp.tp11;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

@SuppressWarnings("unchecked")

// Nous n'avons plus besoin d'implémenter Iterator<E>. Parce que l'interface Set<E> hérite de
// l'interface Collection<E> qui hérite de l'interface Iterabla<E>
public class TabSet<E> implements Set<E> {
  private E[] tableau;

  // L'attribut statique final va contenir la valeur par défaut pour la taille du tableau
  private static final int TAILLE_MAX = 10;

  /**
   * Crée une nouvelle instance de TabSet. Le tableau va être initialise avec une taille par défaut.
   */
  public TabSet() {
    this.tableau = (E[]) new Object[TabSet.TAILLE_MAX];
  }

  /**
   * Renvoie l'iterator lié à l'instance courant de TabSet
   *
   * @return TabIter lié à l'instance courant de TabSet
   */
  @Override
  public Iterator<E> iterator() {
    return new TabIter();
  }

  /**
   * Fonction renvoie un tableau des éléments de même taille que TabSet courant. Sans élément
   * nulles.
   *
   * @return Le tableau crée par le TabSet courant
   */
  @Override
  public Object[] toArray() {
    // On va créer un tableau suffisamment grand
    Object[] result = new Object[this.size()];
    // On rempli ce tableau par la fonction toArray(T[] a) et retourne le tableau retourné.
    return this.toArray(result);
  }

  /**
   * Fonction qui renvoi un tableau avec les éléments de TabSet courant.
   *
   * @param a Le tableau à remplir. Si le tableau n'est pas de taille suffissant. On va créer un
   *     nouveau tableau
   * @param <T> Le type des éléments de a
   * @return Renvoie le tableau remplit
   */
  @Override
  public <T> T[] toArray(T[] a) {
    // On vérifie d'abord si le tableau passé en paramètres est suffisamment grand
    if (a.length >= this.size()) {
      /* Si le tableau est suffisamment grand. Nous allons ajouter les éléments dans le tableau a.
       Les cases restant vont égale à null par défaut.
      */
      // On initialise un compteur pour insérer correctement les éléments dans le tableau
      int i = 0;
      // On itère sur les éléments de TabSet
      for (E e : this) {
        if (e == null) {
          // Si l'élément courant est null. On va pas l'insérer donc on continue à itérer
          continue;
        }
        // Sinon on insère l'élément à l'index i du tableau qu'on a crée
        a[i] = (T) e;
        // On incrémente la valeur du compteur i.
        i++;
      }
      return a;
    }
    // Si le tableau a n'est pas suffisamment grand. On va réinitialiser sa valeur par un tableau
    // suffisamment grand
    a = (T[]) new Object[this.size()];
    // Et on va rappeller cete fonction avec ce nouveau a
    return (T[]) this.toArray((Object[]) a);
  }

  /**
   * Fonction vérifie si un élément est existe dans le TabSet courant ou pas
   *
   * @param o L'élément à vérifier
   * @return True si l'élément existe dans le TabSet courant, false sinon
   */
  public boolean contains(Object o) {
    // On itère sur le TabSet courant
    for (E elem : this) {
      if (elem != null && elem.equals(o)) {
        // Si l'élément passé en paramètres est égale à l'élément qu'on est dessus. C'est gagné on
        // retourne true
        return true;
      }
    }
    // Si on a itéré sur toutes les éléments mais on n'a pas trouvé notre élément. On va retourner
    // false
    return false;
  }

  /**
   * Retourne le nombre d'éléments dans l'ensemble courant
   *
   * @return La taille de l'ensemble courant
   */
  public int size() {
    // On initialise un compteur des éléments non null
    int result = 0;
    // On itère sur l'ensemble courant
    for (E elem : this) {
      // On vérifié si l'élément est null
      if (elem == null) {
        // Si c'est le cas, on fait rien on continue à itèrer
        continue;
      }
      // Sinon on incrément notre compteur de taille
      result++;
    }
    // Retourne le nombre des éléments non nulls
    return result;
  }

  /**
   * Fonction vérifie si l'ensemble courant est vide ou pas
   *
   * @return True si l'ensemle courant est vide, false sinon
   */
  public boolean isEmpty() {
    // L'ensemble est vide si le nombre des éléments non nulls sont 0
    return this.size() == 0;
  }

  /**
   * Fonction ajoute une élément dans l'ensemble courant
   *
   * @param e L'élément à ajouter
   * @return True si on a ajoué l'élément, false sinon
   */
  public boolean add(E e) {
    // On vérifie si l'ensemble courant contiens éléments à ajouter
    if (this.contains(e)) {
      // Si c'est le cas on va pas ajouter élément. On va retourner false
      return false;
    }
    // Si l'élément n'existe pas dans l'ensemble courant.
    try {
      // On essaye de le faire ajouter à itérator lié à cet ensemble
      ((TabIter) this.iterator()).add(e);
      // Si la fonction add de l'itérator ne lève pas d'exception. On retourne true
      return true;
    } catch (NullPointerException ignore) {
      return false;
    } catch (IllegalStateException ignore) {
      // S'il n'y a pas de place dans l'ensemble. On initialise un tableau 2 fois plus grand
      E[] t = (E[]) new Object[this.tableau.length * 2];
      // On copie les éléments du tableau existants sur ce nouveau tableau
      System.arraycopy(this.tableau, 0, t, 0, this.tableau.length);
      // On re-initialise l'attribut tableau de la classe TabSet par ce nouveau tableau
      this.tableau = t;
      // on rappelle la même fonction pour ajouter cet nouvel élément.
      return this.add(e);
    }
  }

  /**
   * Supprime un élément de l'ensemble courant
   *
   * @param o Element à supprimer
   * @return True si élément est supprimé, false sinon
   */
  public boolean remove(Object o) {
    // On crée l'itérateur lié à cet ensemble
    TabIter iterator = (TabIter) this.iterator();
    // On itère sur l'ensemble courant
    while (iterator.hasNext()) {
      // Pour chaque élément de l'ensemble
      E e = iterator.next();
      // On vérifie s'il est égale à l'élément qu'on cherche
      if (e != null && e.equals(o)) {
        // Si c'est le cas on appelle la fonction remove de l'itérateur
        iterator.remove();
        // Et on renvoie true
        return true;
      }
    }
    // Si on a itéré sur tous les éléments de l'ensemble et on n'a pas trouvé. On renvoie false
    return false;
  }

  /**
   * Vérifie si tous les éléments de c existe dans l'ensemble courant
   *
   * @param c La collection qu'on va vérifier ses éléments s'ils existent dans l'ensemble courant
   * @return True si tous les éléments de c existent dans l'ensemble courant, false sinon
   */
  @Override
  public boolean containsAll(Collection<?> c) {
    // On itère sur la collection c
    for (Object o : c) {
      // On vérifie si l'ensemble courant contient l'élément de c qu'on est en traint d'itérer
      if (this.contains(o)) {
        // Si c'est le cas on continue à itérer sur c
        continue;
      }
      // Sinon on renvoie false. Il suffit d'un élément différent pour renvoyer false
      return false;
    }
    // Si tous les éléments de c existent dans l'ensemble courant. On renvoie true
    return true;
  }

  /**
   * Ajoute tous les éléments d'une collection à l'ensmeble courant
   *
   * @param c La collection qu'on va ajouter ses éléments
   * @return True si l'ensemble courant est modifié, false sinon
   */
  @Override
  public boolean addAll(Collection<? extends E> c) {
    // On crée un boolean comme résultat. Et on initialise à false.
    boolean result = false;
    // On itère sur la collection c
    for (E o : c) {
      // Vérifions si l'élément sur lequel nous sommes est non null
      if (o != null) {
        // Si c'est le cas. On ajoute cet élément à l'ensemble. Le résultat de l'ajout va être
        // additionné sur la variable result avec l'opération or.
        result = this.add(o) || result;
      }
    }
    // On retourne la valeur de la variable result
    return result;
  }

  /**
   * Modifie l'ensemble courant pour garder uniquement les éléments existent à la fois dans
   * l'ensembel courant et dans une collection donnée
   *
   * @param c La collection donnée
   * @return True si l'ensemble courant est modifié, false sinon
   */
  @Override
  public boolean retainAll(Collection<?> c) {
    // On crée une variable de type booléen et on initialise à false
    boolean result = false;
    // On itère sur les éléments de l'emseble courant
    for (E e : this) {
      // On vérifie si l'élement existe dans la collection passé en paramètres
      if (c.contains(e)) {
        // Si c'est la cas, on fait rien, on continue à itérer
        continue;
      }
      // sinon on enlève cet élément et on ajoute le résultat de la suppression à la variable
      // resultat par l'opération or
      result = this.remove(e) || result;
    }
    // On retourne la valeur de la variable result
    return result;
  }

  /**
   * Enlève tous les éléments d'une collection de l'ensemble courant
   *
   * @param c La collection dont laquel on va enlèver ses éléments
   * @return True si l'ensemble courant est modififé, false sinon
   */
  @Override
  public boolean removeAll(Collection<?> c) {
    // On initialise une variable de type booléen et on l'initialise à false
    boolean result = false;
    // Pour chaque élément de la collection c
    for (Object o : c) {
      // On enlève l'élément de l'ensemble courant et on ajoute le résultat de la suppression par
      // l'opération or à la variable result
      result = this.remove(o) || result;
    }
    // On retourne la variable result
    return result;
  }

  /** Vide l'ensemble */
  public void clear() {
    // On crée un itérator
    TabIter iterator = (TabIter) this.iterator();
    // Pour chaque élément de l'ensemble
    while (iterator.hasNext()) {
      iterator.next();
      // On le supprime
      iterator.remove();
    }
  }

  @Override
  public String toString() {
    String result = "[";
    for (E elem : this) {
      if (elem == null) {
        continue;
      }
      result += elem.toString() + ",";
    }
    return result.replaceAll(",$", "") + "]";
  }

  private class TabIter implements Iterator<E> {
    private int index;

    /** Crée un itérateur pour la classe TabSet */
    public TabIter() {
      // On démarre avec l'index 0
      this.index = 0;
    }

    /**
     * Vérifie s'il reste encore des éléments à itérer dessus
     *
     * @return True s'il reste encore des éléments à itérer dessus, false sinon
     */
    @Override
    public boolean hasNext() {
      // Si l'index est toujours inférieur à la taille du tableau de Tabset on renvoie true.
      return this.index < tableau.length;
    }

    /**
     * Renvoie la valeur de l'élément à l'index courant et avance l'itérateur
     *
     * @return L'élément à l'index courant
     */
    @Override
    public E next() {
      // Récupère l'élément à l'index courant
      final E elem = tableau[this.index];
      // On incrémént l'index courant
      this.index++;
      // Retourne l'élément récupéré
      return elem;
    }

    /**
     * Ajoute une élément à l'ensemble TabSet
     *
     * @param e Element à ajouter
     * @throws NullPointerException Si l'élement à ajouter est null
     * @throws IllegalStateException S'il n'y a pas de place dans l'nsemble
     */
    public void add(E e) throws NullPointerException, IllegalStateException {
      // On vérifie si l'élément à ajouter est null
      if (e == null) {
        // Si c'est la cas, on soulève un NullPointerException
        throw new NullPointerException();
      }
      // On itère avec l'itérateur courant
      while (this.hasNext()) {
        // On récupère l'élément courant
        E elem = this.next();
        // On vérifie si l'élément courant est null
        if (elem == null) {
          // Si c'est le cas, on ajoute l'élément passé en paramètres, à l'index de l'élément
          // courant
          tableau[index - 1] = e;
          // On sort de la fonction
          return;
        }
      }
      // Si on a itéré jusqu'à la fin d'itérateur mais nous avons toujours pas quitté la fonction.
      // Ca veut dire qu'il ne reste plus de place. On lève une exception IllegalStateException
      throw new IllegalStateException();
    }

    /**
     * Supprime l'élément à l'index courant
     *
     * @throws IllegalStateException Si cet appel ne precède pas par un appel de next()
     */
    public void remove() throws IllegalStateException {
      // On vérifie s'il y a eu au moins un appel de la fonction nexf() avant l'appel de celle-ci
      if (this.index == 0) {
        // Si l'index courant est 0
        throw new IllegalStateException();
      }
      // On enlève l'élément à l'index précédent.
      tableau[this.index - 1] = null;
    }
  }
}
