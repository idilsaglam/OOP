package tp.tp1.exercice5;

public class Informations {

    private int vivalite;
    private int force;
    private int agilite;

    public Informations(int v, int f, int a){
        this.vivalite = v;
        this.force = f;
        this.agilite = a;
    }
    public  Informations(Informations inf){

    }

    public int getVitalite(){
        return this.vivalite;
    }
    public int getForce(){
        return this.force;
    }
    public int getAgilite(){
        return this.agilite;
    }

    public String toString(){

    }
}
