package tp.tp4;

import java.util.ArrayList;
import java.util.LinkedList;

public class Media implements Comparable<Media> {
    LinkedList<Media> baseDeDonnees;
    private String titre;
    private static int counter;
    private int id = 0;
    public Media(String titre){
        this.titre = titre;
        this.id = Media.counter;
        Media.counter++;
        baseDeDonnees = new LinkedList<>();
    }
    public void setTitre(String titre){
        this.titre = titre;
    }
    public int getNumero(){
        return this.id;
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
        return this.id<doc.getNumero();
    }

    public boolean plusPetit(Livre doc){
        return this.id<doc.getNumero();
    }

    public void ajouter(Media doc){
        for(int i=0; i<baseDeDonnees.size();i++){
            if(doc.compareTo(this.baseDeDonnees.get(i))<0){
                this.baseDeDonnees.add(i,doc);
                break;
            }
        }
    }
    @Override
    public int compareTo(Media m){
        return this.getNumero()-m.getNumero();
    }

    /**
     * Une méthode qui imprime tous les dictionnaires
     */
    public void tousLesDictionnaires(){
        for(int i=0; i<baseDeDonnees.size();i++){
            if(this.baseDeDonnees.get(i) instanceof Dictionnaire){
                //TODO
                System.out.println(this.baseDeDonnees.get(i).toString());
            }
        }
    }

    /**
     * Une méthode qui qui retourne tous les médias pour lesquels p est vrai
     * @param p
     * @return true si tous les médias pour lesquels p est vrai sinon false
     */
    public ArrayList<Media> recherche(Predicat p){
        ArrayList<Media> a = new ArrayList<>();
        for(int i=0; i<baseDeDonnees.size(); i++){
            if(p.estVrai(baseDeDonnees.get(i))){
                a.add(baseDeDonnees.get(i));
            }
        }
        return a;
    }


    public static void main(String[] args){
        Media m = new Media("media");
        System.out.println(m.toString());
        Livre l = new Livre("Livre1","Idil Saglam","Turc",10);
        System.out.println(l.toString());
        Film f = new Film(105,"Kaan Yagci","Francais","Duduk Idik");
        System.out.println(f.toString());
        Dictionnaire d = new Dictionnaire("Japonais",300,"dict");
        System.out.println(d.toString());
        m.ajouter(l);
        m.ajouter(f);
        m.ajouter(d);
        m.tousLesDictionnaires();

    }
}
