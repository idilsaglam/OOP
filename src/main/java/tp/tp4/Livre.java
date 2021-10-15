package tp.tp4;

public class Livre extends Media{
    private String nomAuteur;
    private String langue;
    private int nbPages;
    public Livre(String nom, String nomAuteur,String langue, int nbPages){
        super(nom);
       this.nomAuteur = nomAuteur;
       this.langue = langue;
       this.nbPages = nbPages;
    }
    public String getNomAuteur() {
        return nomAuteur;
    }

    public void setNomAuteur(String nomAuteur) {
        this.nomAuteur = nomAuteur;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public int getNbPages() {
        return nbPages;
    }

    public void setNbPages(int nbPages) {
        this.nbPages = nbPages;
    }

    public boolean plusPetit(Media doc){
        if(doc instanceof Livre){
            return super.plusPetit(doc);
        }
        return true;
    }
    @Override
    public String toString(){
        return "Livre : "+ super.toString();
    }
}
