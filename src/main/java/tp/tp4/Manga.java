package tp.tp4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Manga extends Media {
    private final String dessinateur, editeur;
    private final int nbVolumes;
    private final Date sortieInitial;
    private final static SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * Fonction instancie une nouvelle objet de la classe MAnge
     * @param dessinateur Le nom de dessinateur
     * @param editeur Le nombre d'éditeur
     * @param nbVolumes Le nombre de volumes*
     * @param sortieInitial La date de sortie initial
     */
    public Manga(String nom, String dessinateur, String editeur, int nbVolumes, Date sortieInitial) {
        super(nom);
        this.dessinateur = dessinateur;
        this.editeur = editeur;
        this.nbVolumes = nbVolumes;
        this.sortieInitial = sortieInitial;
    }

    /**
     * Fonction instancie une nouvelle instance de la classe Mange
     * @param dessinateur Le nom de dessinateur
     * @param editeur Le nombre d'éditeur
     * @param nbVolumes Le nombre de volumes** @param sortieInitial
     * @param sortieInitial Une chaîne de caractères du format dd/MM/yyyy pour la date de sortie initiale
     * @throws ParseException Quand la chaîne de caractère n'est pas sous forme de dd/MM/yyyy
     */
  public Manga(String nom, String dessinateur, String editeur, int nbVolumes, String sortieInitial) throws ParseException {
      this(nom, dessinateur, editeur, nbVolumes, Manga.df.parse(sortieInitial));
  }

    @Override
    public int ordreMedia() {
        return 50;
    }

    @Override
    public String toString() {
      return String.format("Manga dessinateur %s, editeur %s, nombre de volumes %d, date de sortie initiale %s. %s",
              this.dessinateur,
              this.editeur,
              this.nbVolumes,
              Manga.df.format(this.sortieInitial),
              super.toString()
      );
  }
}
