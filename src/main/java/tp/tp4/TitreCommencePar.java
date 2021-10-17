package tp.tp4;

public class TitreCommencePar implements Predicat {
    private char lettre;

    public TitreCommencePar(char lettre) {
        this.lettre = lettre;
    }

    @Override
    public boolean estVrai(Media m) {
        return m.getTitre().toLowerCase().charAt(0) == Character.toLowerCase(this.lettre);
    }
}
