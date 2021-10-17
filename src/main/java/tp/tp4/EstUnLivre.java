package tp.tp4;

public class EstUnLivre implements Predicat {

    @Override
    public boolean estVrai(Media m) {
        return m instanceof Livre;
    }
}
