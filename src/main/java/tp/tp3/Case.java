package tp.tp3;

public class Case {
    private boolean couleur;
    Pieces piece; // null si la case est vide

    public Pieces getPiece(){
        return this.piece;
    }
    public boolean estVide(){
        return piece==null;
    }
    public void remplirPiece(Pieces p){
        this.piece = p;
    }
    public void enleverPiece(){
        this.piece = null;
    }
}
