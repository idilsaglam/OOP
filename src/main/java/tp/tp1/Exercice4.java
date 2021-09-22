package tp.tp1;
import java.util.Random;
import java.util.Scanner;

public class Exercice4 {
    /**
     * Exercice 4.1
     * Une fonction qui choisit deux nombres aléatoires entre 1 et 9 et demande à l’utilisateur le résultat de leur
     * multiplication.
     * @return  le nombre de tentatives qui ont été nécessaires pour trouver la bonne réponse.
     */
    public static int question(){

        int tentative = 0;

        Random rd = new Random();
        int nb1 = rd.nextInt(10);
        int nb2 = rd.nextInt(10);

        Scanner sc = new Scanner(System.in);
        System.out.println(nb1 +" * "+nb2+" ?");
        int r = sc.nextInt();

        if(r != nb1*nb2){
            tentative++;
            question();
        }

        return tentative;

    }

    /*
     * Exercice 4.2
     * Une fonction qui interroge l’utilisateur n fois sur ses tables de multiplication, puis retourne une note entre
     * 0 et 20 (chaque mauvaise réponse fait perdre un point).
     * @param n
     * @return
     */
    public int evaluation(int n){

    }

    public static void main(String[] args){
        question();
    }
}
