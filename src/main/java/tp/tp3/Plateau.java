package tp.tp3;

public class Plateau {
    private int longueur;
    private int largeur;
    private Case[][] cases;

    public Plateau(int longueur, int largeur){
        cases= new Case[longueur][largeur];
        cases[0][0] = new Case(false); // case (0,0) est noire
    }

    public boolean horsLimite(int x, int y){
        return cases[x][y] != null;
    }

    public Case getCase(int x, int y){
        if(horsLimite(x,y)){
            return cases[x][y];
        }
        return null;
    }

    public void videCase(int x, int y){
        if(horsLimite(x,y)){
            cases[x][y] = null;
        }
    }

    public void remplirCase(int x, int y, Pieces p){
        if(horsLimite(x,y) && cases[x][y] == null){
            cases[x][y] = new Case(p);
        }
    }

    public void afficher(){

    }
}
