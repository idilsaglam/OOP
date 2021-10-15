package tp.tp4;

import java.util.LinkedList;

public class Media {
    LinkedList<Media> baseDeDonnees;
    private String titre;
    private static int counter;
    private int id = 0;
    public Media(String titre){
        this.titre = titre;
        this.id = Media.counter;
        Media.counter++;
    }
    public void setTitre(String titre){
        this.titre = titre;
    }
    public int getNumber(){
        return Media.counter;
    }

    @Override
    public String toString(){
        return "Titre est "+titre+" id number is "+Media.counter;
    }

    /**
     * Exercice 1.4
     * Une fonction qui vérifie que le numéro d'enregistrement de l'instance courante est plus petit que celui de doc
     * @param doc
     * @return true si le numéro de l'instance courante est plus petite que celui de doc
     */
    public boolean plusPetit(Media doc){
        return this.id<doc.getNumber();
    }

    public static void main(String[] args){

    }
}
