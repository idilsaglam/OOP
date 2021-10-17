package tp.tp4;

public class DictionnaireBilingue extends Dictionnaire {

    private final String langageDest;

    public DictionnaireBilingue(String nom, String langue, int nbTomes, String langueDest) {
        super(langue, nbTomes, nom);
        this.langageDest = langueDest;
    }

    @Override
    public int ordreMedia() {
        return 1;
    }

    // TODO: Complete with getters and toString

}
