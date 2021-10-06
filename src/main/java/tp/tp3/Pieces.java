package tp.tp3;

public class Pieces {
    private boolean couleur; // true blanc, faux noir
    private String nom;

    public Pieces(boolean couleur, String nom){
        this.couleur = couleur;
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString(){
        char c = this.nom.charAt(0);
        if(this.couleur){
            return ""+ Character.toLowerCase(c);
        }
        return ""+Character.toUpperCase(c);
    }
}
