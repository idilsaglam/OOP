/* (C)2021 */
package idilsaglam.tp.tp11;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test {

  public static void main(String[] args) {
    Integer[] tab = new Integer[10];
    for (int i = 0; i < tab.length; i++) {
      tab[i] = i;
    }
    TestIter<Integer> iterator = new TestIter<>(tab);
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
    TabSet<Integer> tabSetInteger = new TabSet<>();
    System.out.printf("La taille de l'ensemble après sa création est %d\n", tabSetInteger.size());
    System.out.println(tabSetInteger);
    for (int i = 0; i < 100; i++) {
      tabSetInteger.add(i);
    }
    System.out.printf(
        "La taille de l'ensemble après les ajouts successifs est %d\n", tabSetInteger.size());
    System.out.println(tabSetInteger);
    for (int i = 0; i < 10; i++) {
      Random r = new Random();
      int e = r.nextInt(100);
      tabSetInteger.remove(e);
      tabSetInteger.remove(e * 1000);
    }
    System.out.printf(
        "La taille de l'ensemble après les suppressions successifs est %d\n", tabSetInteger.size());
    System.out.println(tabSetInteger);
    Integer[] intArray = new Integer[10];
    System.out.printf("La taille du tableau des entiers vide %d\n", intArray.length);
    final Object[] o = tabSetInteger.toArray(intArray);
    System.out.printf("La taille du tableau des entiers rempli %d\n", o.length);
    tabSetInteger.clear();
    System.out.printf("La taille de l'ensemble après clean %d\n", tabSetInteger.size());
    System.out.println(tabSetInteger);
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      list.add(22);
    }
    tabSetInteger.addAll(list);
    System.out.printf("La taille de l'ensemble après addAll %d\n", tabSetInteger.size());
    System.out.println(tabSetInteger);
    System.out.printf(
        "Ensemble contains tous les éléments de la liste ? %b\n", tabSetInteger.containsAll(list));
    tabSetInteger.add(-1);
    for (int i = 0; i < 100; i++) {
      tabSetInteger.add(i);
    }
    System.out.printf("La taille de l'ensemble après les ajouts %d\n", tabSetInteger.size());
    System.out.println(tabSetInteger);
    tabSetInteger.removeAll(list);
    System.out.printf("La taille de l'ensemble après la suppression %d\n", tabSetInteger.size());
    System.out.println(tabSetInteger);
    tabSetInteger.add(22);
    tabSetInteger.retainAll(list);
    System.out.printf("La taille de l'ensemble après retainAll %d\n", tabSetInteger.size());
    System.out.println(tabSetInteger);
  }
}
