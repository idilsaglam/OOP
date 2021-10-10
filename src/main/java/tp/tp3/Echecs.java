package tp.tp3;

public class Echecs {
  static Plateau plateau = new Plateau(8, 8);

  static boolean joueur;
  static Communication comm = new Communication();

  private static void remplirLesPieces(boolean c) {
    for (int j = 0; j < plateau.getLargeur(); j++) {
      plateau.remplirCase(1, j, new Pion(c));
      plateau.remplirCase(6, j, new Pion(!c));
      switch (j) {
        case 0:
        case 7:
          plateau.remplirCase(0, j, new Tour(c));
          plateau.remplirCase(7, j, new Tour(!c));
          break;
        case 1:
        case 6:
          plateau.remplirCase(0, j, new Cavalier(c));
          plateau.remplirCase(7, j, new Cavalier(!c));
          break;
        case 2:
        case 5:
          plateau.remplirCase(0, j, new Fou(c));
          plateau.remplirCase(7, j, new Fou(!c));
          break;
        case 3:
          plateau.remplirCase(0, j, new Dame(c));
          plateau.remplirCase(7, j, new Dame(!c));
          break;
        default:
          plateau.remplirCase(0, j, new Roi(c));
          plateau.remplirCase(7, j, new Roi(!c));
          break;
      }
    }
  }

  /**
   * Fonction qui simule un tour de jeu
   *
   * @param d Le déplacement
   * @param joueur Le joueur
   * @return -1 si la case de départ est vide ou le coup est invalid, 0 joueur a gagné, 1 sinon
   */
  private static int jouerTour(Deplacement d, boolean joueur) {
    System.out.println("DEPLACEMENT " + d.toString());
    if (plateau.getCase(d.getX0(), d.getY0()).estVide()) {
      System.out.println("CASE EST VIDE");
      return -1;
    }
    Piece piece = plateau.getCase(d.getX0(), d.getY0()).getPiece();
    Piece pe;
    if (piece.getCouleur() == joueur && piece.estValide(d, plateau)) {
      plateau.videCase(d.getX0(), d.getY0());
      pe = plateau.getCase(d.getX0(), d.getY0()).getPiece();
      plateau.remplirCase(d.getX1(), d.getY1(), piece);
      if (pe != null && pe.estRoi()) {
        return 0;
      }
      return 1;
    }
    return -1;
  }


  private static void jouerPartie() {
    String jname = (joueur ? "blanc": "noir");
    plateau.afficher();
    System.out.printf("Le tour de joueur %s\n", jname);
    int result = jouerTour(comm.demanderDeplacement(plateau.getLongueur(), plateau.getLargeur()), joueur);
    switch (result){
      case 0:
        System.out.printf("%s a gangé! Bravo", jname);
        return;
      case 1:
        joueur = !joueur;
        break;
    }
    jouerPartie();
  }


  public static void main(String[] args) {

    joueur = true;
    remplirLesPieces(true);
    jouerPartie();


    /*System.out.println("Testing Deplacement class");
    System.out.print("Is d1 correct? ");
    Deplacement d = new Deplacement(1, 5, 3, 3);
    System.out.println(d.typeDeplacement() == 'd');
    System.out.print("Is distance d1 correct? ");
    System.out.println(d.dist() == 2);

    System.out.print("Is d2 correct? ");
    d = new Deplacement(5, 1, 2, 1);
    System.out.println(d.typeDeplacement() == 'v');
    System.out.print("Is distance d2 correct? ");
    System.out.println(d.dist() == 3);

    System.out.print("Is d3 correct? ");
    d = new Deplacement(1, 1, 2, 3);
    System.out.println(d.typeDeplacement() == 'c');
    System.out.print("Is distance d3 correct? ");
    System.out.println(d.dist() == -1);

    System.out.print("Is d4 correct? ");
    d = new Deplacement(5, 6, 1, 5);
    System.out.println(d.typeDeplacement() == 'x');
    System.out.print("Is distance d4 correct? ");
    System.out.println(d.dist() == -1);

    System.out.println("End of Deplacement class tests");*/
  }
}
