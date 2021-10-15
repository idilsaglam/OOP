package tp.tp4;

public class Dictionnaire extends Media{
    private String langage;
    private int nbTomes;
    public Dictionnaire(String langage, int nbTomes,String nom){
        super(nom);
        this.langage = langage;
        this.nbTomes = nbTomes;
    }
    public String getLangage(){ return this.langage;}
    public int getNbTomes(){return this.nbTomes;}

    public void setLangage(String langage) {
        this.langage = langage;
    }

    public void setNbTomes(int nbTomes) {
        this.nbTomes = nbTomes;
    }

    @Override
    public String toString(){
        return "Dictionnaire : "+ super.toString();
    }
}
