package idilsaglam.tp.tp6;

public class Circle extends Figure {
    private final double rayon;
    public Circle(double rayon, int posX, int posY){
        super(posX,posY);
        this.rayon = rayon;
    }

    public double getRayon() {
        return rayon;
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
