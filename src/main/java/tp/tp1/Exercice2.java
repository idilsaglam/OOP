package tp.tp1;

public class Exercice2 {


    /**
     * Exercice 2.1
     * Cette fonction permets d'afficher un tableau entier qui est passé en paramètre.
     * @param tab un tableau entier que nous allons afficher ses éléments.
     */
    public static void affiche(int[] tab){
        for(int i=0; i<tab.length; i++){ // Nous allons parcourir toutes les cases pour faire l'affichage.
            System.out.println(tab[i]);
        }
    }

    /**
     * Une fonction qui fait la multiplication entre les 2 tableaux qui ont les mêmes tailles
     * @param tab1
     * @param tab2
     * @return un tableau d'entier qui est la multiplication de deux tableaux qui est passé en paramètre.
     */
    public static int[] arrayMultiplication(int[] tab1,int[] tab2){
        if(tab1.length != tab2.length){ return null;}  // Si les deux tableaux sont null ou s'ils n'ont pas le même taille la fonction va retourner null.
        int[] res = new int[tab2.length];
        for(int i=0; i< tab1.length; i++){
            res[i]= tab2[i]*tab1[i];
        }
        return res;
    }

    /**
     * Une fonction qui copie le tableau qui est passé en paramètre  et qui ajoute n fois 1 à la fin du tableau.
     * @param tab
     * @param num
     * @return un tableau d'entier qui est composé du tableau qui est passé en paramètre avec les 1
     */
    public static int[] add1(int[] tab,int num ){
        if(num<=0){return tab;}

        int[] res = new int[tab.length+num];

        for(int i=0; i<tab.length; i++){
            res[i] = tab[i];
        }
        for(int j= tab.length; j<res.length; j++){
            res[j] = 1;
        }
        return res;
    }

    /**
     * Exercice 2.2
     * Une fonction qui prend en entrée deux tableaux d’entiers t1 et t2 (de taille n1 et n2)
     * @param tab1
     * @param tab2
     * @return un tableau t3 de taille max(n1, n2) obtenu en multipliant t1 et t2 case par case.
     */
    public static int[] multiplication(int[] tab1, int[] tab2){
        if(tab1.length > tab2.length){ // Si le taille de tab1 est plus grande que tab2, comme dans la multiplication
            // le chiffre 1 est neutre; nous allons ajouter le chiffre 1  à la fin du tableau tab2 jusqu'aux les deux
            // tableaux ont la même taille
            add1(tab2, tab1.length-tab2.length); // Pour pouvoir le faire, nous appelons le fonction add1 qui est
            // déclaré dans la meme classe.
        }else{ // Si le taille de tab2 est plus grande que tab1, comme dans la multiplication
            // le chiffre 1 est neutre; nous allons ajouter le chiffre 1  à la fin du tableau tab1 jusqu'aux les deux
            // tableaux ont la même taille
            add1(tab1, tab2.length-tab1.length); // Pour pouvoir le faire, nous appelons le fonction add1 qui est
            // déclaré dans la meme classe.
        }

        return arrayMultiplication(tab1,tab2); // Maintenant on a deux tableaux qui ont le même taille. Pour pouvoir
        // faire la multiplication nous allons appeler la fonction arrayMultiplication qui fait la multiplication entre
        // des tableaux d'entiers qui ont le même taille et nous allons retourner la réponse de cette fonction.
    }

    /*
     * Exercice 2.3
     * String.valueOf(n):
     * https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/lang/String.html#valueOf(int)
     *
     * Character.getNumericValue(c):
     * https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/lang/Character.html#getNumericValue(char)
     */


    /**
     * Exercice 2.4
     * @param t
     * @return le tableau obtenu en séparant des chiffres.
     */
    public int[] split(int[] t){
        String s = "";

        // Nous allons faire une concatenation pour chaque case du tableau t.
        for(int i=0; i<t.length; i++){
            s+=""+t[i];
        }

        // Nous allons créer un tableau qui a une taille de la chaîne de caractère s.
        int[] res = new int[s.length()];

        // Nous allons parcourir toutes les lettres de la chaîne de caractère s.
        for(int j=0; j<s.length();j++){
            // Nous allons ajouter les caractères au tableau d'entier. Pour faire cela, il
            // faut que nous transformons les caractères en entier.
            res[j] = Character.getNumericValue(s.charAt(j)); // Pour le faire, nous utilisons le fonction getNumericValue
            // qui transforme le caractère qui est donné en paramètre en entier.
        }
        return res;
    }
}
