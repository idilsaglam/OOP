package tp.tp1.exercice5;

import java.util.Random;

public class Personnage extends Informations {


    public Personnage(int v, int f, int a) {
        super(v, f, a);
    }

    public boolean estVivant(){
        return this.getVitalite() >0;
    }

    public void rebirth(){

    }

    public void attaque(Personnage def){
        Random rd = new Random();
        int n = rd.nextInt(Math.max(1,(this.getForce()-def.getForce())));
        if(def.getAgilite() < this.getAgilite()){
            def.setVivalite(def.getVitalite()-n);
        }else{
            def.setVivalite(def.getVitalite()-n/2);
            def.setAgilite(def.getAgilite()/3);
        }
    }
}
