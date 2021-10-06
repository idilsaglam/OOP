package tp.tp3;

public class Case {
    private boolean couleur;
    Pieces piece; // null si la case est vide

    public Case(boolean couleur){
        this.couleur = couleur;
    }
    public Case(Pieces piece){
        this.piece = piece;
    }
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

    @Override
    public String toString(){
        // si la case n'est pas vide
        if(!this.estVide()){
            // Nous retournons la lettre initiale de la pièce.
            return "" +this.piece.getNom().charAt(0);
        }
        // si la case est vide et la couleur est blanche
        if(this.couleur){
            return "-";
        }
        // si la case est vide et la couleur est noir
        return "*";
    }
}
