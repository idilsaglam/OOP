package idilsaglam.tp.tp6;

public abstract class Figure {
    //coordonnées du centre approximatif de la figure
    private int posX;
    private int posY;

    public Figure(int x, int y){
        this.posX = x;
        this.posY = y;
    }

    public int getPosX(){
        return this.posX;
    }
    public int getPosY(){
        return this.posY;
    }
    public abstract void affiche();
    public abstract double estDistantDe(Figure fig);
    public abstract double surface();
    public void deplacement(int x, int y){
        this.posX = x;
        this.posY = y;
    }
}
