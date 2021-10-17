package tp.tp4;

import jdk.jfr.Unsigned;

import java.util.ArrayList;

public class TitreEstAPeuPres implements Predicat {

    private final String titre;
    @Unsigned
    private final int distance;

    public TitreEstAPeuPres(String titre, int distance) {
        this.titre = titre;
        this.distance = distance;
    }

    public static int distanceLevenshtein(String mot1, String mot2) {
        if (Math.min(mot1.length(), mot2.length()) == 0) {
            return Math.max(mot1.length(), mot2.length());
        }
        if (mot1.charAt(0) == mot2.charAt(0)) {
            return TitreEstAPeuPres.distanceLevenshtein(mot1.substring(1), mot2.substring(1));
        }
        ArrayList<Integer> results = new ArrayList<Integer>();
        results.add(TitreEstAPeuPres.distanceLevenshtein(mot1.substring(1), mot2));
        results.add(TitreEstAPeuPres.distanceLevenshtein(mot1, mot2.substring(1)));
        results.add(TitreEstAPeuPres.distanceLevenshtein(mot1.substring(1), mot2.substring(1)));
        return 1 + results.stream().reduce(Integer.MAX_VALUE, Math::min);
    }

    @Override
    public boolean estVrai(Media m) {
        return TitreEstAPeuPres.distanceLevenshtein(this.titre, m.getTitre()) == this.distance;
    }
}
