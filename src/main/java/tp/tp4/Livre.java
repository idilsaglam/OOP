package tp.tp4;

public class Livre extends Media{
    private final String nomAuteur;
    private final int nbPages;

    /**
     * Fonction crée une nouvelle instance de la classe Livre
     * @param nom Le nom de livre
     * @param nomAuteur Le nom d'auteur du livre
     * @param nbPages Le nombre de pages de livre
     */
    public Livre(String nom, String nomAuteur, int nbPages){
        super(nom);
       this.nomAuteur = nomAuteur;
       this.nbPages = nbPages;
    }

    /**
     * Fonction retourne le nom d'auteur du livre
     * @return Le nom d'auteur du livre
     */
    public String getNomAuteur() {
        return this.nomAuteur;
    }

    /**
     * Fonction retourne le nombre de pages du livre
     * @return Le nombre de pages du livre
     */
    public int getNbPages() {
        return this.nbPages;
    }


/*
    Avec la présence de ordreMedia nous avons plus besoin de cette fonction
    @Override
    public boolean plusPetit(Media doc){
        if(doc instanceof Livre){
            return super.plusPetit(doc);
        }
        return true;
    }
    */

    @Override
    public int ordreMedia() {
        return 100;
    }

    @Override
    public String toString(){
        return String.format("Livre: auteur: %s, nombre de pages %d, %s", this.nomAuteur, this.nbPages, super.toString());
    }
}
