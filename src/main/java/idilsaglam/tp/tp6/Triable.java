package idilsaglam.tp.tp6;

public interface Triable {
    // échange les éléments en positions i et j
    void echange(int i, int j);
    // retourne vrai si l'élément de position i est plus grand que
    // l'élément de position j
    boolean plusGrand(int i, int j);
    // nombre d'éléments à trier
    int taille();
    static void triBulles(Triable t){
        
    }
}
