package tp.tp1.exercice5;

import java.util.Random;

public class Personnage {
    private String nom;
    private final Informations initialInformations, currentInformations;

    public Personnage(String nom, Informations initialInformations, Informations currentInformations) {
        this.nom = nom;
        this.initialInformations = initialInformations;
        this.currentInformations = currentInformations;
    }

    @Override
    public String toString() {
        return String.format(
                "Nom: %s, Etat initiale: %s Etat actuel: %s",
                this.nom,
                this.initialInformations.toString(),
                this.currentInformations.toString()
        );
    }

    /**
     * Fonction qui vérifie si la vitalité de l'état actuel est supérieur à 0
     * @return true si la vitalité à l'état actuel est supérieur à 0
     */
    public boolean estVivant(){
        return this.currentInformations.getVitalite() > 0;
    }

    /**
     * Fonction qui restore la vitalité de l'état actuel avec celui de l'état initial
     */
    public void rebirth(){
         this.currentInformations.setVivalite(this.initialInformations.getVitalite());
    }

    /**
     * Fonction qui permet d'attaquer au Personnage def
     * @param def Le personnage défenseur à ataquer
     */
    public void attaque(Personnage def){
        Random rd = new Random();
        int n = rd.nextInt(Math.max(1,(this.currentInformations.getForce()-def.currentInformations.getForce())));
        if(def.currentInformations.getAgilite() < this.currentInformations.getAgilite()){
            def.currentInformations.setVivalite(def.currentInformations.getVitalite()-n);
            return;
        }
        def.currentInformations.setVivalite(def.currentInformations.getVitalite()-n/2);
        def.currentInformations.setAgilite(def.currentInformations.getAgilite()/3);
    }
}
