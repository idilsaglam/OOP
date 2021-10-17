/* (C)2021 */
package idilsaglam.tp.tp1.exercice5;

public class Combat {
  public static void main(String[] args) {
    Personnage
        p1 =
            new Personnage(
                "Düdük", new Informations(100, 100, 100), new Informations(100, 100, 100)),
        p2 = new Personnage("Düdükoviç", new Informations(50, 50, 50)),
        gagnant;

    System.out.println(
        "-------------------------------------------------------------------------------------------------");
    System.out.println(
        "--------------------------------------------ITERATIVE--------------------------------------------");
    System.out.println(
        "-------------------------------------------------------------------------------------------------");

    p1.lutte(p2);
    gagnant = p1.estVivant() ? p1 : p2;
    System.out.printf("%s a gagné!", gagnant.getNom());

    System.out.println(
        "-------------------------------------------------------------------------------------------------");
    System.out.println(
        "--------------------------------------------RECURSIVE--------------------------------------------");
    System.out.println(
        "-------------------------------------------------------------------------------------------------");

    p1 = new Personnage("Düdük", new Informations(100, 100, 100), new Informations(100, 100, 100));
    p2 = new Personnage("Düdükoviç", new Informations(50, 50, 50));
    p1.lutteRec(p2);
    gagnant = p1.estVivant() ? p1 : p2;
    System.out.printf("%s a gagné!", gagnant.getNom());
  }
}
