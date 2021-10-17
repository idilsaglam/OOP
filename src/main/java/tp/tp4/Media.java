package tp.tp4;


// La classe media doit être abstrait comme on ne l'instancierais jamais.
abstract public class Media implements Comparable<Media> {
    private static int counter = 0;

    private final String titre;
    private final int id;

    /**
     * Fonction instancie une nouvelle instance de la classe Media
     * @param titre Le titre du media
     */
    public Media(String titre){
        this.titre = titre;
        this.id = Media.counter;
        Media.counter++;
    }

    // La fonction ordreMedia doit être une méthode d'instance abstraite pour que tous les sous-classes doivent obligatoirement le définir.
    /**
     * La méthode associe un nombre entier en fonction du type de media.
     * @return Un entier associé au type de media.
     */
    abstract public int ordreMedia();

    /**
     * Fonction retourne le numéro de média
     * @return Le numéro de média courant
     */
    public int getNumero(){
        return this.id;
    }

    /**
     * Fonction retourne le titre du média
     * @return Le titre du média courant
     */
    public String getTitre() {
        return this.titre;
    }

    @Override
    public String toString(){
        return String.format("titre: %s id: %d", this.titre, this.id);
    }

    /**
     * Exercice 1.4
     * Une fonction qui vérifie que le numéro d'enregistrement de l'instance courante est plus petit que celui de doc
     * @param doc
     * @return true si le numéro de l'instance courante est plus petite que celui de doc
     */
    public boolean plusPetit(Media doc){
        if (this.ordreMedia() == doc.ordreMedia()) {
            // Si les deux ont le même type
            return this.id < doc.getNumero();
        }
        // S'ils sont des types différents nous nous les comparons par leurs types
        return this.ordreMedia() < doc.ordreMedia();
    }

    @Override
    public int compareTo(Media m){
        if(this.ordreMedia() == m.ordreMedia()){
            return this.getNumero()-m.getNumero();
        }
        return this.ordreMedia()-m.ordreMedia();
    }


   /*
   Cette fonction n'a aucune utilité
   public boolean plusPetit(Livre doc){
        return this.id < doc.getNumero();
    }
*/

}
