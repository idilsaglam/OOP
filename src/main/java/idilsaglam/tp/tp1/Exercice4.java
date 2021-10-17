/* (C)2021 */
package idilsaglam.tp.tp1;

import java.util.Random;
import java.util.Scanner;

public class Exercice4 {

  /**
   * la fonction calcule le nombre de tentatives pour trouver la bonne réponse
   *
   * @param expected La bonne réponse à trouver
   * @param sc Le Scanner qui permet de récupérer la saisie d'utilisateur
   * @return Le nombre de tentatives pour trouver la bonne réponse
   */
  public static int tentative(int expected, Scanner sc) {
    return 1 + (sc.nextInt() == expected ? 0 : tentative(expected, sc));
  }

  /**
   * Exercice 4.1 Une fonction qui choisit deux nombres aléatoires entre 1 et 9 et demande à
   * l’utilisateur le résultat de leur multiplication.
   *
   * @return le nombre de tentatives qui ont été nécessaires pour trouver la bonne réponse.
   */
  public static int question() {

    Random rd = new Random();
    int nb1 = rd.nextInt(9) + 1;
    int nb2 = rd.nextInt(9) + 1;

    return tentative(nb1 * nb2, new Scanner(System.in));
  }

  /**
   * Fonction qui calcule le nombre d'erreurs lors d'interrogation utilisateurs sur le tableau de
   * multiplication
   *
   * @param n Le nombre de questions à poser à l'utilisateur
   * @return Le nombre de fois que l'utilisateur n'a pas trouvé la bonne réponse.
   */
  public static int evalError(int n) {
    if (n == 1) {
      return question() - 1;
    }
    return question() - 1 + evalError(n - 1);
  }

  /**
   * Exercice 4.2 Une fonction qui interroge l’utilisateur n fois sur ses tables de multiplication,
   * puis retourne une note entre 0 et 20 (chaque mauvaise réponse fait perdre un point).
   *
   * @param n
   * @return La note total de l'utilisateur
   */
  public static int evaluation(int n) {
    return 20 - evalError(n);
  }

  public static void main(String[] args) {
    question();
  }
}
