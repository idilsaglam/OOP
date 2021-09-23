package tp.tp1;
import java.util.Random;
import java.util.Scanner;

public class Exercice4 {

    public static int tentative(int expected, Scanner sc){
        return 1 +
                (
                        sc.nextInt() == expected ?
                                0 :
                                tentative(expected,sc)
                );
    }

    /**
     * Exercice 4.1
     * Une fonction qui choisit deux nombres aléatoires entre 1 et 9 et demande à l’utilisateur le résultat de leur
     * multiplication.
     * @return  le nombre de tentatives qui ont été nécessaires pour trouver la bonne réponse.
     */
    public static int question(){

        Random rd = new Random();
        int nb1 = rd.nextInt(9)+1;
        int nb2 = rd.nextInt(9)+1;

        return tentative(nb1*nb2,new Scanner(System.in));
    }


    /*
     * Exercice 4.2
     * Une fonction qui interroge l’utilisateur n fois sur ses tables de multiplication, puis retourne une note entre
     * 0 et 20 (chaque mauvaise réponse fait perdre un point).
     * @param n
     * @return
     */
    public static int evalError(int n){
        if(n==1){
            return question() - 1;
        }
        return question()-1+evalError(n-1);
    }

    public static int evaluation(int n){
        return 20-evalError(n);
    }

    public static void main(String[] args){
        question();
    }
}
