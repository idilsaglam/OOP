package idilsaglam.tp.tp6;

public class Rectangle extends Figure {
    private final double largeur;
    private final double hauteur;

    public Rectangle(double largeur, double hauteur,int centreX,int centreY){
        super(centreX,centreY);
        this.hauteur = hauteur;
        this.largeur = largeur;
    }

    public double getHauteur() {
        return hauteur;
    }

    public double getLargeur() {
        return largeur;
    }

    @Override
    public void affiche() {

    }
}
