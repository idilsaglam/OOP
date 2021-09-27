package tp.tp2;

public class Plateau {
    private int hauteur;
    private int largeur;
    private int nbMines;
    private int nbDrapeaux;
    private boolean[][] mines;
    private int[][] etats; //0 signifie une case cachée avec le drapeau, 1 signifie cachée avec drapeau 2 signifie révélee
    private int[][] adja; // le nb de mines adjacentes à chaque chase.

    public Plateau(int ha, int la, int mi ){

    }
}
