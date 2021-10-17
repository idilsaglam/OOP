package tp.tp4;

public class TitreContiensSousChaine implements  Predicat{

    private final String sousChaine;

    public TitreContiensSousChaine(String sousChaine) {
        this.sousChaine = sousChaine;
    }


    @Override
    public boolean estVrai(Media m) {
        return m.getTitre().contains(this.sousChaine);
    }
}
