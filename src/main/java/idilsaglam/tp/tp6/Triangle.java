package idilsaglam.tp.tp6;

public class Triangle extends Figure {
    private final double base;
    private final double hauteur;

    public Triangle(double base, double hauteur, int posX, int posY){
        super(posX,posY);
        this.base = base;
        this.hauteur = hauteur;
    }

    public double getHauteur() {
        return hauteur;
    }

    public double getBase() {
        return base;
    }

    @Override
    public void affiche() {

    }

    @Override
    public double estDistantDe(Figure fig) {
        return 0;
    }

    @Override
    public double surface() {
        return 0;
    }
}
