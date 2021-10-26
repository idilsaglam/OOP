package idilsaglam.tp.tp6;

public class Carre extends Figure{
    private final double cote;
    public Carre(double cote, int posX, int posY){
        super(posX,posY);
        this.cote = cote;
    }

    public double getCote() {
        return cote;
    }

    @Override
    public void affiche() {

    }
}
