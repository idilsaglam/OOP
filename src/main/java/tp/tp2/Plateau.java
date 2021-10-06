package tp.tp2;

import java.util.Random;

public class Plateau {
    private int hauteur;
    private int largeur;
    private int nbMines;
    private int nbDrapeaux;
    private boolean[][] mines;
    private int[][] etats; //0 signifie une case cachée avec le drapeau, 1 signifie cachée avec drapeau 2 signifie révélee
    private int[][] adja; // le nb de mines adjacentes à chaque chase.

    public Plateau(int ha, int la, int mi ){
        this.hauteur = ha;
        this.largeur = la;
        this.nbMines = mi;

        mines = new boolean[ha+2][la+2];
        etats = new int[ha+2][la+2];
        adja = new int[ha+2][la+2];
    }

    private void ajouteMinsAle(){
        Random rd = new Random();
        int nb =0;
        for(int c=0; c<nbMines; c++){
          for (int i = 0; i < mines.length; i++) {
            for (int j = 0; j < mines[i].length; j++) {
                mines[i][j] = rd.nextBoolean();
            }
          }
        }
    }

    private void calculeAdjacence(){

    }
}
