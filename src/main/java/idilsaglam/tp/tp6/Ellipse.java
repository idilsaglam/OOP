package idilsaglam.tp.tp6;

public class Ellipse extends Figure{
    private final double grand_rayon;
    private final double petit_rayon;

    public Ellipse(double grand_rayon, double petit_rayon, int posX,int posY){
        super(posX,posY);
        this.grand_rayon = grand_rayon;
        this.petit_rayon = petit_rayon;
    }

    public double getGrand_rayon(){ return this.grand_rayon;}

    public double getPetit_rayon() {
        return petit_rayon;
    }

    @Override
    public void affiche() {

    }
}
