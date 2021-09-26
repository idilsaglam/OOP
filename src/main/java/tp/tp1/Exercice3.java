package tp.tp1;

public class Exercice3 {
  public static String changer(String s) {
    Character[] voyelles = new Character[] {'a', 'e', 'i', 'o', 'u', 'y'};
    for (int i = 0; i < s.length(); i++) {
      for (int j = 0; j < voyelles.length; j++) {
        if (s.charAt(i) == voyelles[j]) {
          s = s.substring(0, i) + voyelles[(j + 1) % voyelles.length] + s.substring(i + 1);
          // Comme on a trouvé la voyelle qu'on cherche on peut arrêter d'itérer sur le tableau des voyelles
          break;
        }
      }
    }
    return s;
  }

  public static void main(String[] args) {
    for (int i = 0; i < args.length; i++) {
      System.out.println(changer(args[i].toLowerCase()));
    }
  }
}